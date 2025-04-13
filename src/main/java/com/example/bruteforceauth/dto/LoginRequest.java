package com.example.bruteforceauth.dto;

public class LoginRequest {
    private String username;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }


    private String password;

    // Getters and setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
