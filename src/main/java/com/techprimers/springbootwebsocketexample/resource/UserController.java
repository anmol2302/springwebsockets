package com.techprimers.springbootwebsocketexample.resource;

import com.techprimers.springbootwebsocketexample.model.User;
import com.techprimers.springbootwebsocketexample.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @Autowired
    private SimpMessagingTemplate template;


    @MessageMapping("/user")
    @SendTo("/topic/user")
    public UserResponse getUser(User user) {
        return new UserResponse("Hi " + user.getName());
    }

    @GetMapping("/notify")
    public void getNotification() {
        System.out.println("in notify");
        template.convertAndSend("/topic/user", new UserResponse("hello you have new notification"));
      //  return "Notifications successfully sent to Angular !";

    }
}
