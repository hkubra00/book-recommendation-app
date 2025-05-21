package com.example.myapplication;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DatabaseHelper {

    // ExecutorService to run background tasks
    private static final ExecutorService executor = Executors.newSingleThreadExecutor();

    // This method establishes a connection to the MySQL database
    public static Connection getConnection() {
        Connection conn = null;
        try {
            // Allowing network operations on the main thread for this simple example
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL format: jdbc:mysql://<ip>:<port>/<db_name>
            String url = "jdbc:mysql://10.204.47.188:3306/bookrecommendationapp";
            String username = "rmysd";
            String password = "kanseidorifto";

            // Establishing the connection to the database
            conn = DriverManager.getConnection(url, username, password);
            Log.d("DB_CONNECTION", "Connection successful!");

        } catch (Exception e) {
            Log.e("DB_CONNECTION_ERROR", "Connection failed", e);
        }
        return conn;
    }

    // Method to test the database connection asynchronously
    public static void testQueryAsync() {
        // Run the database query in the background
        executor.execute(() -> {
            Connection conn = getConnection();
            if (conn != null) {
                try {
                    // Use a simple statement to test the connection
                    Statement stmt = conn.createStatement();
                    // For example, let's run a simple query to check connectivity
                    String query = "SELECT 1";  // Simple query to test the connection
                    stmt.executeQuery(query);

                    Log.d("DB_QUERY", "Query executed successfully");

                    stmt.close();
                    conn.close();
                } catch (Exception e) {
                    Log.e("DB_QUERY_ERROR", "Error while executing query", e);
                }
            }
        });
    }
}

