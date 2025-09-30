package com.neueda.bam.accesscontrol.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import java.util.ArrayList;
import java.util.Map;

@Service
public class LocationsChangedMessagingService implements MessageListener {

    @Autowired
    LocationService locationService;
    @Override
    @JmsListener(destination = "${app.messaging.location.topic}")
    public void onMessage(Message message) {
        System.out.println("got a notice to update the list of locations from ActiveMQ ");
        locationService.updateLocationsFromBuildingServer();
    }
}

