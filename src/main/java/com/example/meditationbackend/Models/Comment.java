package com.example.meditationbackend.Models;

import com.example.meditationbackend.Models.authModels.USR;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

@Data
@Entity
@Table(name="commentsdb")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "Id")
    Long Id;

    @Column(name = "m_id")
    Long meditation_id;
    @Column(name = "message")
    String message;
    @Column(name = "author")
    String author;


    public Comment(Long meditation_id, String message, String author) {
        this.meditation_id = meditation_id;
        this.message = message;
        this.author = author;
    }

    public Comment() {

    }
}
