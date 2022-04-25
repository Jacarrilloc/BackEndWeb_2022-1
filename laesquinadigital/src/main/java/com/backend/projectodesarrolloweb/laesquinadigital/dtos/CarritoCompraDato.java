package com.backend.projectodesarrolloweb.laesquinadigital.dtos;

import java.util.List;

public class CarritoCompraDato {
    
    protected Long id;

    protected UserDTO user;

    protected List<ProductoDato> products;

    public CarritoCompraDato() {
    }

    public CarritoCompraDato(Long id, UserDTO user) {
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<ProductoDato> getProducts() {
        return products;
    }

    public void setProducts(List<ProductoDato> products) {
        this.products = products;
    }

    

}
