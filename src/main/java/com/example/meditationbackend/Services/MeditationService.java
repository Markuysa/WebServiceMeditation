package com.example.meditationbackend.Services;

import com.example.meditationbackend.Models.MeditationModel.Meditation;
import com.example.meditationbackend.Models.authModels.Roles;
import com.example.meditationbackend.Models.authModels.User;
import com.example.meditationbackend.Repos.MeditationRepository;
import com.example.meditationbackend.Repos.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.abs;
@Service
public class MeditationService {
    private final MeditationRepository meditationRepository;
    private final UserRepository userRepository;
    @Value("${upload.path}")
    private String path;

    public MeditationService(MeditationRepository meditationRepository, UserRepository userRepository) {
        this.meditationRepository = meditationRepository;
        this.userRepository = userRepository;
    }
    public void showAllMeditations(Model model){
        model.addAttribute("meditations_list",meditationRepository.findAll());
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
    public boolean addNewMeditation(MultipartFile image
            , String videoURL, String description) throws IOException {
        if (!image.isEmpty()) {
            Random random = new Random();
            String id = abs(random.nextInt()) + "";
            Meditation meditation = new Meditation(image.getOriginalFilename(), videoURL, description);
            File dir = new File(path);
            if (!dir.exists()){
                dir.mkdir();
            }
            String nameOfFile =id + image.getOriginalFilename();
            image.transferTo(new File(path+'/'+nameOfFile));
            meditation.setImagePATH(nameOfFile);
            meditationRepository.save(meditation);

        } else {

            return true;
        }
        return false;
    }
    public void addMeditationComment(){
        // Finish this shit
    }
}
