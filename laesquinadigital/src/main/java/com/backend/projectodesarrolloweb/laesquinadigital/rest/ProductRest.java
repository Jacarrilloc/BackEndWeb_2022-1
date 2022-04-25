package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.List;
import java.util.ArrayList;

import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isAdmin;
import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isCustomerOrAdmin;
import com.backend.projectodesarrolloweb.laesquinadigital.dtos.ProductDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.Producto;
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
@RequestMapping("productos")
@isAdmin
public class ProductRest {

    @Autowired
    private IProductService productService;

    @Autowired
    private ModelMapper mapper;

    @PostMapping(value = "create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO createProdct(@RequestBody ProductDTO dto){
        Producto producto = mapper.map(dto, Producto.class);

        return  mapper.map(productService.createProduct(producto), ProductDTO.class);
    }

    @isCustomerOrAdmin
    @GetMapping("{page}/{size}")
    public Page<ProductDTO> getProducts(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<Producto> productos = productService.getProducts(pageable);

        List<ProductDTO> res = new ArrayList<>(); 

        for (Producto producto: productos.getContent()){

            res.add(mapper.map(producto, ProductDTO.class));
            
        }
        return new PageImpl<>(res, pageable, res.size());
    }

    @PutMapping(value = "update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ProductDTO updateProduct(@RequestBody ProductDTO dto, @PathVariable Long id){

        Producto producto = mapper.map(dto, Producto.class);

        productService.updateProduct(producto, id);

        return dto;
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
    }

}
