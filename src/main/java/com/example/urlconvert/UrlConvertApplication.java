package com.example.urlconvert;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UrlConvertApplication {

	/*

	POST
	http://localhost:8080/api/url/get-convert-url/netology.ru

	GET
	http://localhost:8080/api/url/get-long-url/-1454289302

	 */

	public static void main(String[] args) {
		SpringApplication.run(UrlConvertApplication.class, args);
	}

}
