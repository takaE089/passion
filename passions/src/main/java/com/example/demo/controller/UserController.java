package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repository.UserRepository;

@Controller
public class UserController {


	private final UserRepository userRepository;

    public  UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@GetMapping(value = "/display")
	public String display(Model model) {
        
        return "display";
    }
	
    @GetMapping(value = "/detail")
    public String detail(Model model) {
        return "detail";
    }
    
    
    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users";
    }
}