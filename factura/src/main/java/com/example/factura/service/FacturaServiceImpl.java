package com.example.factura.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.factura.entity.Factura;
import com.example.factura.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	private FacturaRepository facturaRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> findById(Long id) {
		return facturaRepository.findById(id);
	}

	@Override
	@Transactional
	public Factura save(Factura entity) {
		return facturaRepository.save(entity);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		facturaRepository.deleteById(id);

	}

}
