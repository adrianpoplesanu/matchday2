package com.adrianpoplesanu.MatchDay2.service;

import com.adrianpoplesanu.MatchDay2.model.User;
import com.adrianpoplesanu.MatchDay2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void processOauth2PostLogin(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            System.out.println(email + " needs to be added as user");
        }
    }

    public User createUser(String name, String email, String firstName, String lastName) {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastNamel(lastName);
            userRepository.save(user);
            return user;
        } else {
            return user;
        }
    }

    public boolean isUserActivated(String email) {
        User user = userRepository.getUserByEmail(email);
        return "ACTIVATED".equals(user.getActivated());
    }
}
