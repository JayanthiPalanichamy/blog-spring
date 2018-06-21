package com.thoughtworks.blog.controllers;

import com.thoughtworks.blog.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<String> retrieveCommentsByPostId(@RequestParam long postid) {
        List<String> comments = new ArrayList<>();
        for (Comment comment:commentRepository.findByPostId(postid)
                ) {
            comments.add(comment.getDescription());
        }
        return comments;
    }

}
