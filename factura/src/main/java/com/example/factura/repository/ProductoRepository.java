package com.example.factura.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.factura.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	public List<Producto> findByNombre(String term);

}
