package com.example.bruteforceauth.service;

import com.example.bruteforceauth.dto.LoginRequest;
import com.example.bruteforceauth.dto.LoginResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bruteforceauth.model.User;
import com.example.bruteforceauth.repository.UserRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthService {


    @Autowired
    private UserRepository userRepository;

    public LoginResponse login(LoginRequest request) {
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(request.getPassword())) {
                return new LoginResponse(true, "Login successful");
            } else {
                return new LoginResponse(false, "Invalid password");
            }
        } else {
            return new LoginResponse(false, "User not found");
        }
    }

}
