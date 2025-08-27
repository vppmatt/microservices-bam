package com.neueda.bam.accesscontrol.control;

import com.neueda.bam.accesscontrol.domain.Location;
import com.neueda.bam.accesscontrol.service.AccessGroupService;
import com.neueda.bam.accesscontrol.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/location")
public class LocationController {

    @Autowired
    AccessGroupService accessGroupService;

    @Autowired
    LocationService locationService;

    @PostMapping
    public Location addNewLocation(@RequestBody Location location) {
        return accessGroupService.saveNewLocation(location);
    }

    @GetMapping
    public List<Location> getALl() {
        return locationService.getAll();
    }

}
