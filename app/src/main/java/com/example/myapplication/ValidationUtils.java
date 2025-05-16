package com.example.myapplication;

public class ValidationUtils {

    // Username validation: 3-15 chars, letters/numbers/underscores only (example)
    public static boolean isValidUsername(String username) {
        if (username == null) return false;
        return username.matches("^[a-zA-Z0-9_]{3,15}$");
    }

    // Password validation: minimum length 4, no other requirements
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 4;
    }
}
