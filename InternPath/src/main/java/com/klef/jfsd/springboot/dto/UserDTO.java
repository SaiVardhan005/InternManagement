package com.klef.jfsd.springboot.dto;

public class UserDTO {
    private String username;
    private String fullName;
    private String email;

    public UserDTO(String username, String fullName, String email) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
    }
    // Getters and setters
}
