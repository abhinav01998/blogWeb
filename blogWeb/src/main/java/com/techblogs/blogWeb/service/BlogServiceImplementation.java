package com.techblogs.blogWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.techblogs.blogWeb.entity.Blog;
import com.techblogs.blogWeb.repository.BlogRepository;


import java.util.Date;

@Service
public class BlogServiceImplementation implements BlogService {

    @Autowired
    private BlogRepository postRepo;

    public Blog addBlog(Blog blog) {
        blog.setLikeCount(0);
        blog.setViewCount(0);
        blog.setDate(new Date());

        return postRepo.save(blog);

    }
}
