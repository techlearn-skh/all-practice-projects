package com.skh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityDemoApplication.class, args);
	}

}


/**
 * Commands to generate keystore, truststore
 *
 * # Generate keystore:

 keytool -genkeypair \
 -alias myapp \
 -keyalg RSA \
 -keysize 2048 \
 -storetype PKCS12 \
 -keystore mykeystore.p12 \
 -validity 365 \
 -storepass changeit \
 -keypass changeit \
 -dname "CN=localhost" \
 -ext SAN=dns:localhost,ip:127.0.0.1

 * # export public key certificate:

 keytool -exportcert \
 -alias myapp \
 -storetype PKCS12 \
 -keystore mykeystore.p12 \
 -rfc \
 -file myapp-public.crt \
 -storepass changeit

 * # Generate truststore

 keytool -importcert \
 -alias myapp \
 -file myapp-public.crt \
 -storetype PKCS12 \
 -keystore mytruststore.p12 \
 -storepass changeit \
 -trustcacerts


 */