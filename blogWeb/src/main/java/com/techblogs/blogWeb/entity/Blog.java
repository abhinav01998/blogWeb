package com.techblogs.blogWeb.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Data
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;

    @Column(length = 10000)
    private String body;

    private String img;
    private Date date;

    private int likes;
    private int views;

    public void setLikeCount(int i) {
        this.likes = 0;
    }

    public void setViewCount(int i) {
        this.views = 0;
    }
}
