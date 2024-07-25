package com.techblogs.blogWeb.controller;

import com.techblogs.blogWeb.entity.Blog;
import com.techblogs.blogWeb.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<?> createBlog(@RequestBody Blog blog){
        try {
            Blog addedBlog = blogService.addBlog(blog);
            return ResponseEntity.status(HttpStatus.CREATED).body(addedBlog);
        } catch(Exception e) {
            return ResponseEntity.status((HttpStatus.INTERNAL_SERVER_ERROR)).build();
        }
    }
}
