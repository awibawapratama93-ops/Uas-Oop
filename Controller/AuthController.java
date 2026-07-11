package controller;

import dao.UserDAO;
import model.User;

public class AuthController {

    private final UserDAO userDAO;

    public AuthController() {
        this.userDAO = new UserDAO();
    }

    public String register(String username, String email, String password) {

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

        if (errors.length() > 0) {
            return errors.toString();
        }

        User user = new User(
                username.trim(),
                email.trim(),
                password,
                "PENUMPANG"
        );

        int result = userDAO.register(user);

        if (result > 0) {
            return "OK";
        }

        return "Registrasi gagal. Email mungkin sudah terdaftar.";
    }

    public User login(String email, String password) {

        if (email == null || email.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }

        return userDAO.login(email.trim(), password);
    }

}