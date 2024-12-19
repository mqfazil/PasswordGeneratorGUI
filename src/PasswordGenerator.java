//backend of the code

import java.util.Random;

public class PasswordGenerator {
    //character pools
    //strings will be randomly picked to generate a password
    public static final String LOWERCASE_CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String UPPERCASE_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS = "0123456789";
    public static final String SYMBOLS = "!@#$%^&*()-_=+[]{};:,.<>/?";

    //will help generate random number
    private final Random random;

    //constructor
    public PasswordGenerator() {
        random = new Random();
    }
    public String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                   boolean includeNumbers, boolean includeSymbols) {
        StringBuilder passwordBuilder = new StringBuilder();

        //stores characters
        String validCharacters = "";
        if (includeUppercase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeLowercase) validCharacters += LOWERCASE_CHARACTERS;
        if (includeNumbers) validCharacters += NUMBERS;
        if (includeSymbols) validCharacters += SYMBOLS;

        //builds passwords
        for (int i = 0; i < length; i++) {
            //generate random index
            int randomIndex = random.nextInt(validCharacters.length());

            //gets char based on random index
            char randomChar = validCharacters.charAt(randomIndex);

            //store char into password builder
            passwordBuilder.append(randomChar);
        }
        return passwordBuilder.toString();
    }
}
