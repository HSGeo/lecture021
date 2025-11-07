package com.example.api_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//scanBasePackages를 사용하면 다른 패키지에 있는 것들도 가져올 수 있음.
@SpringBootApplication(scanBasePackages = {"com.example.api_service", "com.example.product_service", "com.example.order_service", "com.example.user_service"})
public class ApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiServiceApplication.class, args);
	}

}
