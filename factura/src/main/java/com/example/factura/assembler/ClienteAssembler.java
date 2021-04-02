package com.example.factura.assembler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.factura.entity.Cliente;


@Component
public class ClienteAssembler {

	@Autowired
	private RestTemplate restTemplate;
	
	private static final String CLIENTE_SERVICE_ID = "servicio-cliente";
	private static final String CLIENTE_SERVICE_ENDPOINT = "/servicio-cliente/clientes";
	
	private String getServiceURL(String serviceId, String serviceEndpoint) {
		return new StringBuffer("http://").append(serviceId)
				.append(serviceEndpoint).toString();
	}
	
	public Cliente buscar(Long id) {
		ResponseEntity<Cliente> cliente = restTemplate.exchange(
				getServiceURL(CLIENTE_SERVICE_ID, CLIENTE_SERVICE_ENDPOINT+"/"+id)
				,HttpMethod.GET,null,Cliente.class);
		return cliente.getBody();
	}
	
}
