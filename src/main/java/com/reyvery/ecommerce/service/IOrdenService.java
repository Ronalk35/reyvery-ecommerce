package com.reyvery.ecommerce.service;

import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.Orden;

@Service
public interface IOrdenService {
 Orden save (Orden orden);
}
