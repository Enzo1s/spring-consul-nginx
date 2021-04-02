package com.example.factura.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ServiceConfiguration {

	@Bean
	@LoadBalanced
	public RestTemplate LoadBalancedRestTemplate() {
		return new RestTemplate();
	}
}