package com.neueda.bam.buildingmanager.control;

import com.neueda.bam.buildingmanager.data.BuildingRepository;
import com.neueda.bam.buildingmanager.domain.Location;
import com.neueda.bam.buildingmanager.dto.LocationDTO;
import com.neueda.bam.buildingmanager.service.LocationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/location")
@CrossOrigin
public class LocationController {

    @Autowired
    LocationsService locationService;

    @Autowired
    BuildingRepository buildingRepository;

    @GetMapping()
    public List<LocationDTO> getLocations(@RequestParam(required = false) Integer buildingId) {
        if (buildingId != null) {
            return locationService.getLocationsFromBuilding(buildingId);
        }
        return locationService.findAll();
    }

    @PutMapping("/{id}")
    public Location updateLocationDescription(@PathVariable("id") Integer id, @RequestBody Map<String,String> description) {
        return locationService.updateLocationDescription(id,description);
    }

    @PostMapping()
    public Location saveNewLocation(@RequestBody LocationDTO location) {
        return locationService.saveNewLocation(location);
    }
}
