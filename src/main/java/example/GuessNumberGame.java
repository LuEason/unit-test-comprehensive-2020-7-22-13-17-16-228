package example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GuessNumberGame {
    private String answer;

    public GuessNumberGame(Generator generator) {
        this.answer = generator.generate();
    }

    public String guess(String guess) {
        String result;
        if (answer.equals(guess)) {
            result = "4A0B";
        } else {
            int aNumber = 0;
            int bNumber = 0;
            for (int i = 0; i < guess.length(); i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    aNumber ++;
                } else {
                    int indexInAnswerChars = answer.indexOf(guess.charAt(i));
                    if (indexInAnswerChars != -1 && i != indexInAnswerChars) {
                        bNumber ++;
                    }
                }
            }
            result = String.format("%sA%sB", aNumber, bNumber);
        }
        return result;
    }

    public boolean validGuess(String guess) {
        Set<Character> guessCharSet = new HashSet<>();
        boolean between0and10 = true;
        for (char character : guess.toCharArray()) {
            guessCharSet.add(character);
        }
        for (char character : guessCharSet) {
            if (character < '0' || character > '9') {
                between0and10 = false;
            }
        }
        return guessCharSet.size() == 4 && between0and10;
    }
}
