package com.example.meditationbackend.Repos;


import com.example.meditationbackend.Models.Comment;
import com.example.meditationbackend.Models.MeditationModel.Meditation;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface CommentRepos extends JpaRepository<Comment,Long> {


    List<Comment> findCommentByMeditationId(Long id);


}
