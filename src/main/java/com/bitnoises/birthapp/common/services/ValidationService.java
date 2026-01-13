package com.bitnoises.birthapp.common.services;

import org.springframework.stereotype.Component;

@Component
public class ValidationService {
    public void validatePassword(String password) {
        if (password.length() < 8)
            throw new RuntimeException("Password length should be at least 8 characters");
    }
}
