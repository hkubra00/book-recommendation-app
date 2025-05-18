package com.example.myapplication;

public class ValidationUtils {

    public static boolean isValidUsername(String username) {
        if (username == null) {
            android.util.Log.e("ValidationUtils", "Username null");
            return false;
        }
        boolean result = username.matches("^[a-zA-Z0-9_]{3,15}$");
        if (!result) {
            android.util.Log.w("ValidationUtils", "Invalid username: " + username);
        }
        return result;
    }

    public static boolean isValidPassword(String password) {
        if (password == null) {
            android.util.Log.e("ValidationUtils", "Password null");
            return false;
        }
        boolean result = password.length() >= 4;
        if (!result) {
            android.util.Log.w("ValidationUtils", "Password too short");
        }
        return result;
    }
}

