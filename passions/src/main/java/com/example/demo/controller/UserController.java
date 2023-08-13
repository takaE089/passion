package com.example.demo.controller;

import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.form.LoginForm;
import com.example.demo.form.UserForm;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {


	private static final String LOGIN_ID = "userId";
	private static final String PASSWORD = "password";
	
	private final UserRepository userRepository;

    public  UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

	@GetMapping("/display")
	public String display(Model model) {
        
		List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "display";
    }
	
	@GetMapping("/detail")
    public String detail(Model model) {
        return "detail";
    }
    
	@GetMapping("/signup")
    public String signup(Model model) {
    	return "signup";
    } 
	
	@GetMapping("/login")
	
    public String handleLogin(Model model, LoginForm form) {
       
            return "login";
        }
	
	@PostMapping
	public String login(Model model,LoginForm form) {
		var isCorrectUserAuth = form.getUserId().equals(LOGIN_ID)
				&& form.getPassword().equals(PASSWORD);
		if(isCorrectUserAuth) {
			return "redirect:/top";
		}else {
			model.addAttribute("errorMessage","ログインIDとパスワードの組み合わせが間違っています");
			return "login";
	}
	}

	
	@GetMapping("/top")
    public String top(Model model) {
    	return "top";
    }
	
	@GetMapping("/input")
    public String input(Model model) {
    	return "input";
    }
	
	@GetMapping("/check")
    public String check(Model model) {
		List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
       
    	return "check";
    }
	@GetMapping("/finish")
    public String finish(Model model) {
    	return "finish";
    }
    
    @PostMapping("/register")
    public String register(User user) {
    	String controlNum = generateControlNum();
        user.setControlNum(controlNum);
        userRepository.save(user);
    	return "redirect:/login";
    }
    
    @PostMapping("/regist")
	public String regist(UserForm userForm, HttpSession session) {
    	
	    // 入力情報をセッションに保存
	    session.setAttribute("userForm", userForm);
	    return "redirect:/check";
	}
    private String generateControlNum() {
        Random rnd = new Random();
        int num = rnd.nextInt(90000000) + 10000000; // 10000000から99999999までの整数
        return String.valueOf(num);
    }
    
}
