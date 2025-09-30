package com.neueda.bam.buildingmanager.control;

import com.neueda.bam.buildingmanager.domain.Building;
import com.neueda.bam.buildingmanager.domain.Location;
import com.neueda.bam.buildingmanager.service.BuildingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/building")
public class BuildingController {

    @Autowired
    BuildingsService buildingsService;

    @GetMapping
    public List<Building> findAll() {
        return buildingsService.findAll();
    }

    @GetMapping("/{id}/location")
    public List<Location> getLocationsForBuilding(@PathVariable("id") Integer id) {
        return buildingsService.getLocationsForBuilding(id);
    }

    @PutMapping("{id}")
    public Building updateBuildingName(@PathVariable("id") Integer id, @RequestBody Map<String,String> name) {
        return buildingsService.updateBuildingName(id,name);
    }


}
