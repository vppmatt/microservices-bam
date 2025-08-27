package com.neueda.bam.accesscontrol.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;
import java.util.Objects;

@Entity
public class Location {

    @Id
    private Integer id;

    private String building;
    private String description;

    @ManyToMany
    private List<AccessGroup> accessGroups;

    public Location() {
    }

    public Location(Integer id, String building, String description) {
        this.id = id;
        this.building = building;
        this.description = description;
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

    @JsonIgnore
    public List<AccessGroup> getAccessGroups() {
        return accessGroups;
    }

    public void setAccessGroups(List<AccessGroup> accessGroups) {
        this.accessGroups = accessGroups;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", building=" + building +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(building, location.building) && Objects.equals(description, location.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, building, description);
    }
}


