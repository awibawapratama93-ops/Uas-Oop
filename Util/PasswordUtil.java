package util;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class PasswordUtil {

    private static final int SALT_LENGTH = 16;

    // Bikin hash baru dari password polos (dipakai saat Register)
    public static String hashPassword(String plainPassword) {
        try {
            byte[] salt = new byte[SALT_LENGTH];
            new SecureRandom().nextBytes(salt);

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedBytes = md.digest(plainPassword.getBytes("UTF-8"));

            return bytesToHex(salt) + ":" + bytesToHex(hashedBytes);
        } catch (Exception e) {
            throw new RuntimeException("Gagal hash password", e);
        }
    }

    // Cek apakah password yang diketik cocok dengan hash yang tersimpan (dipakai saat Login)
    public static boolean verifyPassword(String plainPassword, String storedHash) {
        try {
            String[] parts = storedHash.split(":");
            if (parts.length != 2) {
                return false;
            }
            byte[] salt = hexToBytes(parts[0]);
            String originalHash = parts[1];

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] hashedBytes = md.digest(plainPassword.getBytes("UTF-8"));

            return bytesToHex(hashedBytes).equals(originalHash);
        } catch (Exception e) {
            return false;
        }
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    private static byte[] hexToBytes(String hex) {
        int len = hex.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16));
        }
        return data;
    }
}
