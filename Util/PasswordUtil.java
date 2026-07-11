package util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;

public final class PasswordUtil {

    private static final int SALT_LENGTH = 16;
    private static final String HASH_ALGORITHM = "SHA-256";

    private PasswordUtil() {
        // Utility class
    }

    // Membuat hash password baru (digunakan saat registrasi)
    public static String hashPassword(String plainPassword) {
        try {
            byte[] salt = new byte[SALT_LENGTH];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(salt);

            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
            messageDigest.update(salt);

            byte[] hashedBytes = messageDigest.digest(
                    plainPassword.getBytes(StandardCharsets.UTF_8));

            return bytesToHex(salt) + ":" + bytesToHex(hashedBytes);

        } catch (Exception e) {
            throw new RuntimeException("Gagal melakukan hash password.", e);
        }
    }

    // Memverifikasi password saat login
    public static boolean verifyPassword(String plainPassword, String storedHash) {
        try {

            String[] parts = storedHash.split(":");
            if (parts.length != 2) {
                return false;
            }

            byte[] salt = hexToBytes(parts[0]);
            String originalHash = parts[1];

            MessageDigest messageDigest = MessageDigest.getInstance(HASH_ALGORITHM);
            messageDigest.update(salt);

            byte[] hashedBytes = messageDigest.digest(
                    plainPassword.getBytes(StandardCharsets.UTF_8));

            return bytesToHex(hashedBytes).equals(originalHash);

        } catch (Exception e) {
            return false;
        }
    }

    private static String bytesToHex(byte[] bytes) {

        StringBuilder builder = new StringBuilder();

        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }

        return builder.toString();
    }

    private static byte[] hexToBytes(String hex) {

        int length = hex.length();
        byte[] bytes = new byte[length / 2];

        for (int i = 0; i < length; i += 2) {
            bytes[i / 2] = (byte) (
                    (Character.digit(hex.charAt(i), 16) << 4)
                    + Character.digit(hex.charAt(i + 1), 16)
            );
        }

        return bytes;
    }
}