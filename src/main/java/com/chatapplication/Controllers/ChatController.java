package com.chatapplication.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ChatController {

    @GetMapping("group-chat/{userId}")
    public String displayChatRoom(
            @PathVariable Long userId,
            Model model
    ){

        model.addAttribute("userId", userId);
        return "group-chat";
    }
}
