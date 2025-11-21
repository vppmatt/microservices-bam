package com.neueda.bam.buildingmanager.service;

import com.neueda.bam.buildingmanager.data.BuildingRepository;
import com.neueda.bam.buildingmanager.domain.Building;
import com.neueda.bam.buildingmanager.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BuildingsService {

    @Autowired
    BuildingRepository buildingRepository;

//    @Autowired
//    MessageService messageService;

    public List<Building> findAll() {
        List<Building> buildings = buildingRepository.findAll();
        List<Building> ucBuildings = buildings.stream().map(b -> {
            b.setName(b.getName().toUpperCase());
            return b;

        }).collect(Collectors.toList());
        return ucBuildings;
    }

    public List<Location> getLocationsForBuilding(Integer id) {
        return buildingRepository.findById(id).get().getLocations();
    }


    public Building updateBuildingName(Integer id, Map<String,String> name) {
        Building building = buildingRepository.findById(id).get();
        building.setName(name.get("name"));
        buildingRepository.save(building);
//        messageService.sendLocationsUpdatedMessage();
        return building;
    }
}
