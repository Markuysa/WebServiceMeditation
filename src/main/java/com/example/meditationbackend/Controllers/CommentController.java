package com.example.meditationbackend.Controllers;

import com.example.meditationbackend.Services.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meditations")
public class CommentController {
    public final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/{id}")
    public String addComment(@RequestParam String comment, @PathVariable Long id, Model model){
        commentService.sendListOfComments(model,id);
        commentService.addComment(id,comment);
        return "redirect:/meditations/" + id;
    }
}
