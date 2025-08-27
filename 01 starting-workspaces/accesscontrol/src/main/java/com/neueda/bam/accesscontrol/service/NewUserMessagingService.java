package com.neueda.bam.accesscontrol.service;

import com.neueda.bam.accesscontrol.data.UserRepository;
import com.neueda.bam.accesscontrol.domain.User;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Map;

//@Service
public class NewUserMessagingService implements MessageListener {

    @Autowired
    UserRepository userRepository;

    @Override
    @JmsListener(destination = "${app.messaging.user.topic}")
    public void onMessage(Message message) {
        ActiveMQMapMessage newUserMessageMap = (ActiveMQMapMessage)message;
        try {
            Map<String,Object> newUserMessage = newUserMessageMap.getContentMap();
            User newUser = new User();
            newUser.setId(Integer.parseInt(newUserMessage.get("id").toString()));
            newUser.setName( newUserMessage.get("name").toString());
            newUser.setEmail(newUserMessage.get("email").toString());
            newUser.setAccessGroups(new ArrayList<>());
            userRepository.save(newUser);
            System.out.println("got a new  user from ActiveMQ "+ newUser.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
