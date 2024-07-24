package com.techblogs.blogWeb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Column(length = 10000)
    private String body;

    private String img;
    private Date date;

    private int like;
    private int views;

    private List<String> hashtags;
}
