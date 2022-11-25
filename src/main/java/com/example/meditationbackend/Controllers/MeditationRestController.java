package com.example.meditationbackend.Controllers;


import com.example.meditationbackend.Models.MeditationModel.Meditation;
import com.example.meditationbackend.Services.CommentService;
import com.example.meditationbackend.Services.MeditationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/meditations")
public class MeditationRestController {

    private final MeditationService meditationService;
    private final CommentService commentService;

    public MeditationRestController(MeditationService meditationService, CommentService commentService) {
        this.meditationService = meditationService;
        this.commentService = commentService;
    }

    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:8080")
    List<Meditation> getAllMeditations(){

        return meditationService.showAllMeditations();
    }
    @GetMapping("/{id}")
    public Object getMeditationById(@PathVariable Long id) {

        return meditationService.showMeditation(id);
    }

    @PostMapping("/add")
    public @ResponseBody void addAPIMeditation(@RequestParam String imageURL
            , @RequestParam String videoURL, @RequestParam String description,@RequestParam String rating) throws IOException {
        meditationService.addNewMeditation(imageURL, videoURL, description,rating);
    }


}
