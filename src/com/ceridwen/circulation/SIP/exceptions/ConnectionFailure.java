/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.exceptions;

public class ConnectionFailure extends Exception {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5184375852496129646L;
public ConnectionFailure() {
  }
  public ConnectionFailure(Throwable cause) {
    super(cause);
  }
}
