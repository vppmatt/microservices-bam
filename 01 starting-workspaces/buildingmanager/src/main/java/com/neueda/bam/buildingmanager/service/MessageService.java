package com.neueda.bam.buildingmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

//@Service
public class MessageService {
    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${app.messaging.location.topic}")
    private String topic;

    public void sendLocationsUpdatedMessage(){
        try{
            jmsTemplate.convertAndSend(topic, "locations-updated");
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
