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

import java.beans.PropertyDescriptor;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;
import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.InvalidFieldLength;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.fields.FieldDefinition;
import com.ceridwen.circulation.SIP.fields.Fields;
import com.ceridwen.circulation.SIP.fields.FieldPolicy;
import com.ceridwen.circulation.SIP.fields.PositionedFieldDefinition;
import com.ceridwen.circulation.SIP.fields.TaggedFieldDefinition;
import com.ceridwen.circulation.SIP.types.enumerations.AbstractEnumeration;
import com.ceridwen.circulation.SIP.types.flagfields.AbstractFlagField;

public abstract class Message implements Serializable {
    /**
	 * 
	 */
    private static final long serialVersionUID = 1609258005567594730L;
    public static final String PROP_CHARSET = "com.ceridwen.circulation.SIP.charset";
    public static final String PROP_AUTOPOPULATE = "com.ceridwen.circulation.SIP.messages.AutoPopulationEmptyRequiredFields";

    public static final String PROP_AUTOPOPULATE_OFF = "off";
    public static final String PROP_AUTOPOPULATE_DECODE = "decode";
    public static final String PROP_AUTOPOPULATE_ENCODE = "encode";
    public static final String PROP_AUTOPOPULATE_BIDIRECTIONAL = "bidirectional";
    
    private static final String PROP_AUTOPOPULATE_DEFAULT = PROP_AUTOPOPULATE_BIDIRECTIONAL;
    private static final String PROP_DEFAULT_CHARSET = "cp850";

    private static Log log = LogFactory.getLog(Message.class);

    private Character SequenceCharacter = null;

    public Character getSequenceCharacter() {
        return this.SequenceCharacter;
    }

    public static String getCharsetEncoding() {
        return System.getProperty(PROP_CHARSET, PROP_DEFAULT_CHARSET);    	
    }
    
    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
    }

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

    private String[] getProp(PropertyDescriptor desc, FieldDefinition SIPField, boolean autoPop) throws MandatoryFieldOmitted {
        String[] ret = null;
        try {
            Method read = desc.getReadMethod();
            Object value = null;
            if (read != null) {
                value = read.invoke(this, new Object[0]);
            } else {
            if (desc.getPropertyType() == Boolean.class) {
                    read = this.getClass().getMethod("is" + desc.getName().substring(0, 1).toUpperCase() + desc.getName().substring(1), new Class[]{});
                    if (read != null) {
                        value = read.invoke(this, new Object[0]);                        
                    }
                }                
            }
            if (desc.getPropertyType() == Boolean.class) {
                if (value == null) {
                    if (SIPField != null) {
                        if (SIPField.policy != null) {
                            if (SIPField.policy == FieldPolicy.REQUIRED) {
                                if (desc.getName().equalsIgnoreCase("magneticMedia")) {
                                    ret = new String[] { "U" };
                                } else {
                                    if (!autoPop) {
                                        throw new MandatoryFieldOmitted(desc.getDisplayName());
                                    }
                                    if (desc.getName().equalsIgnoreCase("ok")) {
                                        ret = new String[] { "0" };
                                    } else {
                                        ret = new String[] { "N" };
                                    }
                                }
                            }
                        }
                    }
                } else if (desc.getName().equalsIgnoreCase("ok")) {
                    ret = new String[] { ((Boolean) value).booleanValue() ? "1" : "0" };
                } else {
                    ret = new String[] { ((Boolean) value).booleanValue() ? "Y" : "N" };
                }
            } else if (desc.getPropertyType() == Date.class) {
                if (value != null) {
                    ret = new String[] { this.mangleDate((Date) value) };
                } else {
                    if (SIPField != null) {
                        if (SIPField.policy != null) {
                            if (SIPField.policy == FieldPolicy.REQUIRED) {
                                if (!autoPop) {
                                    throw new MandatoryFieldOmitted(desc.getDisplayName());
                                }
                                ret = new String[] { this.mangleDate(new Date()) };
                            }
                        }
                    }
                }
            } else if (desc.getPropertyType() == String[].class) {
                if (value != null) {
                    ret = (String[]) value;
                }
            } else if (desc.getPropertyType() == Integer.class) {
                if (value != null) {
                    if (SIPField.length != 0) {
                        ret = new String[] { String.format("%0" + SIPField.length + "d", value) };
                    } else {
                        ret = new String[] { value.toString() };
                    }
                } else {
                    if (SIPField != null) {
                        if (SIPField.policy != null) {
                            if (SIPField.policy == FieldPolicy.REQUIRED) {
                                if (!autoPop) {
                                    throw new MandatoryFieldOmitted(desc.getDisplayName());
                                }
                                if (SIPField.length != 0) {
                                    ret = new String[] { String.format("%0" + SIPField.length + "d", 0) };
                                } else {
                                    ret = new String[] { "0" };
                                }
                            }
                        }
                    }
                }
            } else {
                if (value != null) {
                    ret = new String[] { value.toString() };
                } else {
                    if (SIPField != null) {
                        if (SIPField.policy != null) {
                            if (SIPField.policy == FieldPolicy.REQUIRED) {
                                if (!autoPop) {
                                    throw new MandatoryFieldOmitted(desc.getDisplayName());
                                }
                                Class<?>[] interfaces = desc.getPropertyType().getInterfaces();
                                for (Class<?> interfce : interfaces) {
                                    if (interfce == AbstractEnumeration.class) {
                                        Method mthd = desc.getPropertyType().getDeclaredMethod("values",
                                                new Class[] {});
                                        Object[] values = (Object[]) mthd.invoke(null, new Object[] {});
                                        if (values.length > 0) {
                                            ret = new String[] { values[0].toString() };
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
            Message.log.error("Unexpected error getting " + desc.getDisplayName(), ex);
        }

        return (ret != null) ? ret : new String[] { "" };
    }

    private String pad(String input, PositionedFieldDefinition field) {
        StringBuffer ret = new StringBuffer();

        ret.append(input);

        while (ret.length() <= (field.end - field.start)) {
            ret.append(" ");
        }

        return ret.toString();
    }

    public String encode(Character sequence) throws MandatoryFieldOmitted, InvalidFieldLength, MessageNotUnderstood {
        String pop = System.getProperty(Message.PROP_AUTOPOPULATE, PROP_AUTOPOPULATE_BIDIRECTIONAL);
        boolean autoPop = false;
        if (pop.equalsIgnoreCase(PROP_AUTOPOPULATE_ENCODE) || pop.equalsIgnoreCase(PROP_AUTOPOPULATE_DEFAULT)) {
            autoPop = true;
        }
        return encode(sequence, autoPop);
    }

    private String encode(Character sequence, boolean autoPop) throws MandatoryFieldOmitted, InvalidFieldLength, MessageNotUnderstood {
        TreeMap<Integer, String> fixed = new TreeMap<Integer, String>();
        TreeMap<String, String[]> variable = new TreeMap<String, String[]>();
        StringBuffer message = new StringBuffer();

        Field[] fields = this.getClass().getDeclaredFields(); 

        for (Field fld : fields) {
        	if (fld.isAnnotationPresent(PositionedField.class)) {
        		PositionedField annotation = (PositionedField)fld.getAnnotation(PositionedField.class);               
        		PositionedFieldDefinition field = Fields.getPositionedFieldDefinition(this.getClass().getName(), fld.getName(), annotation);
        		PropertyDescriptor desc;
        		try {
        			desc = PropertyUtils.getPropertyDescriptor(this, fld.getName());
        		} catch (Exception ex) {
        			throw new java.lang.AssertionError("Introspection problem during encoding for " + fld.getName() + " in " + this.getClass().getName());
        		}
        		if (desc == null) {
        			throw new java.lang.AssertionError("Introspection problem during encoding for " + fld.getName() + " in " + this.getClass().getName());                    
        		}
        		String[] value = this.getProp(desc, field, autoPop);
//                    if (StringUtils.isEmpty(value[0])) {
//                    	if (field.policy == FieldPolicy.REQUIRED) {
//                            throw new MandatoryFieldOmitted(desc.getDisplayName());
//                        }
//                    }
        		if (value[0].length() > (field.end - field.start + 1)) {
        			throw new InvalidFieldLength(desc.getDisplayName(), (field.end - field.start + 1));
        		}
        		if ((desc.getPropertyType() == Date.class) || (desc.getPropertyType() == Boolean.class) || (desc.getPropertyType() == Integer.class)) {
        			if (!(StringUtils.isEmpty(value[0]) || (value[0].length() == (field.end - field.start + 1)))) {
        				throw new java.lang.AssertionError("FixedFieldDescriptor for " + desc.getDisplayName() + " in " + this.getClass().getSimpleName()
        						+ ", start/end (" + field.start + "," + field.end + ") invalid for type " +
        						desc.getPropertyType().getName());
        			}
        		}
        		if (fixed.containsKey(new Integer(field.start))) {
        			throw new java.lang.AssertionError("Positioning error inserting field at " + field.start + " for class " + this.getClass().getName());                    
        		}
        		fixed.put(new Integer(field.start), this.pad(value[0], field));
        	}
        	if (fld.isAnnotationPresent(TaggedField.class)) {
        		TaggedField annotation = (TaggedField)fld.getAnnotation(TaggedField.class);               
        		TaggedFieldDefinition field = Fields.getTaggedFieldDefinition(this.getClass().getName(), fld.getName(), annotation);
        		PropertyDescriptor desc;
        		try {
        			desc = PropertyUtils.getPropertyDescriptor(this, fld.getName());
        		} catch (Exception ex) {
        			throw new java.lang.AssertionError("Introspection problem during encoding for " + fld.getName() + " in " + this.getClass().getName());
        		}
        		if (desc == null) {
        			throw new java.lang.AssertionError("Introspection problem during encoding for " + fld.getName() + " in " + this.getClass().getName());                    
        		}
        		String[] value = this.getProp(desc, field, autoPop);
        		if (StringUtils.isNotEmpty(value[0])) {
        			if (field.length != 0) {
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
        		} else if (field.policy == FieldPolicy.REQUIRED) {
        			variable.put(field.tag, new String[]{""});
        		}
        	}
        }

        if (this.getClass().isAnnotationPresent(Command.class)) {
            message.append(((Command)(this.getClass().getAnnotation(Command.class))).value());
        } else {
            throw new java.lang.AssertionError("No command annotation present for class " + this.getClass().getName());
        }

        Iterator<Integer> fixedIterate = fixed.keySet().iterator();
        while (fixedIterate.hasNext()) {
            Integer key = fixedIterate.next();
            if (message.length() != key.intValue()) {
                throw new java.lang.AssertionError("Positioning error inserting field at " + key + " for class " + this.getClass().getName());
            }            
            message.append(fixed.get(key));
        }

        Iterator<String> varIterate = variable.keySet().iterator();
        while (varIterate.hasNext()) {
            String key = varIterate.next();
            String[] values = variable.get(key);
            for (String value : values) {
                message.append(key);
                message.append(value);
                message.append(TaggedFieldDefinition.TERMINATOR);
            }
        }

        return this.addChecksum(message.toString(), sequence);
    }

    private void setProp(PropertyDescriptor desc, String value) {
        try {
            if (desc.getPropertyType() == Boolean.class) {
                desc.getWriteMethod().invoke(this,
                                     new Object[] { value.equalsIgnoreCase("U") ? null :
                                             new Boolean(value.
                                                     equalsIgnoreCase("Y") ||
                                                     value.equalsIgnoreCase("1")) });
                return;
            }
            if (desc.getPropertyType() == Date.class) {
                desc.getWriteMethod().invoke(this,
                                     new Object[] { this.demangleDate(value) });
                return;
            }
            if (desc.getPropertyType() == Integer.class) {
                    if (!value.trim().isEmpty()) {
                desc.getWriteMethod().invoke(this,
                                     new Object[] { new Integer(value.trim()) });
                    }
                return;
            }
            if (desc.getPropertyType() == String.class) {
                desc.getWriteMethod().invoke(this,
                                     new Object[] { new String(value) });
                return;
            }
            if (desc.getPropertyType().getSuperclass() == AbstractFlagField.class) {
                Object data = desc.getPropertyType().getConstructor(new Class[] { String.class }).newInstance(new Object[] { new String(value) });
                    if (data != null) {
                desc.getWriteMethod().invoke(this,
                        new Object[] { data });
                    }
                return;
            }
            Class<?>[] interfaces = desc.getPropertyType().getInterfaces();
            for (Class<?> interfce : interfaces) {
                if (interfce == AbstractEnumeration.class) {
                    Method mthd = interfce.getDeclaredMethod("getKey",
                            new Class[] { String.class });
                    Method mthdInst = desc.getPropertyType().getDeclaredMethod("values",
                            new Class[] {});
                    Object[] values = (Object[]) mthdInst.invoke(null, new Object[] {});
                    if (values.length > 0) {
                        Object data = mthd.invoke(values[0],
                                new Object[] { new String(value) });
                        desc.getWriteMethod().invoke(this,
                                new Object[] { data });
                        return;
                    }
                }
            }
            if (desc.getPropertyType() == String[].class) {
                String[] current = (String[]) desc.getReadMethod().invoke(this, new Object[0]);
                if (current == null) {
                    desc.getWriteMethod().invoke(this,
                            new Object[] { new String[] { new String(value) } });
                    return;
                } else {
                    List<String> l = new ArrayList<String>(current.length + 1);
                    l.addAll(Arrays.asList(current));
                    l.add(new String(value));
                    desc.getWriteMethod().invoke(this,
                            new Object[] { l.toArray(new String[l.size()]) });
                    return;
                }
            }
        } catch (Exception ex) {
            Message.log.error("Unexpected error setting " + desc.getDisplayName() + " to " + value, ex);
        }
    }

    public static Message decode(String message, Character sequence, boolean checksumCheck) throws MandatoryFieldOmitted, ChecksumError, SequenceError,
    		MessageNotUnderstood {
        String pop = System.getProperty(Message.PROP_AUTOPOPULATE, PROP_AUTOPOPULATE_BIDIRECTIONAL);
        boolean autoPop = false;
        if (pop.equalsIgnoreCase(PROP_AUTOPOPULATE_DECODE) || pop.equalsIgnoreCase(PROP_AUTOPOPULATE_DEFAULT)) {
            autoPop = true;
        }
    	return decode(message, sequence, checksumCheck, autoPop);
    }
    
    private static Message decode(String message, Character sequence, boolean checksumCheck, boolean autoPop) throws MandatoryFieldOmitted, ChecksumError, SequenceError,
            MessageNotUnderstood {
        if (checksumCheck) {
            if (!Message.CheckChecksum(message)) {
                throw new ChecksumError();
            }
        }
        Character sequenceCharacter = Message.GetSequenceCharacter(message);

        if (sequence != null) {
            if (sequenceCharacter != null) {
                if (!sequence.equals(sequenceCharacter)) {
                    throw new SequenceError();
                }
            }
        }

        if (message == null) {
            throw new MessageNotUnderstood();
        }
        if (message.length() < 2) {
            throw new MessageNotUnderstood();
        }
        String command = message.substring(0, 2);
        Class<? extends Message> msgClass = Message.messages.get(command);
        if (msgClass == null) {
            throw new MessageNotUnderstood();                
        }
        Message msg;
		try {
            msg = msgClass.newInstance();
        } catch (Exception ex) {
            throw new java.lang.AssertionError("Instantiation problem creating new " + msgClass.getName());
        }
        Field[] fields = msg.getClass().getDeclaredFields();

        int fixedFieldEnd = 2;

        for (Field fld : fields) {
            if (fld.isAnnotationPresent(PositionedField.class)) {
                PositionedField annotation = fld.getAnnotation(PositionedField.class);
                PositionedFieldDefinition field = Fields.getPositionedFieldDefinition(msg.getClass().getName(), fld.getName(), annotation);
                PropertyDescriptor desc;
                try {
                    desc = PropertyUtils.getPropertyDescriptor(msg, fld.getName());
                } catch (Exception ex) {
                    throw new java.lang.AssertionError("Introspection problem during decoding for " + fld.getName() + " in " + msg.getClass().getName());
                }
                if (desc == null) {
                    throw new java.lang.AssertionError("Introspection problem during decoding for " + fld.getName() + " in " + msg.getClass().getName());                    
                }
                String value = "";
                if (message.length() > field.end) {
                	value = message.substring(field.start, field.end + 1);
                } else {
                	if (!autoPop) {
                		throw new MandatoryFieldOmitted(desc.getDisplayName());                		
                	}
                }
                msg.setProp(desc, value);
                if (fixedFieldEnd < field.end) {
                    fixedFieldEnd = field.end;
                }
            }
        }

        msg.parseVarFields(fixedFieldEnd + 1, message);
        
        msg.SequenceCharacter = sequenceCharacter;

        for (Field fld : fields) {
            if (fld.isAnnotationPresent(TaggedField.class)) {
            	TaggedField annotation = fld.getAnnotation(TaggedField.class);
            	TaggedFieldDefinition field = Fields.getTaggedFieldDefinition(msg.getClass().getName(), fld.getName(), annotation);
                PropertyDescriptor desc;
                try {
                    desc = PropertyUtils.getPropertyDescriptor(msg, fld.getName());
                } catch (Exception ex) {
                    throw new java.lang.AssertionError("Introspection problem during decoding for " + fld.getName() + " in " + msg.getClass().getName());
                }
                if (desc == null) {
                    throw new java.lang.AssertionError("Introspection problem during decoding for " + fld.getName() + " in " + msg.getClass().getName());                    
                }
                try {
                	msg.getProp(desc, field, false);
                } catch (MandatoryFieldOmitted ex) {
	        		if (autoPop) {
	        			msg.setProp(desc, "");
	        		} else {
	        			throw ex;
	        		}
                }
            }
        }

        return msg;
    }

    private static boolean CheckChecksum(String message) {
        try {
            String tail = message.substring(message.length() - 6);
            if (!tail.startsWith("AZ")) {
                return true;
            }
            String truncated = message.substring(0, message.length() - 4);
            String check = tail.substring(2);
            String checksum = Message.calculateChecksum(truncated);
            return (checksum.equals(check));
        } catch (Exception ex) {
        }

        return true;
    }

    private static Character GetSequenceCharacter(String message) {
        try {
            String tail = message.substring(message.length() - 9);
            if (!tail.startsWith("AY")) {
                return null;
            }
            return tail.charAt(2);
        } catch (Exception ex) {
        }

        return null;
    }

    protected static String calculateChecksum(String data) throws UnsupportedEncodingException {
        int checksum = 0;
        // Fix from Rustam Usmanov
        byte[] bytes = data.getBytes(Message.getCharsetEncoding());
        for (byte b : bytes) {        	
            // Fix from Rustam Usmanov
        	checksum += b & 0xff;
        }
        checksum = -checksum & 0xffff;
        return Integer.toHexString(checksum).toUpperCase();
    }

    protected String addChecksum(String command, Character sequence) {
        StringBuffer check = new StringBuffer();
        if (sequence != null) {
            check.append("AY");
            check.append(sequence);
            check.append("AZ");
            try {
                check.append(Message.calculateChecksum(command + check.toString()));
                return command + check.toString();
            } catch (Exception e) {
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
            } else if (status == 2) {
                fielddata = new StringBuffer();
                fieldtag.append(data.charAt(n));
                status = 3;
            } else if (status == 3) {
                if (data.charAt(n) == TaggedFieldDefinition.TERMINATOR) {
                    this.setFieldProp(fieldtag.toString(), fielddata.toString());
                    status = 1;
                } else {
                    fielddata.append(data.charAt(n));
                }
            }
        }
        return;
    }

    private void setFieldProp(String tag, String data) {
        Field[] fields = this.getClass().getDeclaredFields();

        for (Field fld : fields) {
                if (fld.isAnnotationPresent(TaggedField.class)) {
                    TaggedField annotation = fld.getAnnotation(TaggedField.class);
                    TaggedFieldDefinition field = Fields.getTaggedFieldDefinition(this.getClass().getName(), fld.getName(), annotation);
                    PropertyDescriptor desc;
                    try {
                        desc = PropertyUtils.getPropertyDescriptor(this, fld.getName());
                    } catch (Exception ex) {
                        throw new java.lang.AssertionError("Introspection problem during decoding for " + fld.getName() + " in " + this.getClass().getName());                                            
                    }
                    if (desc == null) {
                        throw new java.lang.AssertionError("Introspection problem during decoding for " + fld.getName() + " in " + this.getClass().getName());                    
                    }
                    if (field.tag.equals(tag)) {
                        this.setProp(desc, data);
                    }
                }
            }
        }

    public void xmlEncode(OutputStream strm) {
        XMLEncoder out = new XMLEncoder(strm);
        out.writeObject(this);
        out.flush();
        out.close();
    }

    public static Message xmlDecode(InputStream strm) {
        XMLDecoder in = new XMLDecoder(strm);
        Message msg = (Message) in.readObject();
        in.close();
        return msg; 
    }

    private static Hashtable<String, Class<? extends Message>> messages = new Hashtable<String, Class<? extends Message>>();

    static {
        for (Messages m: Messages.values()) {
            try {
                @SuppressWarnings("unchecked")
                Class<? extends Message> message = (Class<? extends Message>)Class.forName(Messages.class.getPackage().getName() +  "." + m.name());
                if (message != null) {
                    if (message.isAnnotationPresent(Command.class)) {
                        String cmd = ((Command)message.getAnnotation(Command.class)).value();
                        if (cmd.isEmpty()) {
                            throw new java.lang.AssertionError(m.name() + " has empty command string.");                                        
                        }
                        if (Message.messages.containsKey(cmd)) {
                            throw new java.lang.AssertionError(m.name() + " duplicates command string.");                                                                    
                        }
                        Message.messages.put(cmd, (Class<? extends Message>)message);
                    }
                }
            } catch (Exception ex) {
                Message.log.warn(m.name() + " not yet implemented.");
            }
        }
    }

    @Override
    public String toString() {
        ByteArrayOutputStream buffer = new java.io.ByteArrayOutputStream();
        this.xmlEncode(buffer);
        return new String(buffer.toByteArray());
    }
    
    /**
     * Test Case Implementation    
     */
    private Message getEmptyMessage() {
        try {
            Message msg = (Message)this.getClass().newInstance();
            for (Field field: this.getClass().getDeclaredFields()) {
                if (field.getType() == Date.class) {
                    PropertyDescriptor desc = PropertyUtils.getPropertyDescriptor(msg, field.getName());
                    if (desc != null) {
                        if (field.isAnnotationPresent(PositionedField.class)) {
                            PositionedField annotation = (PositionedField)field.getAnnotation(PositionedField.class);               
                            PositionedFieldDefinition fld = Fields.getPositionedFieldDefinition(this.getClass().getName(), field.getName(), annotation);
                            if (fld.policy == FieldPolicy.REQUIRED) {
                                Method method = desc.getWriteMethod();
                                if (method != null) {
                                    method.invoke(msg, new Object[]{demangleDate("19700101    010000")});
}
                            }
                        }

                        if (field.isAnnotationPresent(TaggedField.class)) {
                            TaggedField annotation = (TaggedField)field.getAnnotation(TaggedField.class);               
                            TaggedFieldDefinition fld = Fields.getTaggedFieldDefinition(this.getClass().getName(), field.getName(), annotation);
                            if (fld.policy == FieldPolicy.REQUIRED) {
                                Method method = desc.getWriteMethod();
                                if (method != null) {
                                    method.invoke(msg, new Object[]{demangleDate("19700101    010000")});
                                }                                                
                            }
                        }
                    }
                }
            }
            return msg;
        } catch (Exception ex) {
            Assert.fail("Exception getting default message: " + ex.getMessage());
            return null;
        }
    }

    private Message getDefaultMessage() {
        try {
            Message msg = (Message)this.getClass().newInstance();
            for (Field field: this.getClass().getDeclaredFields()) {
                boolean required = false;
                int length = 0;
                PropertyDescriptor desc = PropertyUtils.getPropertyDescriptor(msg, field.getName());
                if (desc != null) {
                    if (field.isAnnotationPresent(PositionedField.class)) {
                        PositionedField annotation = (PositionedField)field.getAnnotation(PositionedField.class);               
                        PositionedFieldDefinition fld = Fields.getPositionedFieldDefinition(this.getClass().getName(), field.getName(), annotation);
                        required = (fld.policy == FieldPolicy.REQUIRED);
                        length = fld.end - fld.start + 1;
                    }
                    if (field.isAnnotationPresent(TaggedField.class)) {
                        TaggedField annotation = (TaggedField)field.getAnnotation(TaggedField.class);               
                        TaggedFieldDefinition fld = Fields.getTaggedFieldDefinition(this.getClass().getName(), field.getName(), annotation);
                        if (fld.policy == FieldPolicy.REQUIRED) {
                            required = (fld.policy == FieldPolicy.REQUIRED);
                        }
                    }
                    if (field.getType() == String.class) {
                        Method method = desc.getWriteMethod();
                        if (method != null) {
                            if (length > 0) {
                                method.invoke(msg, new Object[]{String.format("%0$" + length + "c", ' ')});
                            }
                        }
                    }
                    if (required) {
                        if (field.getType() == String.class) {
                            Method method = desc.getWriteMethod();
                            if (method != null) {
                                if (length == 0) {
                                    method.invoke(msg, new Object[]{new String()});
                                }
                            }
                        }
                        if (field.getType() == Integer.class) {
                            Method method = desc.getWriteMethod();
                            if (method != null) {
                                method.invoke(msg, new Object[]{new Integer(0)});
                            }
                        }
                        if (field.getType() == Boolean.class) {
                            Method method = desc.getWriteMethod();
                            if (method != null) {
                                method.invoke(msg, new Object[]{new Boolean(false)});
                            }
                        }
                        if (field.getType() == Date.class) {
                            Method method = desc.getWriteMethod();
                            if (method != null) {
                                method.invoke(msg, new Object[]{demangleDate("19700101    010000")});
                            }
                        }
                        Class<?>[] interfaces = desc.getPropertyType().getInterfaces();
                        for (Class<?> interfce : interfaces) {
                            if (interfce == AbstractEnumeration.class) {
                                if (field.isAnnotationPresent(PositionedField.class)) {
                                    Method mthdInst = desc.getPropertyType().getDeclaredMethod("values",
                                            new Class[] {});
                                    Object[] values = (Object[]) mthdInst.invoke(null, new Object[] {});
                                    if (values.length > 0) {
                                        desc.getWriteMethod().invoke(msg,
                                                new Object[] { values[0] });
                                    }                                    
                                }
                            }
                        }
                    }
                }
            }
            return msg;
        } catch (Exception ex) {
            Assert.fail("Exception getting default message: " + ex.getMessage());
            return null;
        }
    }

    private Message getPopulatedMessage() {
        try {
            Message msg = (Message)this.getClass().newInstance();
            for (Field field: this.getClass().getDeclaredFields()) {
                PropertyDescriptor desc = PropertyUtils.getPropertyDescriptor(msg, field.getName());
                if (desc != null) {
                    int length = 0;
                    if (field.isAnnotationPresent(PositionedField.class)) {
                        PositionedField annotation = (PositionedField)field.getAnnotation(PositionedField.class);               
                        PositionedFieldDefinition fld = Fields.getPositionedFieldDefinition(this.getClass().getName(), field.getName(), annotation);
                        length = fld.length;
                    }
                    if (field.isAnnotationPresent(TaggedField.class)) {
                        TaggedField annotation = (TaggedField)field.getAnnotation(TaggedField.class);               
                        TaggedFieldDefinition fld = Fields.getTaggedFieldDefinition(this.getClass().getName(), field.getName(), annotation);
                        length = fld.length;
                    }
                    Method method = desc.getWriteMethod();
                    if (method != null) {
                        Class<?> type = desc.getPropertyType();
                        if (type == Date.class) {
                            method.invoke(msg, new Object[]{demangleDate("19700101    010000")});
                        }                    
                        if (type == Boolean.class) {
                            method.invoke(msg, new Object[]{new Boolean(true)});
                        }                    
                        if (type == Integer.class) {
                            String value = "123456789";
                            if (length != 0) {
                                value = value.substring(0, length);
                            }
                            method.invoke(msg, new Object[]{new Integer(value)});
                        }                    
                        if (type == String.class) {
                            String value = field.getName();
                            if (length != 0) {
                                value = value.substring(0, length);
                            }
                            method.invoke(msg, new Object[]{new String(value)});
                        }
                        if (desc.getPropertyType().getSuperclass() == AbstractFlagField.class) {
                            Class<?> tp = field.getType();
                            Field[] fds = tp.getDeclaredFields();
                            for (Field fd: fds) {
                              if ((fd.getModifiers() & (Modifier.PUBLIC | Modifier.FINAL | Modifier.STATIC)) == (Modifier.PUBLIC | Modifier.FINAL | Modifier.STATIC)) {
                                  AbstractFlagField aff = (AbstractFlagField)desc.getReadMethod().invoke(msg, new Object[]{});
                                  aff.set(fd.getInt(null));
                              }
                            }
                        }
                        Class<?>[] interfaces = desc.getPropertyType().getInterfaces();
                        for (Class<?> interfce : interfaces) {
                            if (interfce == AbstractEnumeration.class) {
                                Method mthdInst = desc.getPropertyType().getDeclaredMethod("values",
                                        new Class[] {});
                                Object[] values = (Object[]) mthdInst.invoke(null, new Object[] {});
                                if (values.length > 0) {
                                    desc.getWriteMethod().invoke(msg,
                                            new Object[] { values[values.length - 1] });
                                }
                            }
                        }
                        if (desc.getPropertyType() == String[].class) {
                            String value = field.getName();
                            if (length != 0) {
                                value = value.substring(0, length-1);
                            }
                            method.invoke(msg, new Object[]{new String[]{new String(value + "1"), new String(value + "2")}});                            
                        }
                        
                    }
                }
            }
            return msg;
        } catch (Exception ex) {
            Assert.fail("Exception getting populated message: " + ex.getMessage());
            return null;
        }
    }    
    
    @Test 
    public void testCaseDisableEncodeAutoPopulate() {
    	try {
    		if (this instanceof SCResend || this instanceof ACSResend) { // have no mandatory fields
    			return;
    		}
			this.getEmptyMessage().encode(null, false);
	    	Assert.fail("Missing mandatory fields not caught");
		} catch (MandatoryFieldOmitted e) {
			Assert.assertTrue("Caught missing mandatory field: " + e.getMessage(), true);
		} catch (InvalidFieldLength e) {
            Assert.fail("Fixed Field Too Long: " + e.getMessage());
		} catch (MessageNotUnderstood e) {
            Assert.fail("Message not understood: " + e.getMessage());
		} 
    }
    
    @Test 
    public void testCaseDisableDecodeAutoPopulate() {
    	try {
    		if (this instanceof SCResend || this instanceof ACSResend) { // have no mandatory fields
    			return;
    		}
    		String message = "";
            if (this.getClass().isAnnotationPresent(Command.class)) {
                message = ((Command)(this.getClass().getAnnotation(Command.class))).value();
            } else {
                Assert.fail("No command annotation present for class " + this.getClass().getName());
            }    		
    		Message.decode(message, null, false, false);
        	Assert.fail("Missing mandatory fields not caught");
		} catch (MandatoryFieldOmitted e) {
			Assert.assertTrue("Caught missing mandatory field: " + e.getMessage(), true);
		} catch (MessageNotUnderstood e) {
            Assert.fail("Message not understood: " + e.getMessage());
		} catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
		}
    }    
    
    @Test
    public void testCaseDefaultEncode() {
        try {
            if (this.getClass().isAnnotationPresent(TestCaseDefault.class)) {
                String t = this.getEmptyMessage().encode(null, true);
                String v = ((TestCaseDefault)(this.getClass().getAnnotation(TestCaseDefault.class))).value();
                Assert.assertEquals(v, t);
            } else {
                Assert.fail("Message has no TestCaseDefault annotation");
            }            
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Fixed Field Too Long: " + e.getMessage());
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message not understood: " + e.getMessage());
        }
    }

    @Test
    public void testCaseDefaultDecode() {
        try {
            if (this.getClass().isAnnotationPresent(TestCaseDefault.class)) {
                String v = ((TestCaseDefault)(this.getClass().getAnnotation(TestCaseDefault.class))).value();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Message m = Message.decode(v, null, false, false);
                m.xmlEncode(stream);
                String r = stream.toString();
                stream = new ByteArrayOutputStream();
                m = this.getDefaultMessage();
                m.xmlEncode(stream);
                String t = stream.toString();
                Assert.assertEquals(t, r);
            } else {
                Assert.fail("Message has no TestCaseDefault annotation");
            }            
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted");
        } catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message Not Understood");
        }
    }

    @Test
    public void testCasePopulatedEncode() {
        try {
            if (this.getClass().isAnnotationPresent(TestCasePopulated.class)) {
                String t = this.getPopulatedMessage().encode(null, false);
                String v = ((TestCasePopulated)(this.getClass().getAnnotation(TestCasePopulated.class))).value();
                Assert.assertEquals(v, t);
            } else {
                Assert.fail("Message has no TestCasePopulated annotation");
            }            
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Field Wrong Size: " + e.getMessage());
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message not understood: " + e.getMessage());
        }
    }

    @Test
    public void testCasePopulatedDecode() {
        try {
            if (this.getClass().isAnnotationPresent(TestCasePopulated.class)) {
                String v = ((TestCasePopulated)(this.getClass().getAnnotation(TestCasePopulated.class))).value();
                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                Message m = Message.decode(v, null, false, false);
                m.xmlEncode(stream);
                String r = stream.toString();
                stream = new ByteArrayOutputStream();
                m = this.getPopulatedMessage();
                m.xmlEncode(stream);
                String t = stream.toString();
                Assert.assertEquals(t, r);
            } else {
                Assert.fail("Message has no TestCasePopulated annotation");
            }            
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted");
        } catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message Not Understood");
        }
    }

    @Test
    public void testCaseDefaultRoundTrip() {
        try {
            String t = this.getEmptyMessage().encode('0', true);
            Message m;
            m = Message.decode(t, '0', true, false);
            Assert.assertEquals(t, m.encode('0', false));
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Fixed Field Too Long: " + e.getMessage());
        } catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message Not Understood");
        }
    }    

    @Test
    public void testCasePopulatedRoundTrip() {
        try {
            String t = this.getPopulatedMessage().encode('0', false);
            Message m;
            m = Message.decode(t, '0', true, false);
            Assert.assertEquals(t, m.encode('0', false));
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Fixed Field Too Long: " + e.getMessage());
        } catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message Not Understood");
        }
    }    
}
