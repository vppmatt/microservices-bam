package com.neueda.bam.buildingmanager.data;

import com.neueda.bam.buildingmanager.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer> {
}
