package com.reyvery.ecommerce.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.Orden;
import com.reyvery.ecommerce.model.Usuario;
import com.reyvery.ecommerce.repository.IOrdenRepository;

@Service
public class OrdenServiceImpl implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenRepository;

	@Override
	public Orden save(Orden orden) {

		return ordenRepository.save(orden);
	}

	@Override
	public List<Orden> findAll() {
		//
		return ordenRepository.findAll();
	}

	public String generarNumeroOrden() {
	    int numero = 0;
	    String numeroConcatenado = "";

	    List<Orden> ordenes = findAll();

	    List<Integer> numeros = new ArrayList<>();

	    if (!ordenes.isEmpty()) {
	        numeros = ordenes.stream()
	            .map(o -> Integer.parseInt(o.getNumero()))
	            .collect(Collectors.toList());

	        numero = Collections.max(numeros) + 1;
	    } else {
	        numero = 1;
	    }

	    if (numero < 10) {
	        numeroConcatenado = "000000000" + String.valueOf(numero);
	    } else if (numero < 100) {
	        numeroConcatenado = "00000000" + String.valueOf(numero);
	    } else if (numero < 1000) {
	        numeroConcatenado = "0000000" + String.valueOf(numero);
	    } else if (numero < 10000) {
	        numeroConcatenado = "000000" + String.valueOf(numero);
	    }

	    return numeroConcatenado;
	}

	@Override
	public List<Orden> findByUsuario(Usuario usuario) {
		
		return ordenRepository.findByUsuario(usuario);
	}

	@Override
	public Optional<Orden> findById(Integer id) {
		
		return ordenRepository.findById(id);
	}

}
