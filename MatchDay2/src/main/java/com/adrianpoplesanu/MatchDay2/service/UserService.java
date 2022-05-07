package com.adrianpoplesanu.MatchDay2.service;

import com.adrianpoplesanu.MatchDay2.model.User;
import com.adrianpoplesanu.MatchDay2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void processOauth2PostLogin(String sub, String name, String firstName,
                                       String lastName, String picture, String email,
                                       String emailVerified, String locale) {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setEmail(email);
            user.setSub(sub);
            user.setProfileImageUrl(picture);
            user.setEmailVerified(emailVerified);
            user.setLocale(locale);
            user.setActivated("PENDING");
            userRepository.save(user);
        }
    }

    public User createUser(String name, String email, String firstName, String lastName) {
        User user = userRepository.getUserByEmail(email);
        if (user == null) {
            user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
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

    public boolean isAdmin(String email) {
        User user = userRepository.getUserByEmail(email);
        return "ADMIN".equals(user.getRole());
    }

    public boolean isActive(String email) {
        User user = userRepository.getUserByEmail(email);
        return "ACTIVE".equals(user.getStatus());
    }

    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    public User activateUser(String email) {
        User user = userRepository.getUserByEmail(email);
        user.setActivated("ACTIVATED");
        userRepository.save(user);
        return user;
    }
}
