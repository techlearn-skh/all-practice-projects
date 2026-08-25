package com.skh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbStandaloneDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbStandaloneDemoApplication.class, args);
	}

	/*

	Below is command to generate PKCS12/P12 certificate for HTTPS connection.

	keytool -genkeypair \
			-alias myapp \
			-keyalg RSA \
			-keysize 2048 \
			-storetype PKCS12 \
			-keystore keystore.p12 \
			-validity 3650 \
			-dname "CN=localhost, OU=Dev, O=MyCompany, L=City, ST=State, C=IN" \
			-storepass changeit




			$ keytool -list -v -keystore keystore.p12 -storetype PKCS12 -storepass changeit



			*/

}
