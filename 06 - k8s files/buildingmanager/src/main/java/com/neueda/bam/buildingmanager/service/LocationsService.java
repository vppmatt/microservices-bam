package com.neueda.bam.buildingmanager.service;

import com.neueda.bam.buildingmanager.data.BuildingRepository;
import com.neueda.bam.buildingmanager.data.LocationRepository;
import com.neueda.bam.buildingmanager.domain.Building;
import com.neueda.bam.buildingmanager.domain.Location;
import com.neueda.bam.buildingmanager.dto.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LocationsService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    BuildingRepository buildingRepository;

    @Autowired
    MessageService messageService;

    public List<LocationDTO> getLocationsFromBuilding(Integer buildingId) {
        return buildingRepository.findById(buildingId).get().getLocations().stream().map(LocationDTO::new).collect(Collectors.toList());
    }

    public List<LocationDTO> findAll() {
        return locationRepository.findAll().stream().map(LocationDTO::new).collect(Collectors.toList());
    }

    public Location updateLocationDescription(Integer id, Map<String,String> description) {
        Location location = locationRepository.findById(id).get();
        location.setDescription(description.get("description"));
        locationRepository.save(location);
        messageService.sendLocationsUpdatedMessage();
        return location;
    }

    public Location saveNewLocation(LocationDTO location) {
        Building building = buildingRepository.findById(Integer.parseInt(location.getBuilding())).get();
        Location newLocation = new Location(null, building, location.getDescription());
        locationRepository.save(newLocation);

        building.getLocations().add(newLocation);
        buildingRepository.save(building);
        messageService.sendLocationsUpdatedMessage();
        return newLocation;
    }
}
