package com.ceridwen.circulation.SIP.messages;



/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class SCStatus extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6198644705404364776L;
private String statusCode;
  private String maxPrintWidth;
  private String protocolVersion;

  public String getCommand() {
    return "99";
  }
  public String getMaxPrintWidth() {
    return maxPrintWidth;
  }
  public String getProtocolVersion() {
    return protocolVersion;
  }
  public String getStatusCode() {
    return statusCode;
  }
  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }
  public void setProtocolVersion(String protocolVersion) {
    this.protocolVersion = protocolVersion;
  }
  public void setMaxPrintWidth(String maxPrintWidth) {
    this.maxPrintWidth = maxPrintWidth;
  }
}