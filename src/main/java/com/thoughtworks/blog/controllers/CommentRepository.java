package com.thoughtworks.blog.controllers;

import com.thoughtworks.blog.models.Comment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentRepository extends CrudRepository<Comment,Long> {
    List<Comment> findByPostId(Long postId);
}
