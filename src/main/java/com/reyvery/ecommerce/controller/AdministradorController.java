package com.reyvery.ecommerce.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.reyvery.ecommerce.service.ProductoService;
import com.reyvery.ecommerce.model.Producto;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);
	
	
	@Autowired
	private ProductoService productoService;
	
	@GetMapping("")
	public String home(Model model) {
		
		List<Producto> productos=productoService.findAll();
		model.addAttribute("productos", productos);
		
		return "administrador/home";
	}
}
