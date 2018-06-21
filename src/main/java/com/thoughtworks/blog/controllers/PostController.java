package com.thoughtworks.blog.controllers;

import com.thoughtworks.blog.models.Comment;
import com.thoughtworks.blog.models.Post;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PostController {
    @Autowired
    private PostRepository postRepository;





    @GetMapping("/blog")
    public List<String> retrievePostsByAuthor(@RequestParam String author) {
        List<String> posts = new ArrayList<>();
        for (Post post:postRepository.findByAuthor(author)
             ) {
            posts.add(post.getPost());
        }
        return posts;
    }

    @GetMapping("/votes")
    public List<Post> sortPostsByVotes(@RequestParam String sort,int limit) {
        List<Post> posts = new ArrayList<>();
        for (Post post:postRepository.findAll()
                ) {
            posts.add(post);
        }

        Collections.sort(posts, Comparator.comparingDouble(Post::getVotes));
        Collections.reverse(posts);
        return posts.stream().limit(limit).collect(Collectors.toList());
    }

    @GetMapping("/posts")
    public List<Post> retrieveTopPostsByAuthor(@RequestParam String author,String sort ,int limit) {
        List<Post> posts = new ArrayList<>();
        posts.addAll(postRepository.findByAuthor(author));
        Collections.sort(posts, Comparator.comparingDouble(Post::getVotes));
        Collections.reverse(posts);
        return posts.stream().limit(limit).collect(Collectors.toList());
    }








}
