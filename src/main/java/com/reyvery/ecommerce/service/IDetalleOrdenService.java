package com.reyvery.ecommerce.service;

import org.springframework.stereotype.Service;

import com.reyvery.ecommerce.model.DetalleOrden;

@Service
public interface IDetalleOrdenService {
DetalleOrden save (DetalleOrden detalleOrden) ;
}
