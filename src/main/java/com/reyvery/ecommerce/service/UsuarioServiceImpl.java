package com.reyvery.ecommerce.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.Usuario;
import com.reyvery.ecommerce.repository.IUsuarioRepository;
@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	public Optional<Usuario> findById(Integer id) {
	
		return usuarioRepository.findById(id) ;
	}
	
	

}
