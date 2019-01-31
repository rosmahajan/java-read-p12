package com.ros.read.p12;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {

	InputStream inputStream;
	
	private static String keyStoreFile = null;
	private static String keyPassword = null;
	private static String keyAlias = null;
	
	public void getPropValues() throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "application.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			setKeyStoreFile(prop.getProperty("p12.keyStoreFile"));
			setKeyPassword(prop.getProperty("p12.keyStorePass"));
			setKeyAlias(prop.getProperty("p12.keyStoreAllias"));;
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
	}


	static String getKeyStoreFile() {
		return keyStoreFile;
	}

	static void setKeyStoreFile(String keyStoreFile) {
		LoadProperties.keyStoreFile = keyStoreFile;
	}

	static String getKeyPassword() {
		return keyPassword;
	}

	static String setKeyPassword(String keyPassword) {
		LoadProperties.keyPassword = keyPassword;
		return keyPassword;
	}

	static String getKeyAlias() {
		return keyAlias;
	}

	static void setKeyAlias(String keyAlias) {
		LoadProperties.keyAlias = keyAlias;
	}
}