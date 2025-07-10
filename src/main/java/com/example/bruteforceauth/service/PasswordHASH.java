package com.example.bruteforceauth.service;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Service;

@Service
public class PasswordHASH {
    public static String hash(String password) {

            Argon2 argon2 = Argon2Factory.create();
            return argon2.hash(2, 65536, 1, password.toCharArray());

    }

    public boolean verify(String hash, String password) {
        Argon2 argon2 = Argon2Factory.create();
        return argon2.verify(hash, password.toCharArray());
    }
}
