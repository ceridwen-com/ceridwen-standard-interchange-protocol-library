/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceridwen.circulation.SIP.transport;

import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

/**
 *
 * @author Matthew.Dovey
 */
public class SSLSocketConnection extends AbstractSocketConnection {

  @Override
  Socket getSocket() throws Exception {
    return SSLSocketFactory.getDefault().createSocket();
  }
  
}
