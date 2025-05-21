package com.example.myapplication;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {

    // Hash password with jbcrypt
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    // Check password with jbcrypt
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

    public static void main(String[] args) {
        String password = "mySecurePassword";
        String hashedPassword = hashPassword(password);

        System.out.println("Hashed Password: " + hashedPassword);

        boolean isPasswordCorrect = checkPassword(password, hashedPassword);
        System.out.println("Is Password Correct: " + isPasswordCorrect);
    }
}
