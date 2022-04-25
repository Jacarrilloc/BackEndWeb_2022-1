package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.CarritoCompras;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends JpaRepository<CarritoCompras, Long>{

    Optional<CarritoCompras> findById(Long id);

    Page<CarritoCompras> findByUser(UserSys user, Pageable pageable);

}
