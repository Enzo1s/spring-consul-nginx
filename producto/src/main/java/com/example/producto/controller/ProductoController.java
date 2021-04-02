package com.example.producto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.producto.entity.Producto;
import com.example.producto.service.ProductoServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "productos")
public class ProductoController{

	//@Autowired
	protected ProductoServiceImpl service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		Optional<Producto> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@GetMapping("/filtrar/nombre/{nombre}")
	public ResponseEntity<?> filtrar(@PathVariable String nombre) {
		return ResponseEntity.ok(service.findByNombre(nombre));
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Producto producto) {
		Producto productoDB = service.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Producto producto, @PathVariable Long id) {
		Optional<Producto> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Producto productoDB = o.get();
		productoDB.setNombre(producto.getNombre());
		productoDB.setPrecio(producto.getPrecio());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoDB));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar (@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}
