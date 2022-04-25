package com.backend.projectodesarrolloweb.laesquinadigital.dtos;

import java.util.Date;

public class PurchaseOrderDTO {

    protected Long id;

    protected UserDTO customer;

    protected Double finalPrice;

    protected CarritoCompraDato cart;

    protected Date purchaseDate;

    public PurchaseOrderDTO() {
    }

    public PurchaseOrderDTO(UserDTO customer, Double finalPrice, CarritoCompraDato cart, Date purchaseDate) {
        this.customer = customer;
        this.finalPrice = finalPrice;
        this.cart = cart;
        this.purchaseDate = purchaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public UserDTO getCustomer() {
        return customer;
    }

    public void setCustomer(UserDTO customer) {
        this.customer = customer;
    }

    public CarritoCompraDato getCart() {
        return cart;
    }

    public void setCart(CarritoCompraDato cart) {
        this.cart = cart;
    }

    

}
