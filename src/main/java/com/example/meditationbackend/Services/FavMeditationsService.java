package com.example.meditationbackend.Services;

import com.example.meditationbackend.Repos.FavMeditaions;
import org.springframework.stereotype.Service;

@Service
public class FavMeditationsService {
    private final FavMeditaions favMeditaions;

    public FavMeditationsService(FavMeditaions favMeditaions) {
        this.favMeditaions = favMeditaions;
    }
}
