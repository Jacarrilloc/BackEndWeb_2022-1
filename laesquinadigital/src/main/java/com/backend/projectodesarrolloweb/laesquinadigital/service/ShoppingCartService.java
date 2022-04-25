package com.backend.projectodesarrolloweb.laesquinadigital.service;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.CarritoCompras;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.ShoppingCartRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UserRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.util.ShoppingCartNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService implements IShoppingCartService {
    
    @Autowired
    private ShoppingCartRepository repository;
    
    @Autowired
    private UserRepository uRepository;

    @Override
    public void deleteShoppingCart(Long id) {
        Optional<CarritoCompras> user = repository.findById(id);
        
        if(user.isPresent()){
            repository.delete(user.get());
        } else{
            throw new ShoppingCartNotFoundException(id);
        }  
    }

    @Override
    public CarritoCompras updateShoppingCart(CarritoCompras cart, Long id) {
        return repository.findById(id).map(provider ->{

            provider.setProducts(cart.getProducts());;
            return repository.save(provider);

        }).orElseGet(()->{
            throw new ShoppingCartNotFoundException(id);
        });
    }

    @Override
    public CarritoCompras getShoppingCartById(Long id) {
        return repository.findById(id).orElseThrow(()-> new ShoppingCartNotFoundException(id));
    }

    @Override
    public CarritoCompras createShoppingCart(CarritoCompras carritoCompras, Long id) {
        
        CarritoCompras cart = new CarritoCompras();
        cart.setUser(uRepository.getById(id));
        cart.setProducts(carritoCompras.getProducts());

        return repository.save(cart);
    }

    @Override
    public Page<CarritoCompras> getCarts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Page<CarritoCompras> getCartsPerUser(Long id, Pageable pageable){

        UserSys user = uRepository.getById(id);

        return repository.findByUser(user, pageable);
    }
    
}
