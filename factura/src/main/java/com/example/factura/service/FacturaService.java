package com.example.factura.service;

import java.util.Optional;

import com.example.factura.entity.Factura;

public interface FacturaService {

	public Iterable<Factura> findAll();
	
	public Optional<Factura> findById(Long id);
	
	public Factura save(Factura entity);
	
	public void deleteById (Long id);
	
}
