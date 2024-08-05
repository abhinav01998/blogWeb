package com.techblogs.blogWeb.controller;

import com.techblogs.blogWeb.entity.Blog;
import com.techblogs.blogWeb.service.BlogService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping
    public ResponseEntity<List<Blog>> getAllBlogs() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(blogService.getAllBlogs());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{blogId}")
    public ResponseEntity<?> getBlogById(@PathVariable Long blogId) {
        try {
            Blog blog = blogService.getBlogById(blogId);
            return ResponseEntity.ok(blog);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{blogId}/like")
    public ResponseEntity<?> likeBlog(@PathVariable Long blogId) {
        try {
            blogService.likeBlog(blogId);
            return ResponseEntity.ok(new String[]{"Blog Like Received!!!"});
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
