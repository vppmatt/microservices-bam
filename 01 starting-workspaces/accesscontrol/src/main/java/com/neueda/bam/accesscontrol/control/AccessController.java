package com.neueda.bam.accesscontrol.control;

import com.neueda.bam.accesscontrol.data.LocationRepository;
import com.neueda.bam.accesscontrol.domain.AccessGroup;
import com.neueda.bam.accesscontrol.domain.Location;
import com.neueda.bam.accesscontrol.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/access")
@CrossOrigin
public class AccessController {

    @Autowired
    LocationRepository locationRepository;

    //EG: http://localhost:8083/api/1
    @GetMapping("/{locationId}")
    public Set<User> getAllUsersForLocation(@PathVariable("locationId") Integer locationId) {
        Location location = locationRepository.findById(locationId).get();
        Set<User> users = new HashSet<>();
        for (AccessGroup accessGroup : location.getAccessGroups()) {
            users.addAll(accessGroup.getUsers());
        }
        return users;
    }
}
