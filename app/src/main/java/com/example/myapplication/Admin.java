package com.example.myapplication;

public class Admin extends User{
    public Admin(int userId, String username, String password) {
        super(userId, username, password);
    }

    public void deleteUser(User user) {

    }

    public void deleteBook(Book book) {
        // Placeholder: logic to delete a book from the system
    }

    public void manageReports() {
        // Placeholder: logic to review reported reviews or users
    }
}
