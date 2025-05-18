package com.example.myapplication;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

    // Method to hash a password
    public static String hashPassword(String plainPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(plainPassword);  // hashes the password
    }

    // Method to check if a password matches the hashed password
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(plainPassword, hashedPassword);  // compares the password with the hash
    }

    public static void main(String[] args) {
        // Example usage:
        String password = "mySecurePassword";
        String hashedPassword = hashPassword(password);

        System.out.println("Hashed Password: " + hashedPassword);

        // Example of checking the password
        boolean isPasswordCorrect = checkPassword(password, hashedPassword);
        System.out.println("Is Password Correct: " + isPasswordCorrect);
    }
}

