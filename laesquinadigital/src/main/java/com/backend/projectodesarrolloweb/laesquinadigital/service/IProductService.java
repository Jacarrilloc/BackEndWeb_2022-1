package com.backend.projectodesarrolloweb.laesquinadigital.service;

import com.backend.projectodesarrolloweb.laesquinadigital.model.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {

    void deleteProduct(Long id);

    Product updateProduct(Product product, Long id);

    Product getProductById(Long  id);

    Product createProduct(Product product);
    
    Page<Product> getProducts(Pageable pageable);
    
}
