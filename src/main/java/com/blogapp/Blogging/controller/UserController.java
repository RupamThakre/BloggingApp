package com.blogapp.Blogging.controller;

import com.blogapp.Blogging.dto.LoginDto;
import com.blogapp.Blogging.dto.RegisterUserDTO;
import com.blogapp.Blogging.models.Users;
import com.blogapp.Blogging.repository.UserRepository;
import com.blogapp.Blogging.util.EntityHawk;
import com.blogapp.Blogging.util.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.app.blog.dto.LoginDto;
//import com.app.blog.dto.RegisterUserDTO;
//import com.app.blog.models.Users;
//import com.app.blog.repository.UserRepository;
//import com.app.blog.util.EntitiyHawk;
//import com.app.blog.util.JWTUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1460344
 */
@RestController
@RequestMapping("/")
public class UserController extends EntityHawk {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping(value = "register")
    public ResponseEntity registerUser(@RequestBody RegisterUserDTO register){

        if(register.getEmail()==null){
            return genericError("email Email cannot be blank");
        }
        Users users1 = new Users();
        users1.setEmail(register.getEmail());
        users1.setPassword(register.getPassword());
        users1.setUserName(register.getName());
        userRepository.save(users1);
        return genericResponse("User Registered");
    }

    @PostMapping(value = "login")
    public ResponseEntity loginUser(@RequestBody LoginDto login){

        boolean emailExists = userRepository.existsByEmail(login.getEmail());
        if(emailExists){
            Users userData = userRepository.findByEmail(login.getEmail());
            String token = jwtUtils.CreateJWTToken(userData);
            return genericSuccess(token);
        }else{
            return genericError("Invalid Username or Password");
        }
    }

}
