package com.techblogs.blogWeb.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techblogs.blogWeb.entity.Blog;
import com.techblogs.blogWeb.repository.BlogRepository;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BlogServiceImplementation implements BlogService {

    @Autowired
    private BlogRepository postRepo;

    public Blog addBlog(Blog blog) {
        blog.setLikes(0);
        blog.setViews(0);
        blog.setDate(new Date());

        return postRepo.save(blog);
    }

    public List<Blog> getAllBlogs() {
        return postRepo.findAll();
    }

    public Blog getBlogById(Long blogId) {
        Optional<Blog> optionalPost = postRepo.findById(blogId);
        if(optionalPost.isPresent()) {
            Blog blog = optionalPost.get();
            blog.setViews(blog.getViews() + 1);
            return postRepo.save(blog);
        } else {
            throw new EntityNotFoundException("Blog not found");
        }
    }
}
