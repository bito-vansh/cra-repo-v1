package com.demo.cra.dto;

/**
 * This class represents a Data Transfer Object (DTO) for user information.
 * It contains fields for username and email, along with their respective
 * getter and setter methods. This class is used to transfer user data
 * between different layers of the application.
 */
public class UserDtoV1 {

    private String username;

    private String email;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
