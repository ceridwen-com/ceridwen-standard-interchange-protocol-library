/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.messages;

import org.apache.commons.logging.*;
import java.io.*;
import org.apache.commons.beanutils.*;
import java.beans.*;
import java.util.*;
import com.ceridwen.circulation.SIP.helpers.*;
import java.text.SimpleDateFormat;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.*;

public abstract class Message implements Serializable {
  private static Log log = LogFactory.getLog(Message.class);

    private static Class[] _messages = {
        PatronStatusRequest.class,
        PatronStatusResponse.class,
        CheckOut.class,
        CheckOutResponse.class,
        CheckIn.class,
        CheckInResponse.class,
        BlockPatron.class,
        SCStatus.class,
        ACSStatus.class,
        Login.class,
        LoginResponse.class,
        PatronInformation.class,
        PatronInformationResponse.class,
        EndPatronSession.class,
        EndSessionResponse.class,
        FeePaid.class,
        FeePaidResponse.class,
        ItemInformation.class,
        ItemInformationResponse.class,
        ItemStatusUpdate.class,
        ItemStatusUpdateResponse.class,
        PatronEnable.class,
        PatronEnableResponse.class,
        Hold.class,
        HoldResponse.class,
        Renew.class,
        RenewResponse.class,
        RenewAll.class,
        RenewAllResponse.class
    };

  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
    ois.defaultReadObject();
  }

  private void writeObject(ObjectOutputStream oos) throws IOException {
    oos.defaultWriteObject();
  }
  public abstract String getCommand();

  private String mangleDate(Date date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd    HHmmss");
    return sdf.format(date);
  }

  private Date demangleDate(String date) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd    HHmmss");
    try {
      return sdf.parse(date);
    } catch (Exception ex) {
      return null;
    }
  }

  private String getProp(PropertyDescriptor desc) {
    String ret = null;
    try {
      Object value = desc.getReadMethod().invoke(this, new Object[0]);
      if (desc.getPropertyType() == Boolean.class) {
        if (value == null)
          if (desc.getName().equalsIgnoreCase("magneticMedia"))
            ret = "U";
          else
            ret = "N";
        else if (desc.getName().equalsIgnoreCase("ok")) {
          ret = ((Boolean)value).booleanValue()?"1":"0";
        } else {
          ret = ((Boolean)value).booleanValue()?"Y":"N";
        }
      } else if (desc.getPropertyType() == Date.class) {
        ret = mangleDate((Date)value);
      } else {
        ret = value.toString();
      }
    } catch (Exception ex) {

    }

    return (ret != null)?ret:"";
  }

  private String pad(String input, FixedFieldDescriptor field) {
    StringBuffer ret = new StringBuffer();

    ret.append(input);

    while (ret.length() <= (field.end - field.start)) {
      ret.append(" ");
    }

    return ret.toString();
  }

  public String encode(Character sequence) throws MandatoryFieldOmitted {
    TreeMap fixed = new TreeMap();
    TreeMap variable = new TreeMap();
    StringBuffer message = new StringBuffer();

    PropertyDescriptor[] descs = PropertyUtils.getPropertyDescriptors(this);

    for (int n = 0; n < descs.length; n++) {
      PropertyDescriptor desc = descs[n];
      Object SIPField = desc.getValue("SIPFieldDescriptor");
      if (SIPField.getClass().equals(FixedFieldDescriptor.class)) {
        FixedFieldDescriptor field = (FixedFieldDescriptor) SIPField;
        String value = getProp(desc);
        if (value.length() == 0) {
          if (!field.allowBlank) {
            throw new MandatoryFieldOmitted();
          }
        }
        fixed.put(new Integer(field.start), pad(value, field));
      }
      if (SIPField.getClass().equals(VariableFieldDescriptor.class)) {
        VariableFieldDescriptor field = (VariableFieldDescriptor) SIPField;
        String value = getProp(desc);
        if (value.length() > 0) {
          variable.put(field.ID, value);
        }
        else if (field.required) {
          variable.put(field.ID, value);
        }
      }
    }

    message.append(this.getCommand());

    Iterator fixedIterate = fixed.keySet().iterator();
    while (fixedIterate.hasNext()) {
        Integer key = (Integer)fixedIterate.next();
        message.append(fixed.get(key));
    }

    Iterator varIterate = variable.keySet().iterator();
    while (varIterate.hasNext()) {
        String key = (String)varIterate.next();
        message.append(key);
        message.append(variable.get(key));
        message.append(VariableFieldDescriptor.TERMINATOR);
    }

    if (sequence != null)
      return AddChecksum(message.toString(), sequence.charValue());
    else
      return message.toString();
  }

  private void setProp(PropertyDescriptor desc, String value) {
    try {
      if (desc.getPropertyType() == Boolean.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {value.equalsIgnoreCase("U") ? null :
                                     new Boolean(value.
                                                 equalsIgnoreCase("Y") ||
                                                 value.equalsIgnoreCase("1"))});
      }
      if (desc.getPropertyType() == Date.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {demangleDate(value)});
      }
      if (desc.getPropertyType() == Integer.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {new Integer(value)});
      }
      if (desc.getPropertyType() == String.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {new String(value)});
      }
    }
    catch (Exception ex) {

    }

  }

  public static Message decode(String message, Character sequence) throws ChecksumError, MandatoryFieldOmitted {

    if (sequence != null) {
      if (!CheckChecksum(message, sequence.charValue())) {
        return null;
      }
    }
    String command = message.substring(0, 2);
    try {
      Message msg = (Message)((Class) messages.get(command)).newInstance();
      PropertyDescriptor[] descs = PropertyUtils.getPropertyDescriptors(msg);

      int fixedFieldEnd = 2;

      for (int n = 0; n < descs.length; n++) {
        PropertyDescriptor desc = descs[n];
        Object SIPField = desc.getValue("SIPFieldDescriptor");
        String value = "";
        if (SIPField != null) {
          if (SIPField.getClass() == FixedFieldDescriptor.class) {
            FixedFieldDescriptor field = (FixedFieldDescriptor) SIPField;
            value = message.substring(field.start, field.end + 1);
            msg.setProp(desc, value);
            if (fixedFieldEnd < field.end) {
              fixedFieldEnd = field.end;
            }
          }
        }
      }

      Hashtable fields = msg.parseVarFields(fixedFieldEnd + 1, message);

      for (int n = 0; n < descs.length; n++) {
        PropertyDescriptor desc = descs[n];
        Object SIPField = desc.getValue("SIPFieldDescriptor");
        String value = "";
        if (SIPField != null) {
          if (SIPField.getClass().equals(VariableFieldDescriptor.class)) {
            VariableFieldDescriptor field = (VariableFieldDescriptor) SIPField;
            value = (String) fields.get(field.ID);
            msg.setProp(desc, value);
          }
        }
      }

      return msg;
    } catch (Exception ex) {
      return null;
    }
  }

  private static boolean CheckChecksum(String message, char sequence) {
    /**@todo add checksum checking
     *
     */


    return true;
  }

  private String AddChecksum(String command, char sequence) {
    StringBuffer check = new StringBuffer();
    int checksum = 0;

    check.append("AY");
    check.append(sequence);
    check.append("AZ");
    try {
      String data = command + check.toString();
      byte[] bytes = data.getBytes("ASCII");

      for (int n = 0; n < bytes.length; n++) {
        checksum += bytes[n];
      }
      checksum = -checksum & 0xffff;
      check.append(Integer.toHexString(checksum).toUpperCase());
    }
    catch (Exception e) {
    }
    return command + check.toString();
  }

  private Hashtable parseVarFields(int offset, String data) {
    Hashtable fields = new Hashtable();
    int status = 1;
    StringBuffer fieldtag = new StringBuffer();
    StringBuffer fielddata = new StringBuffer();

    for (int n = offset; n < data.length(); n++) {
      if (status == 1) {
        fieldtag = new StringBuffer();
        fieldtag.append(data.charAt(n));
        status = 2;
      }
      else if (status == 2) {
        fielddata = new StringBuffer();
        fieldtag.append(data.charAt(n));
        status = 3;
      }
      else if (status == 3) {
        if (data.charAt(n) == VariableFieldDescriptor.TERMINATOR) {
          fields.put(fieldtag.toString(), fielddata.toString());
          status = 1;
        }
        else {
          fielddata.append(data.charAt(n));
        }
      }
    }
    return fields;
  }

  public void xmlEncode(OutputStream strm) {
      XMLEncoder out = new XMLEncoder(strm);
      out.writeObject(this);
      out.flush();
  }

  public static Message xmlDecode(InputStream strm) {
      XMLDecoder in = new XMLDecoder(strm);
      return (Message)in.readObject();
  }

  private static Hashtable messages = new Hashtable();

  static {
    com.ceridwen.util.versioning.ComponentRegistry.registerComponent(Message.class);

    int n;
    for (n = 0; n < _messages.length; n++) {
      try {
        messages.put(_messages[n].getMethod("getCommand", new Class[] {}).
                     invoke(_messages[n].newInstance(), new Object[] {}),
                     _messages[n]);
      }
      catch (Exception ex) {
        log.warn(_messages[n].getName() + " not yet implemented.");
      }
    }
  }

  public String toString() {
    ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
    xmlEncode(buffer);
    return new String(buffer.toByteArray());
  }
}
