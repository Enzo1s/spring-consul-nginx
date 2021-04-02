package com.example.cliente.service;

import java.util.List;
import java.util.Optional;

import com.example.cliente.entity.Cliente;

public interface ClienteService {
	
	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(Long id);
	
	public Cliente save (Cliente entity);
	
	public void deleteById (Long id);
	
	public List<Cliente> findByNombre(String term);
	
	public List<Cliente> findByApellido(String term);

}
