package com.alper.springbootsmaros.repository;

import com.alper.springbootsmaros.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, BigInt> {

    List<User> findAll();

    @Query("from User where CAST(email as text) like CONCAT(:email, '%')")
    List<User> findByEmail(String email);

}


