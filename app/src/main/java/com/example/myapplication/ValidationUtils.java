package com.example.myapplication;

public class ValidationUtils {

    public static boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9_]{6,15}$");
    }

    public static boolean isValidPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$");
    }
}
