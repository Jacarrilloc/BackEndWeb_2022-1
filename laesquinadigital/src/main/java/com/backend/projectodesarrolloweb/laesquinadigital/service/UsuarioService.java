package com.backend.projectodesarrolloweb.laesquinadigital.service;


import java.util.ArrayList;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.UsuarioSys;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.RolesRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.repository.UsusarioRepository;
import com.backend.projectodesarrolloweb.laesquinadigital.util.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    private RolesRepository rolesRepository;

    @Autowired
    private UsusarioRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void deleteUser(Long id) {

        Optional<UsuarioSys> user = repository.findById(id);

        if(user.isPresent()){
            repository.delete(user.get());
        } else{
            throw new UserNotFoundException(id);
        }       
    
    }

    @Override
    public UsuarioSys getUserById(Long id) {

        return repository.findById(id).orElseThrow(()-> new UserNotFoundException(id));
    
    }

    @Override
    public UsuarioSys createUser(UsuarioSys user) {
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRol(rolesRepository.getById(2l));
        user.setCarts(new ArrayList<>());
        user.setOrders(new ArrayList<>());
        return repository.save(user);

    }
    
    @Override
    public UsuarioSys updateUser(UsuarioSys user, Long id) {

        return repository.findById(id).map(provider ->{
            provider.setFirstName(user.getFirstName());
            provider.setLastName(user.getLastName());
            provider.setBirthDate(user.getBirthDate());
            provider.setEmail(user.getEmail());
            provider.setPassword(user.getPassword());
            provider.setPassword(user.getPassword());

            return repository.save(provider);
        }).orElseGet(()->{
            throw new UserNotFoundException(id);
        });
    }

    @Override
    public Page<UsuarioSys> getUsers(Pageable pageable) {

        return repository.findAll(pageable);

    }

    @Override
    public UsuarioSys getUserInfo(String email) {
        return repository.findByEmail(email).orElseThrow(()-> new UserNotFoundException(email));
    }
        
}
