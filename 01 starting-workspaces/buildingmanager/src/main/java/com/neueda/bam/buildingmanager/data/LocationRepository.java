package com.neueda.bam.buildingmanager.data;

import com.neueda.bam.buildingmanager.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
