package controller;

import dao.UserDAO;
import java.util.List;
import model.User;
import util.Session;

public class UserController {

    private final UserDAO userDAO;

    public UserController() {
        this.userDAO = new UserDAO();
    }

    // Konversi String menjadi User.Role, mengikuti pola parseTripType/parsePassengerType
    // yang sudah ada di controller lain
    private User.Role parseRole(String role) {

        if (role == null) {
            return null;
        }

        try {
            return User.Role.valueOf(role.trim().toUpperCase());
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    // Tambah user baru oleh Admin - role bebas dipilih (ADMIN / PENUMPANG)
    public String createUserByAdmin(String username, String email, String password, String role) {

        StringBuilder errors = new StringBuilder();

        if (username == null || username.trim().isEmpty()) {
            errors.append("- Username wajib diisi.\n");
        }

        if (email == null || email.trim().isEmpty()) {
            errors.append("- Email wajib diisi.\n");
        } else if (!email.contains("@") || !email.contains(".")) {
            errors.append("- Format email tidak valid.\n");
        }

        if (password == null || password.trim().isEmpty()) {
            errors.append("- Password wajib diisi.\n");
        } else if (password.length() < 6) {
            errors.append("- Password minimal 6 karakter.\n");
        }

        User.Role parsedRole = parseRole(role);

        if (parsedRole == null) {
            errors.append("- Role harus Admin atau Penumpang.\n");
        }

        if (errors.length() > 0) {
            return errors.toString();
        }

        if (userDAO.isEmailExists(email.trim())) {
            return "Email sudah terdaftar, gunakan email lain.";
        }

        User user = new User(
                username.trim(),
                email.trim(),
                password,
                parsedRole
        );

        int result = userDAO.insertUser(user);

        if (result > 0) {
            return "OK";
        }

        return "Gagal menambah user.";
    }

    // Ambil semua user, untuk ditampilkan di tabel UserView
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // Update data user oleh Admin (tidak termasuk password)
    public String updateUser(int userID, String username, String email, String role) {

    StringBuilder errors = new StringBuilder();

    if (username == null || username.trim().isEmpty()) {
        errors.append("- Username wajib diisi.\n");
    }

    if (email == null || email.trim().isEmpty()) {
        errors.append("- Email wajib diisi.\n");
    } else if (!email.contains("@") || !email.contains(".")) {
        errors.append("- Format email tidak valid.\n");
    }

    User.Role parsedRole = parseRole(role);

    if (parsedRole == null) {
        errors.append("- Rolle harus Admin atau Penumpang.\n");
    }

    if (errors.length() > 0) {
        return errors.toString();
    }

    int result = userDAO.updateUser(userID, username.trim(), email.trim(), parsedRole.name());

    if (result > 0) {
        return "OK";
    }

    return "Gagal memperbarui data user.";
}
    
    // Hapus user - dengan pengaman supaya Admin tidak bisa hapus akunnya sendiri
    // (mencegah Admin ke-lock out dari sistemnya sendiri)
    public String deleteUser(int userID) {

        User current = Session.getCurrentUser();

        if (current != null && current.getUserID() == userID) {
            return "Tidak dapat menghapus akun yang sedang login.";
        }

        int result = userDAO.deleteUser(userID);

        if (result > 0) {
            return "OK";
        }

        return "Gagal menghapus user.";
    }
}