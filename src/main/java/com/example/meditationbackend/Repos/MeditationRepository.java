package com.example.meditationbackend.Repos;

import com.example.meditationbackend.Models.MeditationModel.Meditation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface MeditationRepository extends JpaRepository<Meditation,Long> {

    @Override
    Optional<Meditation> findById(Long aLong);
}
