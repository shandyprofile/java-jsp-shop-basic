/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.util.regex.Pattern;

/**
 *
 * @author shandy
 */
public class PasswordValidator {
    // Regex rule: At least 8 chars, one upper, one lower, one digit, one special char
    private static final String PASSWORD_PATTERN =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*!?])[A-Za-z\\d@#$%^&*!?]{8,}$";

    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

    /**
     * Validate password strength
     * @param password the password input
     * @return true if valid, false otherwise
     */
    public static boolean isValid(String password) {
        if (password == null || password.trim().isEmpty()) {
            return false;
        }
        return pattern.matcher(password).matches();
    }

    /**
     * Validate only basic length (if you want a simpler rule)
     */
    public static boolean isMinLength(String password, int length) {
        return password != null && password.length() >= length;
    }
}
