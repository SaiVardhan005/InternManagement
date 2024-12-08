package com.klef.jfsd.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.klef.jfsd.springboot.dto.UserDTO;
import com.klef.jfsd.springboot.dto.UserSignInDto;
import com.klef.jfsd.springboot.model.User;
import com.klef.jfsd.springboot.repository.UserRepository;
import com.klef.jfsd.springboot.service.UserService;


import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;


    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        userService.signupUser(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody UserSignInDto signInData) {
        Optional<User> user = userService.authenticateUser(signInData.getUsername(), signInData.getPassword());
        
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get()); // Return the user data as JSON if authenticated
        }
        
        return ResponseEntity.status(401).body("Invalid credentials"); // Unauthorized if invalid
    }

   

}
