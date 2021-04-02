package com.example.producto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.producto.entity.Producto;
import com.example.producto.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	private ProductoRepository productoRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Producto> findAll() {
		return productoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Producto> findById(Long id) {
		return productoRepository.findById(id);
	}

	@Override
	public Producto save(Producto producto) {
		return productoRepository.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		productoRepository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true)
	public List<Producto> findByNombre(String nombre) {
		return productoRepository.findByNombre(nombre);
	}

}
