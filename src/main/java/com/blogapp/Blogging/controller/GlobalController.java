package com.blogapp.Blogging.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.blogapp.Blogging.dto.PostDTO;
import com.blogapp.Blogging.models.Posts;
import com.blogapp.Blogging.repository.PostRepository;
import com.blogapp.Blogging.util.EntityHawk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

//import com.app.blog.dto.PostDTO;
//import com.app.blog.dto.UpdatePostDTO;
//import com.app.blog.models.Posts;
//import com.app.blog.models.Users;
//import com.app.blog.repository.PostRepository;
//import com.app.blog.util.EntitiyHawk;
//import com.app.blog.util.PostMapper;

import io.jsonwebtoken.Claims;

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
@RequestMapping("/api")
public class GlobalController extends EntityHawk {

    @Autowired
    PostRepository postRepository;

    @PostMapping(value = "/publish")
    public ResponseEntity publishPost(@RequestBody PostDTO postDto){

        Posts posts1 = new Posts();
        posts1.setPostTitle(postDto.getTitle());
        posts1.setPostBody(postDto.getBody());
        postRepository.save(posts1);
        return genericResponse("Published");
    }

    @GetMapping(value = "/getPost")
    public ResponseEntity getPost(){

        return genericResponse("get post api");
    }

    @GetMapping(value = "getPostCount")
    public ResponseEntity getPostCount(){
        return genericResponse("get post count api");
    }

    @GetMapping(value = "/getPostByUser/{userId}")
    public ResponseEntity getPostByUserId(){
        return genericResponse("get response by user ID");
    }

    @PostMapping(value = "/updatePost")
    public ResponseEntity updatePost(){
        return genericResponse("updating the post");
    }

    @GetMapping(value = "/getPost/{postID}")
    public ResponseEntity getPostByPostId(){
        return genericResponse("returns post as per postID");
    }

    @DeleteMapping(value = "/deletePost/{postID}")
    public ResponseEntity deleteApi(){
        return genericError("data deleted");
    }







}
