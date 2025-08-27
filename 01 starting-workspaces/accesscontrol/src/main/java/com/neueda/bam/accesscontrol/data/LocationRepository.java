package com.neueda.bam.accesscontrol.data;

import com.neueda.bam.accesscontrol.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Integer> {
}
