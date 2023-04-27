package com.amir.Diploma.controllers;

import com.amir.Diploma.models.Post;
import com.amir.Diploma.models.User;
import com.amir.Diploma.repositories.UserRepository;
import com.amir.Diploma.services.impl.PostService;
import com.amir.Diploma.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    PostService postService;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;

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


}
