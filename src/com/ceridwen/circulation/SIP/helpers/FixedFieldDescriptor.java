/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.helpers;

public class FixedFieldDescriptor {
  public int start;
  public int end;
  public boolean allowBlank = true;

  public FixedFieldDescriptor(int start, int end, boolean allowBlank) {
    this.start = start;
    this.end = end;
    this.allowBlank = allowBlank;
  }

  public FixedFieldDescriptor(int start, int end) {
    this.start = start;
    this.end = end;
    this.allowBlank = true;
  }
}
