package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.repository.AdminRepository;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public boolean authenticateAdmin(String username, String password) {
        // Use the repository method to find the admin by username and password
        return adminRepository.findByUsernameAndPassword(username, password).isPresent();
    }
}
