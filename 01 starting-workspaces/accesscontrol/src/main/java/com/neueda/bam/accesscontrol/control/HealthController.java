package com.neueda.bam.accesscontrol.control;

import com.neueda.bam.accesscontrol.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/healthz")
    public String isRunning() {
        if (userRepository.count() > 0)
            return "OK";

        throw new RuntimeException("failed to start - no users found");
    }
}
