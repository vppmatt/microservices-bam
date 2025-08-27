package com.neueda.bam.buildingmanager.dto;
import com.neueda.bam.buildingmanager.domain.Location;
import java.util.Objects;

public class LocationDTO {

    private Integer id;
    private String building;
    private String description;

    public LocationDTO() {}
    public LocationDTO(Location location) {
        this.id = location.getId();
        this.building = location.getBuilding().getName();
        this.description = location.getDescription();
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
        LocationDTO that = (LocationDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(building, that.building) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, building, description);
    }
}
