package com.devsuperior.dslist.repositories;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.devsuperior.dslist.entities.UserEntity;



public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByLogin(String login);

    UserEntity findByName(String name);

    void save(UserEntity entity);

    boolean existsByName(String name);

    boolean authenticate(String name, String password);

}
