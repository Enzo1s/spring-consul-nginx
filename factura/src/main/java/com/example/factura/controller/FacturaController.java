package com.example.factura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.factura.assembler.ClienteAssembler;
import com.example.factura.entity.Cliente;
import com.example.factura.entity.Factura;
import com.example.factura.entity.Producto;
import com.example.factura.service.FacturaServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "factura")
public class FacturaController {
	
	//@Autowired
	protected FacturaServiceImpl service;
	
	@Autowired
	protected ClienteAssembler clienteAssembler;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		Optional<Factura> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@PostMapping("/cliente/{id}/comprar")
	public ResponseEntity<?> crear(@RequestBody List<Producto> productos,@PathVariable Long id) {
		Cliente cliente = clienteAssembler.buscar(id);
		if(cliente==null) {
			return ResponseEntity.notFound().build();
		}
		Factura facturaDB = new Factura();
		facturaDB.setCliente(cliente);
		facturaDB.setProductos(productos);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(facturaDB));
	}

}
