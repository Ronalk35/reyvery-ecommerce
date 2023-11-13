package com.reyvery.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.Orden;
import com.reyvery.ecommerce.model.Usuario;

@Service
public interface IOrdenService {
	List<Orden> findAll();
	Optional<Orden> findById(Integer id);
 Orden save (Orden orden);
 String generarNumeroOrden();
 List<Orden> findByUsuario(Usuario usuario);
 
}
