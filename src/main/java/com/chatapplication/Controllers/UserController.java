package com.chatapplication.Controllers;

import com.chatapplication.Entities.User;
import com.chatapplication.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String handleUserRegistration(User user, Model model){
        try{
            this.userService.createUser(user);

        }
        catch(Exception e){
            model.addAttribute("message", "signup_failed");
            model.addAttribute("error", e.getMessage());
            model.addAttribute("user", user);

            return "register";

        }
        return "redirect:login?message=signup_success"; //when we want to send user to another endpoint
    }

    @GetMapping("/login")
    public String showLoginPage(
            Model model,
            @RequestParam(name="message", required = false) String message
    ){
        model.addAttribute("message", message);
        return "login"; //will find register in the Tempate folder. When we want to display the page
    }

    @PostMapping("/login")
    public String handleUserLogin(User user){
//        here is possible to handle processing password and username separately
        try{
            User loggedinuser = userService.verifiedUser(user);
            return "redirect:group-chat/" + loggedinuser.getId();
            //either collect user id in cookie OR provide this
            // info in the URL like here (NOR SECURE at all since
            // any user could write the id in the url and would login
            //cookie allows to save ID

        } catch (Exception e) {
            return "redirect:login?message=login_failed&error=" + e.getMessage();
        }
    }

}
