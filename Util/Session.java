package util;

import model.User;

// Menyimpan data user yang sedang login, supaya bisa diakses dari mana saja
// dalam aplikasi (MainFrame, TicketHistoryView, dll) tanpa perlu oper parameter berulang-ulang.
public class Session {
    private static User currentUser;

    // Dipanggil sekali saat login berhasil
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    // Dipanggil dari mana saja untuk tahu siapa yang sedang login
    public static User getCurrentUser() {
        return currentUser;
    }

    // Cek apakah yang login adalah Admin
    public static boolean isAdmin() {
        return currentUser != null && "ADMIN".equalsIgnoreCase(currentUser.getRole());
    }

    // Dipanggil saat Logout
    public static void clear() {
        currentUser = null;
    }
}