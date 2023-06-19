package com.blogapp.Blogging.repository;

import com.blogapp.Blogging.models.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts,Integer> {


}
