package com.example.bruteforceauth.util;

import com.example.bruteforceauth.model.User;
import com.example.bruteforceauth.repository.UserRepository;
import com.example.bruteforceauth.service.PasswordCreator;
import com.example.bruteforceauth.service.PasswordHASH;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PasswordUpdater {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordCreator passwordCreator;

    @Autowired
    private PasswordHASH passwordHASH;

    private static final boolean SHOULD_UPDATE = false;//change when rotation

    @PostConstruct
    public void updatePasswordsIfNeeded() {
        if (!SHOULD_UPDATE) return;

        List<User> users = userRepository.findAll();
        for (User user : users) {
            String newPassword = passwordCreator.createPassword();
            String hashedPassword = passwordHASH.hash(newPassword);
            user.setPassword(hashedPassword);
            userRepository.save(user);
            //System.out.printf("User: %s | New password: %s (hashed: %s)\n", user.getUsername(), newPassword, hashedPassword);
        }
    }
}