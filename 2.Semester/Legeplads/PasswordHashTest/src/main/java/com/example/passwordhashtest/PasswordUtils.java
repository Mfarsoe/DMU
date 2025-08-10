package com.example.passwordhashtest;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordUtils {
    /*
     * Hasher en adgangskode ved hjælp af BCrypt-algoritmen.
     * Returnerer det hash'ede password som streng.
     */
    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    /*
     * Kontrollere om password passer med det hash'ede password.
     */
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
