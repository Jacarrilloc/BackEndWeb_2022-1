package com.backend.projectodesarrolloweb.laesquinadigital.service;


import com.backend.projectodesarrolloweb.laesquinadigital.model.UsuarioSys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsuarioService {

    UsuarioSys getUserInfo(String email);
    
    void deleteUser(Long id);

    UsuarioSys updateUser(UsuarioSys user, Long id);

    UsuarioSys getUserById(Long  id);

    UsuarioSys createUser(UsuarioSys user);
    
    Page<UsuarioSys> getUsers(Pageable pageable);

}
