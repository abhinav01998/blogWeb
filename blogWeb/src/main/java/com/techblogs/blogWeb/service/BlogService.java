package com.techblogs.blogWeb.service;

import com.techblogs.blogWeb.entity.Blog;

import java.util.List;

public interface BlogService {
    Blog addBlog(Blog blog);

    List<Blog> getAllBlogs();
}
