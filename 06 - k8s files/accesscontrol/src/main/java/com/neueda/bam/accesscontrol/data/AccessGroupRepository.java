package com.neueda.bam.accesscontrol.data;

import com.neueda.bam.accesscontrol.domain.AccessGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessGroupRepository extends JpaRepository<AccessGroup, Integer> {
}
