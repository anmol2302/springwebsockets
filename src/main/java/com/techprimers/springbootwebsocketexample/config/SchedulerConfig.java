package com.techprimers.springbootwebsocketexample.config;

import com.techprimers.springbootwebsocketexample.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    public void sendAdhocMessages() {
        template.convertAndSend("/topic/user", new UserResponse("Fixed Delay Scheduler"));
    }
}
