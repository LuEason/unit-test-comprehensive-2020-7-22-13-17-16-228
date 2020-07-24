package example;

import java.util.HashSet;
import java.util.Set;

public class GuessValidator implements Validator {
    @Override
    public boolean validate(String guess) {
        if (guess.length() != 4) {
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
        return guessCharSet.size() == 4 && between0and10;
    }
}
