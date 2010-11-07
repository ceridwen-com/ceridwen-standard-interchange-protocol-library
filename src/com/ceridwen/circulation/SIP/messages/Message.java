/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey (www.ceridwen.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * <http://www.gnu.org/licenses/>
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Matthew J. Dovey (www.ceridwen.com) - initial API and implementation
 ******************************************************************************/
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
import java.lang.reflect.Method;

import org.apache.commons.beanutils.*;
import java.beans.*;
import java.util.*;

import com.ceridwen.circulation.SIP.types.descriptors.FieldDescriptor;
import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;
import com.ceridwen.circulation.SIP.types.descriptors.TaggedFieldDescriptor;
import com.ceridwen.circulation.SIP.types.enumerations.AbstractEnumeration;
import com.ceridwen.circulation.SIP.types.flagfields.AbstractFlagField;

import java.text.SimpleDateFormat;
import com.ceridwen.circulation.SIP.exceptions.*;

public abstract class Message implements Serializable {
  /**
	 * 
	 */
	private static final long serialVersionUID = 1609258005567594730L;
	private static final String PROP_AUTOPOPULATE = "com.ceridwen.circulation.SIP.messages.AutoPopulationEmptyRequiredFields";
	private static Log log = LogFactory.getLog(Message.class);

    private static Class<?>[] _messages = {    	
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
        RenewAllResponse.class,
        ACSResend.class,
        SCResend.class
    };
    
    private Character SequenceCharacter = null;
    
    public Character getSequenceCharacter() {
    	return this.SequenceCharacter;
    }

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

  private String[] getProp(PropertyDescriptor desc) throws MandatoryFieldOmitted {
	  String[] ret = null;
	  FieldDescriptor SIPField = (FieldDescriptor)desc.getValue("SIPFieldDescriptor");
    String pop = System.getProperty(PROP_AUTOPOPULATE, "true");
    boolean autoPop = false;
    if (pop.equalsIgnoreCase("true") || pop.equalsIgnoreCase("on") || pop.equalsIgnoreCase("1")) {
      autoPop = true;
    }	  
	  try {
		  Object value = desc.getReadMethod().invoke(this, new Object[0]);
		  if (desc.getPropertyType() == Boolean.class) {
			  if (value == null) {
				  if (SIPField != null) {
					  if (SIPField.required != null) {
						  if (SIPField.required) {
						    if (!autoPop) {
		              throw new MandatoryFieldOmitted(desc.getDisplayName());             
						    }
							  if (desc.getName().equalsIgnoreCase("magneticMedia"))
								  ret = new String[]{"U"};
							  else {
								  if (desc.getName().equalsIgnoreCase("ok")) {
									  ret = new String[]{"0"};
								  } else {
									  ret = new String[]{"N"};
								  }                		  
							  }
						  }
					  }
				  }
			  } else if (desc.getName().equalsIgnoreCase("ok")) {
				  ret = new String[]{((Boolean)value).booleanValue()?"1":"0"};
			  } else {
				  ret = new String[]{((Boolean)value).booleanValue()?"Y":"N"};
			  }
		  } else if (desc.getPropertyType() == Date.class) {
			  if (value != null) {
				  ret = new String[]{mangleDate((Date)value)};
			  } else {
				  if (SIPField != null) {
					  if (SIPField.required != null) {
						  if (SIPField.required) {
                if (!autoPop) {
                  throw new MandatoryFieldOmitted(desc.getDisplayName());             
                }
							  ret = new String[]{mangleDate(new Date())};          		  
						  }
					  }
				  }    		
			  }
		  } else if (desc.getPropertyType() == String[].class) {
			  if (value != null) {
				  ret = (String[])value;
			  }
		  } else if (desc.getPropertyType() == Integer.class) {
			  if (value != null) {      		  
				  if (SIPField.length != null) {
					  ret = new String[]{String.format("%0" + SIPField.length + "d", value)};
				  } else {
					  ret = new String[]{value.toString()};
				  }
			  } else {
				  if (SIPField != null) {
					  if (SIPField.required != null) {
						  if (SIPField.required) {
                if (!autoPop) {
                  throw new MandatoryFieldOmitted(desc.getDisplayName());             
                }
							  if (SIPField.length != null) {
								  ret = new String[]{String.format("%0" + SIPField.length + "d", 0)};
							  } else {
								  ret = new String[]{"0"};
							  }
						  }
					  }
				  }
			  }
		  } else {
			  if (value != null) {  
				  ret = new String[]{value.toString()};
			  } else {
				  if (SIPField != null) {
					  if (SIPField.required != null) {
						  if (SIPField.required) {
                  if (!autoPop) {
                    throw new MandatoryFieldOmitted(desc.getDisplayName());             
                  }
						      Class<?>[] interfaces = desc.getPropertyType().getInterfaces();
						      for (Class<?> interfce: interfaces) {
							      if (interfce == AbstractEnumeration.class) {
							      	Method mthd = desc.getPropertyType().getDeclaredMethod("values", 
							      		  new Class[]{});
							      	Object[] values = (Object [])mthd.invoke(null, new Object[]{});
							      	if (values.length > 0) {
							      		ret = new String[]{values[0].toString()};
							      	}
							    }  	  
						      }
						  }
					  }
				  }
			  }
		  }
	  } catch (MandatoryFieldOmitted mfo) {
		  throw mfo;
	  } catch (Exception ex) {
		  log.error("Unexpected error getting " + desc.getDisplayName(), ex);
	  }

	  return (ret != null)?ret:new String[]{""};
  }

  private String pad(String input, PositionedFieldDescriptor field) {
    StringBuffer ret = new StringBuffer();

    ret.append(input);
    
    while (ret.length() <= (field.end - field.start)) {
      ret.append(" ");
    }

    return ret.toString();
  }

  public String encode(Character sequence) throws MandatoryFieldOmitted, InvalidFieldLength {
    TreeMap<Integer, String> fixed = new TreeMap<Integer, String>();
    TreeMap<String, String[]> variable = new TreeMap<String, String[]>();
    StringBuffer message = new StringBuffer();

    PropertyDescriptor[] descs = PropertyUtils.getPropertyDescriptors(this);

    for (int n = 0; n < descs.length; n++) {
      PropertyDescriptor desc = descs[n];
      FieldDescriptor SIPField = (FieldDescriptor)desc.getValue("SIPFieldDescriptor");
      if (SIPField != null) {
	      if (SIPField.getClass().equals(PositionedFieldDescriptor.class)) {
	        PositionedFieldDescriptor field = (PositionedFieldDescriptor) SIPField;
	        String[] value = getProp(desc);
	        if (value[0].length() == 0) {
	          if (field.required) {
	            throw new MandatoryFieldOmitted(desc.getDisplayName());
	          }
	        }
	        if (value[0].length() > (field.end - field.start + 1)) {
	        	throw new InvalidFieldLength(desc.getDisplayName(), (field.end - field.start + 1));
	        }
	        if (desc.getPropertyType() == Date.class || desc.getPropertyType() == Boolean.class || desc.getPropertyType() == Integer.class) {
	        	if (!(value[0].length() == 0 || value[0].length() == (field.end - field.start + 1))) {
	        		throw new java.lang.AssertionError("FixedFieldDescriptor for " + desc.getDisplayName() + " in " + this.getClass().getSimpleName() + ", start/end (" + field.start + "," + field.end + ") invalid for type " +
	    		desc.getPropertyType().getName());
	        	}
    		}
	        fixed.put(new Integer(field.start), pad(value[0], field));
	      }
	      if (SIPField.getClass().equals(TaggedFieldDescriptor.class)) {
	        TaggedFieldDescriptor field = (TaggedFieldDescriptor) SIPField;
	        String[] value = getProp(desc);
	        if (value[0].length() > 0) {
	        	if (field.length != null) {
	        		if (desc.getPropertyType() == String.class) {
	        			if (value[0].length() > field.length) {
	        	        	throw new InvalidFieldLength(desc.getDisplayName(), field.length);
	        			}
	        		} else {
	        			if (value[0].length() != field.length) {
	        	        	throw new InvalidFieldLength(desc.getDisplayName(), field.length);
	        			}	        			
	        		}
	        	}		
	        	variable.put(field.tag, value);
	        } else if (field.required) {
	          String pop = System.getProperty(PROP_AUTOPOPULATE, "true");
	          if (pop.equalsIgnoreCase("true") || pop.equalsIgnoreCase("on") || pop.equalsIgnoreCase("1")) {
	            variable.put(field.tag, value);
	          } else {
              throw new MandatoryFieldOmitted(desc.getDisplayName());	            
	          }
	        }
	      }
      }
    }

    message.append(this.getCommand());

    Iterator<Integer> fixedIterate = fixed.keySet().iterator();
    while (fixedIterate.hasNext()) {
        Integer key = (Integer)fixedIterate.next();
        message.append(fixed.get(key));
    }

    Iterator<String> varIterate = variable.keySet().iterator();
    while (varIterate.hasNext()) {
        String key = (String)varIterate.next();
        String[] values = (String[])variable.get(key);
        for (String value : values) {
	        message.append(key);
	        message.append(value);
	        message.append(TaggedFieldDescriptor.TERMINATOR);
        }
    }

    return this.AddChecksum(message.toString(), sequence);
  }

  private void setProp(PropertyDescriptor desc, String value) {
    try {
      if (desc.getPropertyType() == Boolean.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {value.equalsIgnoreCase("U") ? null :
                                     new Boolean(value.
                                                 equalsIgnoreCase("Y") ||
                                                 value.equalsIgnoreCase("1"))});
        return;
      }
      if (desc.getPropertyType() == Date.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {demangleDate(value)});
        return;
      }
      if (desc.getPropertyType() == Integer.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {new Integer(value.trim())});
        return;
      }
      if (desc.getPropertyType() == String.class) {
        desc.getWriteMethod().invoke(this,
                                     new Object[] {new String(value)});
        return;
      }
      if (desc.getPropertyType().getSuperclass() == AbstractFlagField.class) {
    	  Object data = desc.getPropertyType().getConstructor(new Class[]{String.class}).newInstance(new Object[]{new String(value)});
          desc.getWriteMethod().invoke(this,
                  new Object[] {data});    	  
          return;
      }
      Class<?>[] interfaces = desc.getPropertyType().getInterfaces();
      for (Class<?> interfce: interfaces) {
	      if (interfce == AbstractEnumeration.class) {
	      	Method mthd = interfce.getDeclaredMethod("getKey", 
	        		  new Class[]{String.class});
	      	Method mthdInst = desc.getPropertyType().getDeclaredMethod("values", 
	      		  new Class[]{});
	      	Object[] values = (Object [])mthdInst.invoke(null, new Object[]{});
	      	if (values.length > 0) {	      	
		      	Object data = mthd.invoke(values[0], 
						  new Object[]{new String(value)});
		        desc.getWriteMethod().invoke(this,
		                new Object[] {data});
		        return;
	      	}
	    }  	  
      }        
      if (desc.getPropertyType() == String[].class) {
    	  String[] current = (String[])desc.getReadMethod().invoke(this, new Object[0]);
    	  if (current == null) {
    	        desc.getWriteMethod().invoke(this,
                        new Object[] {new String[]{new String(value)}});
    	        return;
    	  } else {
    		  List<String> l = new ArrayList<String>(current.length+1);
    		  l.addAll(Arrays.asList(current));
    		  l.add(new String(value));
  	          desc.getWriteMethod().invoke(this,
                    new Object[] {l.toArray(new String[l.size()])});
  	          return;
    	  }
      }      
    }
    catch (Exception ex) {
    	log.error("Unexpected error setting " + desc.getDisplayName() + " to " + value, ex);
    }
  }

  public static Message decode(String message, Character sequence, boolean checksumCheck) throws ChecksumError, MandatoryFieldOmitted, SequenceError, MessageNotUnderstood {

    if (checksumCheck) {
      if (!CheckChecksum(message)) {
        throw new ChecksumError();
      }
    }
    Character sequenceCharacter = GetSequenceCharacter(message);
    
    if (sequence != null)
    	if (sequenceCharacter != null)
    		if (!sequence.equals(sequenceCharacter))
    			throw new SequenceError();

    if (message == null) {
    	throw new MessageNotUnderstood();
    }
    if (message.length() < 2) {
    	throw new MessageNotUnderstood();    	
    }
    String command = message.substring(0, 2);
    try {
      Message msg = (Message)((Class<?>) messages.get(command)).newInstance();
      PropertyDescriptor[] descs = PropertyUtils.getPropertyDescriptors(msg);

      int fixedFieldEnd = 2;

      for (int n = 0; n < descs.length; n++) {
        PropertyDescriptor desc = descs[n];
        FieldDescriptor SIPField = (FieldDescriptor)desc.getValue("SIPFieldDescriptor");
        String value = "";
        if (SIPField != null) {
          if (SIPField.getClass() == PositionedFieldDescriptor.class) {
            PositionedFieldDescriptor field = (PositionedFieldDescriptor) SIPField;
            value = message.substring(field.start, field.end + 1);
            msg.setProp(desc, value);
            if (fixedFieldEnd < field.end) {
              fixedFieldEnd = field.end;
            }
          }
        }
      }

      msg.parseVarFields(fixedFieldEnd + 1, message);
      
      msg.SequenceCharacter = sequenceCharacter;

      return msg;
    } catch (Exception ex) {
      throw new MessageNotUnderstood();
    }
  }

  private static boolean CheckChecksum(String message) {
	try {
		String tail = message.substring(message.length()-6);
		if (!tail.startsWith("AZ")) {
			return true;
		}
		String truncated = message.substring(0, message.length()-4);
		String check = tail.substring(2);
		String checksum = CalculateChecksum(truncated);
        return (checksum.equals(check));
	} catch (Exception ex) {
	}

    return true;
  }

  private static Character GetSequenceCharacter(String message) {
	try {
		String tail = message.substring(message.length()-9);
		if (!tail.startsWith("AY")) {
			return null;
		}
		return tail.charAt(2);
	} catch (Exception ex) {
	}

    return null;
  }
  
  protected static String CalculateChecksum(String data) throws UnsupportedEncodingException
  {
      int checksum = 0;
      byte[] bytes = data.getBytes("ASCII");  	
      for (int n = 0; n < bytes.length; n++) {
        checksum += bytes[n];
      }
      checksum = -checksum & 0xffff;
	  return Integer.toHexString(checksum).toUpperCase();
  }
  
  protected String AddChecksum(String command, Character sequence) {
    StringBuffer check = new StringBuffer();
    if (sequence != null) {
	   	check.append("AY");
	   	check.append(sequence);
	    check.append("AZ");
	    try {
	      check.append(CalculateChecksum(command + check.toString()));
	      return command + check.toString();
	    }
	    catch (Exception e) {
	    	return command;
	    }
    } else {
    	return command;
    }
  }

  private void parseVarFields(int offset, String data) {
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
        if (data.charAt(n) == TaggedFieldDescriptor.TERMINATOR) {
        	this.setFieldProp(fieldtag.toString(), fielddata.toString());
        	status = 1;
        }
        else {
          fielddata.append(data.charAt(n));
        }
      }
    }
    return;
  }
  
  private void setFieldProp(String tag, String data)
  {
      PropertyDescriptor[] descs = PropertyUtils.getPropertyDescriptors(this);
      for (int n = 0; n < descs.length; n++) {
          PropertyDescriptor desc = descs[n];
          FieldDescriptor SIPField = (FieldDescriptor)desc.getValue("SIPFieldDescriptor");
          if (SIPField != null) {
            if (SIPField.getClass().equals(TaggedFieldDescriptor.class)) {
              TaggedFieldDescriptor field = (TaggedFieldDescriptor) SIPField;
              if (field.tag.equals(tag)) {
            	  this.setProp(desc, data);
              }
            }
          }
        }
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

  private static Hashtable<Object, Class<?>> messages = new Hashtable<Object, Class<?>>();

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
