package com.example.bruteforceauth.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "login_attempts")
public class LoginAttempt {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public int attempts;
    public String username;
    public boolean blocked;
    public LocalDateTime blockedAt;

    public LoginAttempt() {
        attempts = 0;
        blocked = false;
        blockedAt = LocalDateTime.now();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    public LocalDateTime getBlockedAt() {
        return blockedAt;
    }

    public void setBlockedAt(LocalDateTime blockedAt) {
        this.blockedAt = blockedAt;
    }



}
