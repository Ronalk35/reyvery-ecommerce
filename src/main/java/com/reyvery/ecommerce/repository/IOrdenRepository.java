package com.reyvery.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reyvery.ecommerce.model.Orden;
import com.reyvery.ecommerce.model.Usuario;
@Repository
public interface IOrdenRepository extends JpaRepository<Orden, Integer> {
List<Orden> findByUsuario(Usuario usuario);
}
