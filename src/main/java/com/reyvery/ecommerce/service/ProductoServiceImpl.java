package com.reyvery.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.Producto;
import com.reyvery.ecommerce.repository.IProductoRepository;


@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private IProductoRepository iProductoRepository;
	
	
	@Override
	public Producto save(Producto producto) {
		
		return iProductoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
	
		return iProductoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		iProductoRepository.save(producto);
		
	}

	@Override
	public void delete(Integer id) {
		iProductoRepository.deleteById(id);
		
	}

	@Override
	public List<Producto> findAll() {
		
		return iProductoRepository.findAll();
	}

}
