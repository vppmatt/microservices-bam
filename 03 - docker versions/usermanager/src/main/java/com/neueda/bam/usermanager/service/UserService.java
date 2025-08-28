package com.neueda.bam.usermanager.service;

import com.neueda.bam.usermanager.data.UserRepository;
import com.neueda.bam.usermanager.domain.HRUserList;
import com.neueda.bam.usermanager.domain.User;
import com.neueda.bam.usermanager.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    DummyHrService dummyHrService;

    @Autowired
    MessagingService messagingService;

    public User findUser(Integer id) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        else {
            throw new UserNotFoundException();
        }
    }



    public User getUserFromHRSystem() {
        User user =  dummyHrService.getNext();
        userRepository.save(user);
        messagingService.sendNewUserMessage(user);
        return user;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> search(String search) {
        return userRepository.findAllByFirstNameIgnoreCaseOrLastNameIgnoreCaseOrEmailIgnoreCase(search, search, search);
    }

    public Integer getHighestId() {
        return userRepository.getMaxId();
    }
}
