package com.example.myapplication;

public class Admin extends User {

    public Admin(int userId, String username, String password) {
        super(userId, username, password);
    }

    public void deleteUser(User user) {
        try {
            // Örnek: veritabanından kullanıcı silme işlemi
            System.out.println("Deleting user: " + user.getUsername());
            // userRepository.delete(user.getId()); // Örn: JDBC ile
        } catch (Exception e) {
            System.err.println("Kullanıcı silinirken hata oluştu: " + e.getMessage());
            // Gerekirse log dosyasına yaz, üst sınıfa fırlat vs.
            throw new RuntimeException("Kullanıcı silinemedi", e);
        }
    }

    public void deleteBook(Book book) {
        try {
            System.out.println("Deleting book: " + book.getTitle());
            // bookRepository.delete(book.getId());
        } catch (Exception e) {
            System.err.println("Kitap silinirken hata oluştu: " + e.getMessage());
            throw new RuntimeException("Kitap silinemedi", e);
        }
    }

    public void manageReports() {
        try {
            // Örnek işlem: raporlanan kullanıcıları görüntüle
            System.out.println("Managing reports...");
            // reportService.reviewReports();
        } catch (Exception e) {
            System.err.println("Raporlar yönetilirken hata oluştu: " + e.getMessage());
            throw new RuntimeException("Rapor yönetiminde hata", e);
        }
    }
}

