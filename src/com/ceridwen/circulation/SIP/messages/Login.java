package com.ceridwen.circulation.SIP.messages;

public class Login extends Message {
  private String UIDAlgorithm;
  private String PWDAlgorithm;
  private String loginUserId;
  private String loginPassword;
  private String locationCode;
  public String getCommand() {
    return "93";
  }
  public String getUIDAlgorithm() {
    return UIDAlgorithm;
  }
  public void setUIDAlgorithm(String UIDAlgorithm) {
    this.UIDAlgorithm = UIDAlgorithm;
  }
  public String getPWDAlgorithm() {
    return PWDAlgorithm;
  }
  public void setPWDAlgorithm(String PWDAlgorithm) {
    this.PWDAlgorithm = PWDAlgorithm;
  }
  public String getLoginUserId() {
    return loginUserId;
  }
  public void setLoginUserId(String loginUserId) {
    this.loginUserId = loginUserId;
  }
  public String getLoginPassword() {
    return loginPassword;
  }
  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }
  public String getLocationCode() {
    return locationCode;
  }
  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }


}
