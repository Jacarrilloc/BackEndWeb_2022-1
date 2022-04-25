package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.List;
import java.util.ArrayList;

import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isAdmin;
import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isCustomerOrAdmin;
import com.backend.projectodesarrolloweb.laesquinadigital.dtos.ProductoDato;
import com.backend.projectodesarrolloweb.laesquinadigital.model.Product;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IProductService;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("products")
@isAdmin
public class ProductRest {

    @Autowired
    private IProductService productService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDato createProdct(@RequestBody ProductoDato dto){
        Product product = mapper.map(dto, Product.class);

        return  mapper.map(productService.createProduct(product), ProductoDato.class);
    }

    @isCustomerOrAdmin
    @GetMapping("{page}/{size}")
    public Page<ProductoDato> getProducts(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<Product> products = productService.getProducts(pageable);

        List<ProductoDato> res = new ArrayList<>(); 

        for (Product product: products.getContent()){

            res.add(mapper.map(product, ProductoDato.class));
            
        }
        return new PageImpl<>(res, pageable, res.size());
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductoDato updateProduct(@RequestBody ProductoDato dto, @PathVariable Long id){

        Product product = mapper.map(dto, Product.class);

        productService.updateProduct(product, id);

        return dto;
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
    }

}
