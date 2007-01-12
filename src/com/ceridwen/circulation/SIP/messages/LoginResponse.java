package com.ceridwen.circulation.SIP.messages;

public class LoginResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -7739633345494042411L;
private Boolean ok;
  public String getCommand() {
    return "94";
  }
  public Boolean getOk() {
    return ok;
  }
  public void setOk(Boolean ok) {
    this.ok = ok;
  }

}
