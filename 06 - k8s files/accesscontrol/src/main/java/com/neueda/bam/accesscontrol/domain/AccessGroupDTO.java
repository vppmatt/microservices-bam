package com.neueda.bam.accesscontrol.domain;


import java.util.List;
import java.util.stream.Collectors;

public class AccessGroupDTO {

    private    Integer id;
    private String name;
    private List<UserDTO> users;
    private List<LocationDTO> locations;

    public AccessGroupDTO(AccessGroup accessGroup) {
        this.id = accessGroup.getId();
        this.name = accessGroup.getName();

        this.users = accessGroup.getUsers().stream().map(UserDTO::new).collect(Collectors.toList());
        this.locations = accessGroup.getLocations().stream().map(LocationDTO::new).collect(Collectors.toList());

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

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public List<LocationDTO> getLocations() {
        return locations;
    }

    public void setLocations(List<LocationDTO> locations) {
        this.locations = locations;
    }
}
