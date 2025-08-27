package com.neueda.bam.accesscontrol.service;

import com.neueda.bam.accesscontrol.data.AccessGroupRepository;
import com.neueda.bam.accesscontrol.data.LocationRepository;
import com.neueda.bam.accesscontrol.data.UserRepository;
import com.neueda.bam.accesscontrol.domain.AccessGroup;
import com.neueda.bam.accesscontrol.domain.AccessGroupDTO;
import com.neueda.bam.accesscontrol.domain.Location;
import com.neueda.bam.accesscontrol.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AccessGroupService {

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AccessGroupRepository accessGroupRepository;

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    public Location saveNewLocation(Location location) {
        return locationRepository.save(location);
    }

    public User saveNewUser(User user) {
        return userRepository.save(user);
    }


    public AccessGroup saveNewAccessGroup(AccessGroup accessGroup) {
        return accessGroupRepository.save(accessGroup);
    }

    public String addLocationToAccessGroup(Integer locationId, Integer accessGroupId) {
        AccessGroup accessGroup = accessGroupRepository.findById(accessGroupId).get();
        Location location = locationService.getById(locationId);
        accessGroup.getLocations().add(location);
        location.getAccessGroups().add(accessGroup);
        accessGroupRepository.save(accessGroup);
        locationRepository.save(location);
        return "ok";
    }

    public String addUserToAccessGroup(Integer userId, Integer accessGroupId) {
        AccessGroup accessGroup = accessGroupRepository.findById(accessGroupId).get();
        User user = userService.getById(userId);
        accessGroup.getUsers().add(user);
        user.getAccessGroups().add(accessGroup);
        accessGroupRepository.save(accessGroup);
        userRepository.save(user);
        System.out.println("adding " + userId + " to " + accessGroupId);
        return "ok";
    }

    public List<AccessGroupDTO> getAll() {
        return accessGroupRepository.findAll().stream().map(AccessGroupDTO::new).collect(Collectors.toList());
    }

    public String updateAccessGroup(Integer accessGroupId, Map<String, String> updatedAccessGroup) {
        AccessGroup accessGroup = accessGroupRepository.findById(accessGroupId).get();
        accessGroup.setName(updatedAccessGroup.get("name"));
        accessGroupRepository.save(accessGroup);
        return "ok";
    }

    public AccessGroup getById(Integer accessGroupId) {
        return accessGroupRepository.findById(accessGroupId).get();
    }

    public String removeLocationFromAccessGroup(Integer locationId, Integer accessGroupId) {
        AccessGroup accessGroup = accessGroupRepository.findById(accessGroupId).get();
        Location location = locationRepository.findById(locationId).get();
        accessGroup.getLocations().remove(location);
        location.getAccessGroups().remove(accessGroup);
        accessGroupRepository.save(accessGroup);
        locationRepository.save(location);
        return "ok";
    }

    public String removeUserFromAccessGroup(Integer userId, Integer accessGroupId) {
        System.out.println("deleting " + userId + " from " + accessGroupId);
        AccessGroup accessGroup = accessGroupRepository.findById(accessGroupId).get();
        User user = userRepository.findById(userId).get();
        accessGroup.getUsers().remove(user);
        user.getAccessGroups().remove(accessGroup);
        accessGroupRepository.save(accessGroup);
        userRepository.save(user);
        return "ok";
    }
}
