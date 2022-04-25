package com.backend.projectodesarrolloweb.laesquinadigital.service;

import com.backend.projectodesarrolloweb.laesquinadigital.model.CarritoCompras;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IShoppingCartService {

    void deleteShoppingCart(Long id);

    CarritoCompras updateShoppingCart(CarritoCompras cart, Long id);

    CarritoCompras getShoppingCartById(Long id);

    CarritoCompras createShoppingCart(CarritoCompras carritoCompras, Long id);
    
    Page<CarritoCompras> getCarts(Pageable pageable);

    Page<CarritoCompras> getCartsPerUser(Long id, Pageable pageable);
}
