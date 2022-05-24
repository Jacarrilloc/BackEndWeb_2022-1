package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.Date;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.PurchaseOrder;
import com.backend.projectodesarrolloweb.laesquinadigital.model.ShoppingCart;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    Optional<PurchaseOrder> findById(Long id);

    Optional<PurchaseOrder> findByCart(ShoppingCart cart);

    Page<PurchaseOrder> findByPurchaseDate(Date purchaseDate, Pageable pageable);

    Page<PurchaseOrder> findByCustomer(UserSys customer, Pageable pageable);

}
