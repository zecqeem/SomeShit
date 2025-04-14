package com.example.bruteforceauth.repository;

import com.example.bruteforceauth.model.LoginAttempt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long> {
    Optional<LoginAttempt> findByUsername(String username);
}