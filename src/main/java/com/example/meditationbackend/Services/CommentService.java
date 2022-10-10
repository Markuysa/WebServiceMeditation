package com.example.meditationbackend.Services;

import com.example.meditationbackend.Models.Comment;
import com.example.meditationbackend.Repos.CommentRepos;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CommentService {
    private final CommentRepos commentRepos;

    public CommentService(CommentRepos commentRepos) {
        this.commentRepos = commentRepos;
    }

    public void addComment( Long meditation_id,String message){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Comment comment = new Comment(meditation_id,message,currentPrincipalName);
        commentRepos.save(comment);
    }

    public void sendListOfComments(Model model,Long id) {
        List<Comment> commentList= commentRepos.findAll();
        model.addAttribute("comments_list",commentList);
    }
}
