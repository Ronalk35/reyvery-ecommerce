package com.reyvery.ecommerce.service;

import java.util.Optional;

import com.reyvery.ecommerce.model.Usuario;

public interface IUsuarioService {
Optional<Usuario> findById(Integer id);
Usuario save(Usuario usuario);
}
