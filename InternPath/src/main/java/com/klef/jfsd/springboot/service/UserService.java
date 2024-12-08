package com.klef.jfsd.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.dto.UserDTO;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User signupUser(User user) throws IllegalArgumentException {
        // Check if email is already registered
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("Email is already registered.");
        }

        // Check if username is already taken
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("Username is already taken.");
        }

        // Save user (you might want to encode the password here for security)
        return userRepository.save(user);
    }
    public Optional<User> authenticateUser(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;  // Return user information if authentication is successful
        }
        return Optional.empty();  // If username or password is incorrect, return empty
    }
   
   

}
