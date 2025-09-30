package com.neueda.bam.buildingmanager.service;

import com.neueda.bam.buildingmanager.data.BuildingRepository;
import com.neueda.bam.buildingmanager.domain.Building;
import com.neueda.bam.buildingmanager.domain.Location;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class BootstrapService {

    @Autowired
    BuildingRepository buildingRepository;

    @PostConstruct
    public void initData() {
        if (buildingRepository.count() == 0) {
            Building building1 = new Building(null,"Kirkwood House", new ArrayList<>());
            Building building2 = new Building(null,"Calvery Towers", new ArrayList<>());
            Building building3 = new Building(null,"West Seven", new ArrayList<>());

            building1.getLocations().add(new Location(null,building1,"Lobby"));
            building1.getLocations().add(new Location(null,building1,"1st Floor East"));
            building1.getLocations().add(new Location(null,building1,"1st Floor West"));
            building1.getLocations().add(new Location(null,building1,"2nd Floor East"));
            building1.getLocations().add(new Location(null,building1,"2nd Floor West"));
            building1.getLocations().add(new Location(null,building1,"Basement"));

            building2.getLocations().add(new Location(null,building2, "Lobby"));
            building2.getLocations().add(new Location(null,building2, "1st Floor"));
            building2.getLocations().add(new Location(null,building2, "2nd Floor"));
            building2.getLocations().add(new Location(null,building2, "3rd Floor"));
            building2.getLocations().add(new Location(null,building2, "4th Floor"));
            building2.getLocations().add(new Location(null,building2, "5th Floor"));

            building3.getLocations().add(new Location(null,building3, "Lobby"));
            building3.getLocations().add(new Location(null,building3, "Retail space"));
            building3.getLocations().add(new Location(null,building3, "Workshop"));
            building3.getLocations().add(new Location(null,building3, "Offices"));

            buildingRepository.save(building1);
            buildingRepository.save(building2);
            buildingRepository.save(building3);
        }
    }
}
