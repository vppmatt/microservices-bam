package com.neueda.bam.accesscontrol.service;

import com.neueda.bam.accesscontrol.data.AccessGroupRepository;
import com.neueda.bam.accesscontrol.data.LocationRepository;
import com.neueda.bam.accesscontrol.data.UserRepository;
import com.neueda.bam.accesscontrol.domain.AccessGroup;
import com.neueda.bam.accesscontrol.domain.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;

@Service
public class BootstrapService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    LocationService locationService;
    @Autowired
    UserRepository userRepository;

    @Autowired
    AccessGroupRepository accessGroupRepository;

    @Autowired
    private ApplicationContext appContext;

    @Value("${app.rest.user.update.url}")
    String restUserUpdateUrl;

    @Value("${app.rest.location.url}")
    String restLocationUrl;

    @PostConstruct
    public void updateLocations() {

        System.out.println("setup stage - udpate locations starting");
        locationService.updateLocationsFromBuildingServer();
        System.out.println("setup stage - udpate locations completed");
    }

    //@PostConstruct
    public void updateUsers() {
        System.out.println("setup stage - udpate users starting");
        try {
            User[] users = restTemplate.getForObject(restUserUpdateUrl, User[].class);
            System.out.println("setup stage - udpate users found " + users.length + " users");
            for (User user :users) {
                Optional<User> foundUser = userRepository.findById(user.getId());
                if (foundUser.isPresent()) {
                    User u = foundUser.get();
                    u.setName(user.getName());
                    u.setEmail(user.getEmail());
                    userRepository.save(u);
                    System.out.println("setup stage - udpate users saved " + user.getId());
                }
                else {
                    userRepository.save(user);
                    System.out.println("setup stage - udpate users saved " + user.getId());
                }
            }

        }
        catch (Exception e) {
                System.out.println("Unable to update users - sever might be down");
                System.out.println(e);
                SpringApplication.exit(appContext, () -> 0);
            }
        System.out.println("setup stage - udpate users completed");
    }

    @PostConstruct
    public void setupInitialData() {
        System.out.println("setup stage - create access group starting");
        if (accessGroupRepository.count() == 0) {
            AccessGroup accessGroup = new AccessGroup();
            accessGroup.setName("Finance");
            accessGroupRepository.save(accessGroup);
        }
        System.out.println("setup stage - create access group completed");
    }
}
