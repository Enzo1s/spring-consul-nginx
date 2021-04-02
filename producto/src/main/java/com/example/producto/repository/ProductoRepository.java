package com.example.producto.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.producto.entity.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	public List<Producto> findByNombre(String term);

}
