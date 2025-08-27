package com.neueda.bam.accesscontrol.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO {

    private Integer id;
    private String name;
    private String email;

    private List<AccessGroupDTOLevel1> accessGroups;

    private List<String> locations;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
        this.accessGroups = user.getAccessGroups().stream().map(AccessGroupDTOLevel1::new).collect(Collectors.toList());
        List<AccessGroup> accessGroups = user.getAccessGroups();
        Set<Location> locationsSet = new HashSet<>();
        accessGroups.forEach(accessGroup -> {
            locationsSet.addAll(accessGroup.getLocations());
        });
        this.locations = locationsSet.stream().map(location -> location.getBuilding() + " " + location.getDescription()).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccessGroupDTOLevel1> getAccessGroups() {
        return accessGroups;
    }

    public void setAccessGroups(List<AccessGroupDTOLevel1> accessGroups) {
        this.accessGroups = accessGroups;
    }

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }
}
