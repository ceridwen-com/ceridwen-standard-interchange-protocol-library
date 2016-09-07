/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
  

  @Override
  protected Socket getSocket() throws Exception {
    KeyManagerFactory keyManagerFactory = null; 
    TrustManagerFactory trustManagerFactory =  null;
    KeyStore keyStore = KeyStore.getInstance("PKCS12");
    KeyStore trustStore = KeyStore.getInstance("PKCS12");
    CertificateFactory cf = CertificateFactory.getInstance("X.509");
    KeyFactory kf = KeyFactory.getInstance("RSA");
    
    if (clientPrivateKey != null && clientCertificate != null) {
      keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
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
    }
            
    if (serverCertificateCA != null) {
      trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      trustStore.load(null);
      trustStore.setCertificateEntry("ca", cf.generateCertificate(new FileInputStream(serverCertificateCA)));
      trustManagerFactory.init(trustStore);
    }

    SSLContext context = SSLContext.getInstance("TLS");
    context.init(keyManagerFactory == null?null:keyManagerFactory.getKeyManagers(), trustManagerFactory == null?null:trustManagerFactory.getTrustManagers(), new SecureRandom());
    SSLSocketFactory sockFact = context.getSocketFactory();
    return sockFact.createSocket();
  }
  
}
