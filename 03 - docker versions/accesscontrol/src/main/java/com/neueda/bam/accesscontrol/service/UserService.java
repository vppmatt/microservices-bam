package com.neueda.bam.accesscontrol.service;

import com.neueda.bam.accesscontrol.data.UserRepository;
import com.neueda.bam.accesscontrol.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${app.rest.user.url}")
    String restUserUrl;

    public User getById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) return user.get();
        User remoteUser = restTemplate.getForObject(restUserUrl + id, User.class);
        userRepository.save(remoteUser);
        return remoteUser;
    }

}
