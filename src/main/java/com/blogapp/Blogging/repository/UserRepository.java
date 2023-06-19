package com.blogapp.Blogging.repository;

import com.blogapp.Blogging.dto.RegisterUserDTO;
import com.blogapp.Blogging.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

    Boolean existsByEmail(String email);

    Users findByEmail(String email);

}
