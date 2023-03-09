package com.usuarioservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usuarioservice.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
