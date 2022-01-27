package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.Compra;
import com.ideas.app.jpa.model.Factura;
import com.ideas.app.repository.CompraRepository;

@Service
@Transactional
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private FacturaService facturaService;
	
	@Override
	public Iterable<Compra> list() {
		return  compraRepository.findAll();
	}

	@Override
	public Compra buscarById(Integer codigo) {
		
		
		return compraRepository.findById(codigo).orElse(null);
	}

	@Override
	public void delete(Integer codigo) {
	
		compraRepository.deleteById(codigo);
	}

	@Override
	public void add(Compra compra) {

		// Recuperar la factura antes de persistir la compra
		Factura factura = compra.getFactura();		
		
		// Persisto primero la compra
		Compra compraPersist =  compraRepository.save(compra);
		
		// El codigo de la factura debe ser igual al  codigo de la compra recien persistida.
		// (el codigo factura es un campo no  autoincrement)
		factura.setCodigo( compraPersist.getCodigo());
		
		// Asignar la compra ya persistente a la factura
		factura.setCompra(compraPersist);
	
		// Persistir la factura
		facturaService.add(factura);
		
	}

	@Override
	public void update(Compra compra) {
		compraRepository.save(compra);
	}

	@Override
	public Long count() {
		
		return compraRepository.count();
	}

}
