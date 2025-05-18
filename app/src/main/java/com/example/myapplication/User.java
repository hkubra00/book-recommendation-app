package com.example.myapplication;

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    public User(int userId, String username, String userPassword) {
        setUserId(userId); // setter üzerinden kontrolle çağırıyoruz
        setUserName(username);
        setUserPassword(userPassword);
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

    public void setUserPassword(String userPassword){
        if (userPassword == null || userPassword.length() < 4) {
            throw new IllegalArgumentException("Şifre en az 4 karakter olmalıdır.");
        }
        this.userPassword = userPassword;
    }
}

