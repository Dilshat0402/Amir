package com.amir.Diploma.controllers;

import com.amir.Diploma.models.Item;
import com.amir.Diploma.repositories.UserRepository;
import com.amir.Diploma.services.impl.UserServiceImpl;
import com.amir.Diploma.services.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    ItemService itemService;
    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String posts(){
        return "index";
    }

    @GetMapping("/index")
    public String items(
            Model model
    ){
        List<Item> items = itemService.getAllItems();
        model.addAttribute("item",items);
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }


}
