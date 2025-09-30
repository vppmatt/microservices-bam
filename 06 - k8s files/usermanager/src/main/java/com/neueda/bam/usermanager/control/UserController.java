package com.neueda.bam.usermanager.control;

import com.neueda.bam.usermanager.domain.User;
import com.neueda.bam.usermanager.domain.UserDTO;
import com.neueda.bam.usermanager.exceptions.UserNotFoundException;
import com.neueda.bam.usermanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public User getAUser(@PathVariable Integer id) throws UserNotFoundException {
        return userService.findUser(id);
    }

    @GetMapping("/highestId")
    public Map<String,Integer> getHighestId() {
        Map<String,Integer> results = new HashMap<>();
        results.put("id", userService.getHighestId());
        return results;
    }

    @GetMapping()
    public Object getAllUsers(@RequestParam(name="format",required=false)  String format, @RequestParam(name="search",required=false)  String search) {
        List<User> results = null;
        if (search != null) {
            results = userService.search(search);
        }
        else {
            results = userService.findAll();
        }


        if (format != null && format.equals("short")) {
            return results.stream().map(UserDTO::new).toList();
        }
        return results;
    }

    @PostMapping
    public User importUserFromHRSystem(@RequestBody Map<String,Object> data) {
        return userService.getUserFromHRSystem();
    }



}
