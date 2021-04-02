package com.example.factura.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.factura.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	public List<Cliente> findByNombre(String term);
	
	public List<Cliente> findByApellido(String term);
}
