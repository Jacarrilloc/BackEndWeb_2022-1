package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.CarritoCompra;
import com.backend.projectodesarrolloweb.laesquinadigital.model.UsuarioSys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Long>{

    Optional<CarritoCompra> findById(Long id);

    Page<CarritoCompra> findByUser(UsuarioSys user, Pageable pageable);

}
