package com.ros.read.p12;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.X509Certificate;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class ReadP12File {

	ReadP12File readP12File = new ReadP12File();
	
	public static void main(String[] args) {
		try {
			readCertificateFromP12File();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void readCertificateFromP12File() throws IOException
	{
		LoadProperties loadProperties = new LoadProperties();
		loadProperties.getPropValues();
		try {
	        Security.addProvider(new BouncyCastleProvider());
	        KeyStore keyStore = KeyStore.getInstance("pkcs12");
	        InputStream input = new FileInputStream(LoadProperties.getKeyStoreFile());
	        keyStore.load(input, LoadProperties.getKeyPassword().toCharArray());
	        X509Certificate certFromKeyStore = (X509Certificate)keyStore.getCertificate(LoadProperties.getKeyAlias());
	        if(certFromKeyStore !=null )
	        {
	        	System.out.println("*************************************");
	        	System.out.println("Modifiy here for which attribute you want to read from the p12");
	        	System.out.println("Below is the example for Subject DN retrieved from the certificate");
	        	System.out.println("*************************************");
	        	System.out.println("Certificate SubjectDN: "+certFromKeyStore.getSubjectDN() + ", Certificate SerialNumber: "+certFromKeyStore.getSerialNumber());
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
