package com.example.meditationbackend.Repos;

import com.example.meditationbackend.Models.authModels.User;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);
    User findUserByEmail(String email);
}
