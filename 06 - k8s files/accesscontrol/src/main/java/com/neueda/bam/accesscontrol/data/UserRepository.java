package com.neueda.bam.accesscontrol.data;

import com.neueda.bam.accesscontrol.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
