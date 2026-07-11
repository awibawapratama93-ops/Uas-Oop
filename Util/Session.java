package util;

import model.User;

/**
 * Menyimpan informasi user yang sedang login.
 * Session dapat diakses dari seluruh aplikasi selama program berjalan.
 */
public final class Session {

    private static User currentUser;

    private Session() {
        // Utility class
    }

    // Menyimpan user setelah login berhasil
    public static void setCurrentUser(User user) {
        currentUser = user;
    }

    // Mengambil user yang sedang login
    public static User getCurrentUser() {
        return currentUser;
    }

    // Mengecek apakah user yang login adalah Admin
    public static boolean isAdmin() {
        return currentUser != null
                && "ADMIN".equalsIgnoreCase(currentUser.getRole());
    }

    // Mengecek apakah sudah ada user yang login
    public static boolean isLoggedIn() {
        return currentUser != null;
    }

    // Menghapus session saat logout
    public static void clear() {
        currentUser = null;
    }
}