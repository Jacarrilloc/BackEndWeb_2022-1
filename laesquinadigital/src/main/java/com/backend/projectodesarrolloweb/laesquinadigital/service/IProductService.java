package com.backend.projectodesarrolloweb.laesquinadigital.service;

import com.backend.projectodesarrolloweb.laesquinadigital.model.Producto;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    void deleteProduct(Long id);

    Producto updateProduct(Producto producto, Long id);

    Producto getProductById(Long  id);

    Producto createProduct(Producto producto);
    
    Page<Producto> getProducts(Pageable pageable);
    
}
