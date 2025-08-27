package com.neueda.bam.accesscontrol.domain;


import java.util.List;
import java.util.stream.Collectors;

public class AccessGroupDTOLevel1 {

    private Integer id;
    private String name;


    public AccessGroupDTOLevel1(AccessGroup accessGroup) {
        this.id = accessGroup.getId();
        this.name = accessGroup.getName();

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

}
