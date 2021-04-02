package com.example.cliente.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.cliente.entity.Cliente;
import com.example.cliente.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	public ClienteRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByNombre(String nombre) {
		return clienteRepository.findByNombre(nombre);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findByApellido(String apellido) {
		return clienteRepository.findByApellido(apellido);
	}

}
