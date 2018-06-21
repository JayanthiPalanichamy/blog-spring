package com.thoughtworks.blog.controllers;

import com.thoughtworks.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findByAuthor(String author);
}

