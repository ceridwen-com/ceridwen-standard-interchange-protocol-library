/* 
 * Copyright (C) 2019 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ceridwen.circulation.SIP.transport;


import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.security.cert.Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 *
 * @author Matthew.Dovey
 */
public class SSLSocketConnection extends SocketConnection {
  public static final String PROP_DISABLESSLHOSTCHECK = "com.ceridwen.circulation.SIP.disableSSLHostCheck";
  
  private File clientCertificate;
  private File clientPrivateKey;
  private String clientPrivateKeyPassword;
  private File serverCertificateCA;

  /**
   * Get the value of ServerCertificateCA
   *
   * @return the value of ServerCertificateCA
   */
  public File getServerCertificateCA() {
    return serverCertificateCA;
  }

  /**
   * Set the value of ServerCertificateCA
   *
   * @param ServerCertificateCA new value of ServerCertificateCA
   */
  public void setServerCertificateCA(File ServerCertificateCA) {
    this.serverCertificateCA = ServerCertificateCA;
  }


  /**
   * Get the value of clientCertificate
   *
   * @return the value of clientCertificate
   */
  public File getClientCertificate() {
    return clientCertificate;
  }

  /**
   * Set the value of clientCertificate
   *
   * @param clientCertificate new value of clientCertificate
   */
  public void setClientCertificate(File clientCertificate) {
    this.clientCertificate = clientCertificate;
  }


  /**
   * Get the value of clientPrivateKey
   *
   * @return the value of clientPrivateKey
   */
  public File getClientPrivateKey() {
    return clientPrivateKey;
  }

  /**
   * Set the value of clientPrivateKey
   *
   * @param clientPrivateKey new value of clientPrivateKey
   */
  public void setClientPrivateKey(File clientPrivateKey) {
    this.clientPrivateKey = clientPrivateKey;
  }

  public String getClientPrivateKeyPassword() {
    return clientPrivateKeyPassword;
  }

  public void setClientPrivateKeyPassword(String clientPrivateKeyPassword) {
    this.clientPrivateKeyPassword = clientPrivateKeyPassword;
  }

  private Socket setParameters(Socket socket) {
    if ("true".equals(System.getProperty(PROP_DISABLESSLHOSTCHECK, "false"))) {
        SSLParameters sslParams = new SSLParameters();
        sslParams.setEndpointIdentificationAlgorithm("HTTPS");
        ((SSLSocket) socket).setSSLParameters(sslParams);
    }
    return socket;
  }

  @Override
  protected Socket getSocket() throws Exception {
    KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");; 
    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    KeyStore keyStore = KeyStore.getInstance("PKCS12");
    KeyStore trustStore = KeyStore.getInstance("PKCS12");
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    KeyFactory kf = KeyFactory.getInstance("RSA");
    
    if (clientPrivateKey != null && clientCertificate != null) {
      keyStore.load(null);
      String data = new String(Files.readAllBytes(clientPrivateKey.toPath()));
      data = data.replace("-----BEGIN PRIVATE KEY-----\n", "");
      data = data.replace("-----END PRIVATE KEY-----", "");
      data = data.replaceAll("\\s", "");
      if (clientPrivateKeyPassword == null) {
        keyStore.setKeyEntry("client", kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(data))), null, cf.generateCertificates(new FileInputStream(clientCertificate)).toArray(new Certificate[]{}));
        keyManagerFactory.init(keyStore, null);
      } else {
        keyStore.setKeyEntry("client", kf.generatePrivate(new PKCS8EncodedKeySpec(Base64.getDecoder().decode(data))), clientPrivateKeyPassword.toCharArray(), cf.generateCertificates(new FileInputStream(clientCertificate)).toArray(new Certificate[]{}));       
        keyManagerFactory.init(keyStore, clientPrivateKeyPassword.toCharArray());
      }
    } else {
      keyManagerFactory = null;
    }
            
    if (serverCertificateCA != null) {
      trustStore.load(null);
      trustStore.setCertificateEntry("ca", cf.generateCertificate(new FileInputStream(serverCertificateCA)));
      trustManagerFactory.init(trustStore);
    } else {
      if (keyManagerFactory == null) {
        return setParameters(SSLContext.getDefault().getSocketFactory().createSocket());
      } else {
        trustManagerFactory.init((KeyStore)null);
      }
    }
    SSLContext context = SSLContext.getInstance("TLS");
    context.init(keyManagerFactory == null?null:keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), new SecureRandom());
    SSLSocketFactory sockFact = context.getSocketFactory();
    return setParameters(sockFact.createSocket());
  }
  
}
