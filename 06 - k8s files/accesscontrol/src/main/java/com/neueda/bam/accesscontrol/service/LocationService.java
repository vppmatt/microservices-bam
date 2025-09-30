package com.neueda.bam.accesscontrol.service;

import com.neueda.bam.accesscontrol.data.LocationRepository;
import com.neueda.bam.accesscontrol.domain.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    RestTemplate restTemplate;

    @Value("${app.rest.location.url}")
    String restLocationUrl;

    public Location getById(Integer id) {
        Optional<Location> location = locationRepository.findById(id);
        if (location.isPresent()) return location.get();
        Location remoteLocation = restTemplate.getForObject(restLocationUrl + id, Location.class);
        locationRepository.save(remoteLocation);
        return remoteLocation;
    }

    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    public void updateLocationsFromBuildingServer() {
        try {
            Location[] locations = restTemplate.getForObject(restLocationUrl , Location[].class);
            locationRepository.saveAll(Arrays.asList(locations));
        }
        catch (Exception e) {
            System.out.println("Unable to update locations - sever might be down");
            System.out.println(restLocationUrl);
            e.printStackTrace();
        }
    }
}
