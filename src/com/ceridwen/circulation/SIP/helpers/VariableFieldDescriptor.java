/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.helpers;

public class VariableFieldDescriptor {
  public static final char TERMINATOR = '|';
  public String ID;
  public boolean required = true;

  public VariableFieldDescriptor(String ID) {
    this.ID = ID;
    this.required = true;
  }

  public VariableFieldDescriptor(String ID, boolean required) {
    this.ID = ID;
    this.required = required;
  }
}
