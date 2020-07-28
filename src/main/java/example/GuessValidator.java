package example;

import java.util.HashSet;
import java.util.Set;

public class GuessValidator implements Validator {

    public static final int RIGHT_INPUT_LENGTH = 4;

    @Override
    public boolean validate(String guess) {
        if (guess.length() != RIGHT_INPUT_LENGTH) {
            return false;
        }
        Set<Character> guessCharSet = new HashSet<>();
        boolean between0and10 = true;
        for (char character : guess.toCharArray()) {
            guessCharSet.add(character);
        }

        for (char character : guessCharSet) {
            if (character < '0' || character > '9') {
                between0and10 = false;
                break;
            }
        }
        return guessCharSet.size() == RIGHT_INPUT_LENGTH && between0and10;
    }
}
