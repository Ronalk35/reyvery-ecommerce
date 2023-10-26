package com.reyvery.ecommerce.service;

import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.DetalleOrden;
import com.reyvery.ecommerce.repository.IDetalleOrdenRepository;

@Service
public class DatalleOrdenServiceImpl implements IDetalleOrdenService {

	private IDetalleOrdenRepository detalleOrdenRepository;
	
	@Override
	public DetalleOrden save(DetalleOrden detalleOrden) {
		
		return detalleOrdenRepository.save(detalleOrden);
	}

}
