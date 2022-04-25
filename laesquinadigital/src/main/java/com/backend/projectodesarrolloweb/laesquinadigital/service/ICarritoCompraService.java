package com.backend.projectodesarrolloweb.laesquinadigital.service;

import com.backend.projectodesarrolloweb.laesquinadigital.model.CarritoCompra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarritoCompraService {

    void deleteShoppingCart(Long id);

    CarritoCompra updateShoppingCart(CarritoCompra cart, Long id);

    CarritoCompra getShoppingCartById(Long id);

    CarritoCompra createShoppingCart(CarritoCompra carritoCompra, Long id);
    
    Page<CarritoCompra> getCarts(Pageable pageable);

    Page<CarritoCompra> getCartsPerUser(Long id, Pageable pageable);
}
