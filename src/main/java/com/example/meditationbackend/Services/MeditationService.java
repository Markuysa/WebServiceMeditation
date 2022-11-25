package com.example.meditationbackend.Services;

import com.example.meditationbackend.Models.MeditationModel.Meditation;
import com.example.meditationbackend.Models.authModels.Roles;
import com.example.meditationbackend.Models.authModels.User;
import com.example.meditationbackend.Repos.MeditationRepository;
import com.example.meditationbackend.Repos.UserRepository;
import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.IOException;
import java.util.*;

import static java.lang.Math.abs;
@Service
public class MeditationService {
    private final MeditationRepository meditationRepository;
    private final UserRepository userRepository;
    //@Value("${upload.path}")
    private String path;

    public MeditationService(MeditationRepository meditationRepository, UserRepository userRepository) {
        this.meditationRepository = meditationRepository;
        this.userRepository = userRepository;
    }
    public List<Meditation> showAllMeditations(){
        String json = new Gson().toJson(meditationRepository.findAll());
        System.out.println(json);
        return meditationRepository.findAll();
    }
    public void showMeditationById(Model model, Long id){
        Map<String,Roles> roles= Map.of("ADMIN",Roles.ADMIN,"USER",Roles.USER);
        model.addAttribute("meditation_item",meditationRepository.getReferenceById(id));
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user =  userRepository.findUserByEmail(currentPrincipalName);
        model.addAttribute("roles",roles);
        model.addAttribute("USER",user);
    }
    public void addNewMeditation(String imageURL
            , String videoURL, String description, String rating) throws IOException {


        Meditation meditation = new Meditation(imageURL,videoURL,description,rating);
        meditationRepository.save(meditation);
    }
    public Object showMeditation(long ID){

        return meditationRepository.findById(ID);

    }

    public void addMeditationComment(){
        // Finish this shit
    }
}
