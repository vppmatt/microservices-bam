package com.neueda.bam.accesscontrol.control;

import com.neueda.bam.accesscontrol.domain.AccessGroup;
import com.neueda.bam.accesscontrol.domain.AccessGroupDTO;
import com.neueda.bam.accesscontrol.service.AccessGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accessgroup")
@CrossOrigin
public class AccessGroupController {

    @Autowired
    AccessGroupService accessGroupService;

    @PostMapping
    public AccessGroup newAccessGroup(@RequestBody  Map<String,String> name) {
        AccessGroup accessGroup = new AccessGroup();
        accessGroup.setName(name.get("name"));
        return accessGroupService.saveNewAccessGroup(accessGroup);
    }

    @PutMapping("/{accessGroupId}")
    public String updateAccessGroup(@PathVariable("accessGroupId") Integer accessGroupId, @RequestBody Map<String,String> name) {
        return accessGroupService.updateAccessGroup(accessGroupId, name);
    }

    @PostMapping("/{accessGroupId}/location/{locationId}")
    public String addLocationToAccessGroup(@PathVariable("locationId") Integer locationId, @PathVariable("accessGroupId") Integer accessGroupId,
                                                @RequestBody Map<String,String> ignore) {
        return accessGroupService.addLocationToAccessGroup(locationId, accessGroupId);
    }

    @DeleteMapping("/{accessGroupId}/location/{locationId}")
    public String removeLocationToAccessGroup(@PathVariable("locationId") Integer locationId, @PathVariable("accessGroupId") Integer accessGroupId) {
        return accessGroupService.removeLocationFromAccessGroup(locationId, accessGroupId);
    }

    @DeleteMapping("/{accessGroupId}/user/{userId}")
    public String removeUserFromAccessGroup(@PathVariable("userId") Integer userId, @PathVariable("accessGroupId") Integer accessGroupId) {
        return accessGroupService.removeUserFromAccessGroup(userId, accessGroupId);
    }

    @PostMapping("/{accessGroupId}/user/{userId}")
    public String addUserToAccessGroup(@PathVariable("userId") Integer userId, @PathVariable("accessGroupId") Integer accessGroupId, @RequestBody Map<String,String> ignore) {
        return accessGroupService.addUserToAccessGroup(userId, accessGroupId);
    }

    @GetMapping
    public List<AccessGroupDTO> getAll() {
        return accessGroupService.getAll();
    }

    @GetMapping("/{accessGroupId}")
    public AccessGroupDTO getById(@PathVariable("accessGroupId") Integer accessGroupId) {
        return new AccessGroupDTO(accessGroupService.getById(accessGroupId));
    }

}
