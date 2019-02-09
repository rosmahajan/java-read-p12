# Java-read-p12 using Bouncycastle
Read certificate details from p12/pfx file

This is the java program to retrieve the certificate details from the p12 file

Before starting ensure you have, your p12 file handy with password as well as you know its alais
Once you know all the details place it in application.properties

Below is the structure of it 

p12.keyStoreFile=ZXXXX.p12
p12.keyStorePass=pass
p12.keyStoreAllias=alias

# Exception

If you file doesn't exists, program will throw FileNotFoundException as below

java.io.FileNotFoundException: ZXXXX.p12 (No such file or directory)
	at java.io.FileInputStream.open0(Native Method)
	at java.io.FileInputStream.open(FileInputStream.java:195)
	at java.io.FileInputStream.<init>(FileInputStream.java:138)
	at java.io.FileInputStream.<init>(FileInputStream.java:93)
	at com.ros.read.p12.ReadP12File.readCertificateFromP12File(ReadP12File.java:31)
	at com.ros.read.p12.ReadP12File.main(ReadP12File.java:18)


If you have wrong password for the p12 below exception is thrown

java.io.IOException: keystore password was incorrect
	at sun.security.pkcs12.PKCS12KeyStore.engineLoad(PKCS12KeyStore.java:2015)
	at java.security.KeyStore.load(KeyStore.java:1445)
	at com.ros.read.p12.ReadP12File.readCertificateFromP12File(ReadP12File.java:32)
	at com.ros.read.p12.ReadP12File.main(ReadP12File.java:18)
Caused by: java.security.UnrecoverableKeyException: failed to decrypt safe contents entry: javax.crypto.BadPaddingException: Given final block not properly padded
	... 4 more


# Execution

Build the project using maven 

1. mvn clean install
2. Jar with dependencies will be created 
3. RUN java -jar java-read-p12-1.0-jar-with-dependencies.jar
