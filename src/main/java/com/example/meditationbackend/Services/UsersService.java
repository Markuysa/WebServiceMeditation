package com.example.meditationbackend.Services;

import com.example.meditationbackend.Models.authModels.Roles;
import com.example.meditationbackend.Models.authModels.Status;
import com.example.meditationbackend.Models.authModels.User;
import com.example.meditationbackend.Repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public void deleteById(Long id){userRepository.deleteById(id);}

    public void addUser(String name, String email, String password,String login) {
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setLogin(login);
        user.setRole(Roles.USER);
        user.setStatus(Status.ACTIVE);
        System.out.println(user.getLogin()+user.getId()+user.getRole()+user.getStatus());
        userRepository.save(user);
    }
}
