package com.example.meditationbackend.Models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="commentsdb")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    Long Id;

    @Column(name = "m_id")
    Long meditationId;
    @Column(name = "message")
    String message;
    @Column(name = "author")
    String author;


    public Comment(Long meditation, String message, String author) {
        this.meditationId = meditation;
        this.message = message;
        this.author = author;
    }

    public Comment() {

    }
}
