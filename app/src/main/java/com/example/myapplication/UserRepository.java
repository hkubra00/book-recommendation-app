package com.example.myapplication;

import java.sql.*;

public class UserRepository {
    private static final String URL = "jdbc:mysql://localhost:3306/bookrecommendationapp"; // Adjust based on your setup
    private static final String USER = "root"; // MySQL username
    private static final String PASSWORD = "password"; // MySQL password

    // Method to get a user by username
    public User getUserByUsername(String username) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        int userId = rs.getInt("user_id");
                        String userPassword = rs.getString("user_password"); // The hashed password from DB
                        return new User(userId, username, userPassword);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Return null if user not found
    }

    // Method to save a new user
    public void saveUser(User user) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO users (username, user_password) VALUES (?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, user.getUsername());
                stmt.setString(2, user.getUserPassword()); // Store the hashed password
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
