package com.example.factura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(FacturaApplication.class, args);
	}

}
