package com.chatapplication.Controllers;

import com.chatapplication.Entities.User;
import com.chatapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegistrationPage(

    ){
        return "register"; //will find register in the Tempate folder. When we want to display the page
    }

    @PostMapping("/register")
    public String handleUserRegistration(User user){
        try{
            this.userService.createUser(user);

        }
        catch(Exception e){
            return "redirect:login?message=signup_failed&error" + e.getMessage();

        }
        return "redirect:login?message=signup_success"; //when we want to send user to another endpoint
    }

    @GetMapping("/login")
    public String showLoginPage(

    ){
        return "login"; //will find register in the Tempate folder. When we want to display the page
    }
}
