package com.backend.projectodesarrolloweb.laesquinadigital.repository;

import java.util.List;
import java.util.Optional;

import com.backend.projectodesarrolloweb.laesquinadigital.model.UserSys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserSys, Long>{
    
    Optional<UserSys> findById(Long id);

    Optional<UserSys> findByEmail(String email);

    List<UserSys> findByFirstName(String firstName);

    @Query(value = "SELECT u FROM UserSys u WHERE u.email=?1 AND u.password=?2")
    Optional<UserSys> loginMethod(String email, String password);

}

