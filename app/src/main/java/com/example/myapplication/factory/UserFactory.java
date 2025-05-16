package com.example.myapplication.factory;

import com.example.myapplication.User;
import com.example.myapplication.ValidationUtils;

public class UserFactory {

    /**
     * Creates a validated User object.
     * Throws IllegalArgumentException if validation fails.
     */
    public static User createUser(int userId, String username, String password) {
        if (!ValidationUtils.isValidUsername(username)) {
            throw new IllegalArgumentException("Username must be 6-15 characters long and contain only letters, numbers, or underscores.");
        }

        if (!ValidationUtils.isValidPassword(password)) {
            throw new IllegalArgumentException("Password must be at least 8 characters long, include uppercase, lowercase, number, and special character.");
        }

        return new User(userId, username, password);
    }
}

