package com.neueda.bam.usermanager.service;

import com.neueda.bam.usermanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

//@Service
public class MessagingService {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${app.messaging.user.topic}")
    private String topic;

    public void sendNewUserMessage(User user){
        Map<String,Object> message = new HashMap<>();
        message.put("id",user.getId());
        message.put("name", user.getTitle() + " " + user.getFirstName() + " " + user.getLastName());
        message.put("email", user.getEmail());
        try{
            jmsTemplate.convertAndSend(topic, message);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
