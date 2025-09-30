package com.neueda.bam.accesscontrol.control;

import com.neueda.bam.accesscontrol.domain.User;
import com.neueda.bam.accesscontrol.service.AccessGroupService;
import com.neueda.bam.accesscontrol.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.neueda.bam.accesscontrol.domain.UserDTO;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    AccessGroupService accessGroupService;

    @Autowired
    UserService userService;

    @PostMapping
    public User addNewUser(@RequestBody User user) {
        return accessGroupService.saveNewUser(user);
    }

    @GetMapping("/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        System.out.println("getting user " + id);
        UserDTO result = new UserDTO(userService.getById(id));
        System.out.println(result);
        return result;
    }
}
