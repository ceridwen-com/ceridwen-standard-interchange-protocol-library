package com.ceridwen.circulation.SIP.messages;

public class LoginResponse extends Message {
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
