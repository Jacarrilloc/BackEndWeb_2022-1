package com.backend.projectodesarrolloweb.laesquinadigital.service;


import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUsersService {

    UserSys getUserInfo(String email);
    
    void deleteUser(Long id);

    UserSys updateUser(UserSys user, Long id);

    UserSys getUserById(Long  id);

    UserSys createUser(UserSys user);
    
    Page<UserSys> getUsers(Pageable pageable);

}
