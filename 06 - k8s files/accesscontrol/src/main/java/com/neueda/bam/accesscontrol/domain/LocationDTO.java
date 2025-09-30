package com.neueda.bam.accesscontrol.domain;

public class LocationDTO {

    private Integer id;
    private String building;
    private String description;


    public LocationDTO(Location location) {
        this.id = location.getId();
        this.building = location.getBuilding();
        this.description =location.getDescription();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
