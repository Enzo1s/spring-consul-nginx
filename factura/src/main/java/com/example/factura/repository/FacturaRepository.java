package com.example.factura.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.factura.entity.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long>{

}
