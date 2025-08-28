package com.neueda.bam.usermanager.service;

import com.neueda.bam.usermanager.data.UserRepository;
import com.neueda.bam.usermanager.domain.HRUser;
import com.neueda.bam.usermanager.domain.HRUserList;
import com.neueda.bam.usermanager.domain.User;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class BootstrapService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DummyHrService dummyHrService;

    @Value("${app.rest.hr.url}")
    String hrUrl;


    @PostConstruct
    public void initData() {
        if (userRepository.count() == 0) {
            HRUserList list = dummyHrService.get100();
            List<User> users = list.getResults().stream().map(HRUser::toUser).toList();
            for (User user : users) {
                try {
                    userRepository.save(user);
                }
                catch (Exception e) {
                    System.out.println("Unable to save " + user);
                    System.out.println(e.getMessage());
                }
            }
        }

    }
}
