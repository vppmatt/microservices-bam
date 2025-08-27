package com.neueda.bam.buildingmanager.control;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HealthController {

    @GetMapping("/healthz")
    public String health() {
        return "OK";
    }
}
