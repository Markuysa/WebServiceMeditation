package com.example.meditationbackend.Controllers;

import com.example.meditationbackend.Services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meditations")
public class CommentController {
    public final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{id}")
    public void addComment(@RequestParam String comment, @PathVariable Long id){

        commentService.addComment(id,comment);
    }
}
