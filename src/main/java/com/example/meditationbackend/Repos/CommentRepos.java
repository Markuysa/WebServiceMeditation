package com.example.meditationbackend.Repos;


import com.example.meditationbackend.Models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepos extends JpaRepository<Comment,Long> {

    //Problems with that shit
    //List<Comment> findAllByMeditation_id(Long id);
    //Optional<Comment> findAllById(Long Id);
}
