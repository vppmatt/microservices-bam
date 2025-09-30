package com.neueda.bam.usermanager.data;

import com.neueda.bam.usermanager.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findAllByFirstNameIgnoreCaseOrLastNameIgnoreCaseOrEmailIgnoreCase(String search1, String search2, String search3);

    @Query("SELECT MAX(u.id) FROM User u")
    Integer getMaxId();
}
