package com.backend.projectodesarrolloweb.laesquinadigital.rest;

import java.util.ArrayList;
import java.util.List;

import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isAdmin;
import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isCustomer;
import com.backend.projectodesarrolloweb.laesquinadigital.anotations.isCustomerOrAdmin;
import com.backend.projectodesarrolloweb.laesquinadigital.dtos.ShoppingCartDTO;
import com.backend.projectodesarrolloweb.laesquinadigital.model.CarritoCompras;
import com.backend.projectodesarrolloweb.laesquinadigital.service.IShoppingCartService;

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
@RequestMapping("ShoppingCarts")
public class ShoppingCartRest {

    @Autowired
    private IShoppingCartService shoppingCartService;

    @Autowired
    private ModelMapper mapper;


    @isAdmin
    @GetMapping("{page}/{size}")
    public Page<ShoppingCartDTO> getShoppingCarts(@PathVariable("page") int pagina, @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(pagina, size, Sort.by("id"));

        Page<CarritoCompras> carts = shoppingCartService.getCarts(pageable);

        List<ShoppingCartDTO> res = new ArrayList<>();

        for (CarritoCompras cart : carts.getContent()) {

            res.add(mapper.map(cart, ShoppingCartDTO.class));

        }
        return new PageImpl<>(res, pageable,res.size());
    }

    @isCustomer
    @PostMapping(value = "create/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCartDTO createShoppingCart(@RequestBody ShoppingCartDTO dto, @PathVariable("id") Long id){

        CarritoCompras cart = mapper.map(dto, CarritoCompras.class);

        return mapper.map(shoppingCartService.createShoppingCart(cart, id), ShoppingCartDTO.class);

    }

    @isCustomerOrAdmin
    @PutMapping(value = "actulizar/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ShoppingCartDTO uCartDTO(@RequestBody ShoppingCartDTO dto, @PathVariable Long id){

        CarritoCompras cart = mapper.map(dto, CarritoCompras.class);

        shoppingCartService.updateShoppingCart(cart, id);

        return dto;
    }

    @isCustomerOrAdmin
    @DeleteMapping("delete/{id}")
    public void deleteShoppingCart(@PathVariable Long id){
        shoppingCartService.deleteShoppingCart(id);
    }

    @isCustomerOrAdmin
    @GetMapping("carts/per/user/{id}/{page}/{size}")
    public Page<ShoppingCartDTO> getCartsPerUser(@PathVariable("id") Long id, @PathVariable ("page") int page,
     @PathVariable("size") int size){

        Pageable pageable = PageRequest.of(page, size, Sort.by("id"));

        Page<CarritoCompras> carts = shoppingCartService.getCartsPerUser(id, pageable);

        List<ShoppingCartDTO> res = new ArrayList<>();

        for (CarritoCompras cart : carts.getContent()) {

            res.add(mapper.map(cart, ShoppingCartDTO.class));

        }

        return new PageImpl<>(res, pageable,res.size());
    }

}