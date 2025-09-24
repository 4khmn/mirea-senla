package Task3;

import java.security.SecureRandom;

public class Password {
    private static final String LETTERS_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String LETTERS_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*_+-=№?[]{}|<>/";
    private final int length;
    private static final String PASSWORD = LETTERS_LOWER + LETTERS_UPPER + DIGITS + SYMBOLS;


    public Password(int length) {
        this.length = length;
    }

    public String generatePassword() {
        StringBuilder generatedPassword = new StringBuilder();
        SecureRandom random = new SecureRandom();
        while(!isValidPassword(generatedPassword)) {
            generatedPassword.setLength(0);
            for (int i = 0; i < length; i++) {
                generatedPassword.append(PASSWORD.charAt(random.nextInt(PASSWORD.length())));
            }
        }
        return generatedPassword.toString();
    }

    private boolean isValidPassword(StringBuilder password) {
        boolean hasDigit = password.toString().matches(".*\\d.*");
        boolean hasLetter = password.toString().matches(".*[A-Za-z].*");
        boolean hasSymbol = password.toString().matches(".*[!@#$%^&*_+\\-=№?\\[\\]{}|<>].*");

        return hasDigit && hasLetter && hasSymbol;
    }
}
