package com.example.meditationbackend.Models.MeditationModel;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="meditations")
public class Meditation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "image")
    String imagePATH;
    @Column(name = "videoURL")
    String videoURL;
    @Column(name = "description")
    String description;

    @Column(name = "rating")
    String rating;

    public Meditation(){};
    public Meditation(String imagePATH, String videoURL, String description,String rating) {
        this.imagePATH = imagePATH;
        this.videoURL = videoURL;
        this.description = description;
        this.rating = rating;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
