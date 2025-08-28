package com.neueda.bam.buildingmanager.service;

import com.neueda.bam.buildingmanager.data.BuildingRepository;
import com.neueda.bam.buildingmanager.domain.Building;
import com.neueda.bam.buildingmanager.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class BuildingsService {

    @Autowired
    BuildingRepository buildingRepository;
    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public List<Location> getLocationsForBuilding(Integer id) {
        return buildingRepository.findById(id).get().getLocations();
    }


    public Building updateBuildingName(Integer id, Map<String,String> name) {
        Building building = buildingRepository.findById(id).get();
        building.setName(name.get("name"));
        buildingRepository.save(building);
        return building;
    }
}
