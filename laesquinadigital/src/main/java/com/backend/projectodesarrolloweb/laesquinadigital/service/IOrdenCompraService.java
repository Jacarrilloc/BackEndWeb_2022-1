package com.backend.projectodesarrolloweb.laesquinadigital.service;

import com.backend.projectodesarrolloweb.laesquinadigital.model.OrdenCompra;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IOrdenCompraService {
    
    void deletePurchaseOrder(Long id);

    OrdenCompra updateOrder(OrdenCompra order, Long id);

    OrdenCompra getOrderById(Long  id);

    OrdenCompra createOrder(OrdenCompra order, Long id);
    
    Page<OrdenCompra> getOrders(Pageable pageable);

    Page<OrdenCompra> getOrdersPerUser(Long id, Pageable pageable);
}
