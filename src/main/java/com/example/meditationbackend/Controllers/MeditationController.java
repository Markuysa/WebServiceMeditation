package com.example.meditationbackend.Controllers;


import com.example.meditationbackend.Models.Comment;
import com.example.meditationbackend.Services.CommentService;
import com.example.meditationbackend.Services.MeditationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/meditations")
public class MeditationController {

    private final MeditationService meditationService;
    private final CommentService commentService;

    public MeditationController(MeditationService meditationService, CommentService commentService) {
        this.meditationService = meditationService;
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public String getMeditationById(Model model, @PathVariable Long id) {
        meditationService.showMeditationById(model, id);
        commentService.sendListOfComments(model,id);
        return "Meditation_page";
    }

    @GetMapping("/showall")
    public String showAllMeditations(Model model) {
        meditationService.showAllMeditations(model);
        return "list_of_meditations";
    }

    @GetMapping("/add")
    public String addMeditation() {
        return "addMeditation";
    }

    @PostMapping("/add")
    public @ResponseBody void addNewMeditation(@RequestParam MultipartFile image
            , @RequestParam String videoURL, @RequestParam String description) throws IOException {
        meditationService.addNewMeditation(image, videoURL, description);
    }

}
