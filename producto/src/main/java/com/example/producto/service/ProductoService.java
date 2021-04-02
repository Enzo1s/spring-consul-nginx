package com.example.producto.service;

import java.util.List;
import java.util.Optional;

import com.example.producto.entity.Producto;

public interface ProductoService {

	public Iterable<Producto> findAll();
	
	public Optional<Producto> findById(Long id);
	
	public Producto save (Producto entity);
	
	public void deleteById (Long id);
	
	public List<Producto> findByNombre(String term);

}
