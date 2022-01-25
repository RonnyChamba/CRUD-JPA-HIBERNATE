package com.ideas.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ideas.app.jpa.model.Conductor;
import com.ideas.app.jpa.model.TipoTransporte;
import com.ideas.app.jpa.model.Transporte;
import com.ideas.app.repository.TransporteRepository;

@Service
@Transactional
public class TransporteServiceImpl implements TransporteService {

	@Autowired
	private TransporteRepository transporteRepository;
	
	@Override 
	public Iterable<Transporte> list() {

		Iterable<Transporte> transportes = transporteRepository.findAll();
		
		for (Transporte t : transportes){
			
			t.getConductor().toString();
			t.getTipoTransporte().toString();
		}
		return transportes;

	}

	@Override
	public Transporte buscarById(Integer codigo) {
		
		Transporte transporte  = transporteRepository.findById(codigo).orElse(null);
		transporte.toString();
		return transporte;
	}

	@Override
	public void delete(Integer codigo) {

		transporteRepository.deleteById(codigo);
	}

	@Override
	public void add(Transporte transporte) {
		
		/*
		TipoTransporte tipo = tipoTransporteService.buscarById(transporte.getTipoTransporte().getCodigo());
		Conductor conductor = conductorService.buscarById( transporte.getConductor().getCodigo());
		
		transporte.setConductor(conductor);
		transporte.setTipoTransporte(tipo);
		
		System.out.println("TIPO: "+ tipo);
		System.out.println("CONDUCTOR: " + conductor);
		*/
		System.out.println("TRANSPORTE: " + transporte);
		
		transporteRepository.save(transporte);
	}

	@Override
	public void update(Transporte transporte) {
		
		transporteRepository.save(transporte);

	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return transporteRepository.count();
	}

}
