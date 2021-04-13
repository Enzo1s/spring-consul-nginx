package com.example.cliente.controller;

import java.util.Optional;

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

import com.example.cliente.entity.Cliente;
import com.example.cliente.service.ClienteServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "clientes")
public class ClienteController {
	
	//@Autowired
	protected ClienteServiceImpl service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> mostrar(@PathVariable Long id) {
		Optional<Cliente> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(o.get());
	}
	
	@GetMapping("/filtrar/nombre/{nombre}")
	public ResponseEntity<?> filtrarNombre(@PathVariable String nombre) {
		return ResponseEntity.ok(service.findByNombre(nombre));
	}
	
	@GetMapping("/filtrar/apellido/{apellido}")
	public ResponseEntity<?> filtrarApellido(@PathVariable String apellido) {
		return ResponseEntity.ok(service.findByNombre(apellido));
	}
	
	@PostMapping("/crear")
	public ResponseEntity<?> crear(@RequestBody Cliente cliente) {
		Cliente clienteDB = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteDB);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Optional<Cliente> o = service.findById(id);
		if(o.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDB = o.get();
		clienteDB.setNombre(cliente.getNombre());
		clienteDB.setApellido(cliente.getApellido());
		clienteDB.setDni(cliente.getDni());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteDB));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
