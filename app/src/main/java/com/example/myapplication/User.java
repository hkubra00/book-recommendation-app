package com.example.myapplication;

import org.mindrot.jbcrypt.BCrypt;

public class User {
    private int userId;
    private String userName;
    private String userPassword;  // This will store the hashed password

    // Constructor
    public User(int userId, String username, String userPassword) {
        setUserId(userId);  // setter üzerinden kontrolle çağırıyoruz
        setUserName(username);
        setUserPassword(userPassword);  // Hashing happens in the setter
    }

    // Getters and Setters with exception handling

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId){
        if (userId <= 0) {
            throw new IllegalArgumentException("Kullanıcı ID pozitif olmalıdır.");
        }
        this.userId = userId;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName){
        if (userName == null || userName.trim().isEmpty()) {
            throw new IllegalArgumentException("Kullanıcı adı boş olamaz.");
        }
        this.userName = userName;
    }

    public String getUserPassword(){
        return userPassword;
    }

    // Hash password before saving
    public void setUserPassword(String userPassword){
        if (userPassword == null || userPassword.length() < 4) {
            throw new IllegalArgumentException("Şifre en az 4 karakter olmalıdır.");
        }

        // Hash the password using bcrypt with exception handling
        try {
            this.userPassword = hashPassword(userPassword);
        } catch (Exception e) {
            System.err.println("Password hashing failed: " + e.getMessage());
            // You can either rethrow the exception or handle it as per your application's needs
            throw new RuntimeException("Error occurred while hashing password.", e);
        }
    }

    // Hash the password using bcrypt
    private String hashPassword(String password) throws Exception {
        try {
            return BCrypt.hashpw(password, BCrypt.gensalt());  // bcrypt hash with salt
        } catch (Exception e) {
            throw new Exception("An error occurred while hashing the password: " + e.getMessage(), e);
        }
    }

    // Method to check if entered password matches the stored hash
    public boolean checkPassword(String password) {
        return BCrypt.checkpw(password, this.userPassword);
    }
}


