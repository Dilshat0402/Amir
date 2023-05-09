package com.amir.Diploma.controllers;

import com.amir.Diploma.models.Doctor;
import com.amir.Diploma.models.Message;
import com.amir.Diploma.models.Post;
import com.amir.Diploma.models.User;
import com.amir.Diploma.repositories.DoctorRepository;
import com.amir.Diploma.repositories.UserRepository;
import com.amir.Diploma.services.impl.DoctorService;
import com.amir.Diploma.services.impl.MessageService;
import com.amir.Diploma.services.impl.PostService;
import com.amir.Diploma.services.impl.UserServiceImpl;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    PostService postService;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    DoctorService doctorService;
    @Autowired
    MessageService messageService;
    @GetMapping("/")
    public String items(
            Model model
    ){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";
    }

    @GetMapping("/posts{postId}")
    public String postById(
            Model model,
            @PathVariable Long postId
    ){
        Post post = postService.getPostById(postId);
        model.addAttribute("post", post);
        return "post-detail";
    }

    @GetMapping("/doctors")
    public String doctors(
        Model model
    ){
        List<Doctor> doctors = doctorRepository.findAll();
        model.addAttribute("doctors",doctors);
        return "doctors";
    }

    @GetMapping("/doctors{doctorId}")
    public String doctorsById(
            Model model,
            @PathVariable Long doctorId
    ){
        Doctor doctor = doctorService.getDoctorById(doctorId);
        model.addAttribute("doctor",doctor);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        List<Doctor> doctors = doctorService.getAllDoctors();
        model.addAttribute("doctors",doctors);
        return "consultation";
    }

    @PostMapping("/doctors{doctorId}")
    public String saveMessage(
            @RequestParam String description,
            @RequestParam(name = "doctor_id") Long doctorId
    ) {
        User user1 = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            String email = authentication.getName();
            List<User> users = userServiceImpl.getAllUsers();
            for (User user : users) {
                if (user.getEmail().equals(email)) {
                    user1 = user;
                }
            }
            Doctor doctor = doctorService.getDoctorById(doctorId);
            Message message = new Message(null,description,user1,doctor);
            message = messageService.addMessage(message);
            /*return "redirect:/posts/" + post.getId();*/
            return "redirect:/applications";
        }
    }

    @GetMapping("/applications")
    public String applications(Model model) {
        User mainUser = new User();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        } else {
            String name = authentication.getName();
            List<User> users = userServiceImpl.getAllUsers();
            for (User user:users) {
                if (user.getEmail().equals(name)){
                    mainUser = user;
                }
            }
            Long id = mainUser.getId();
            List<Message> messages = messageService.getMessageByUserId(id);
            model.addAttribute("messages", messages);

            return "applications";
        }
    }


    @GetMapping("/calendar")
    public String calendar(){
        return "calendar";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @GetMapping("/itemDetail")
    public String detail(){return "post-detail";}

    @GetMapping("/reminders")
    public String reminders(){return "reminders";}

}
