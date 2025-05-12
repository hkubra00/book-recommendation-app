package com.example.myapplication;

public class User {
    private int userId;
    private String userName;
    private String userPassword;

    public User(int userId, String username, String email) {
        this.userId = userId;
        this.userName = username;
        this.userPassword = userPassword;
    }
    //getters and setters
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId){
        this.userId = userId;
    }
    public String getUsername() {
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserPassword(){
        return userPassword;
    }
    public void setUserPassword(String userPassword){
        this.userPassword = userPassword;
    }

}
