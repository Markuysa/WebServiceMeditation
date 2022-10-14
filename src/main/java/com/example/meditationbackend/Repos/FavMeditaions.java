package com.example.meditationbackend.Repos;

import com.example.meditationbackend.Models.MeditationModel.Meditation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FavMeditaions extends JpaRepository<Meditation,Long> {




}
