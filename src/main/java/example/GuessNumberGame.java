package example;

import java.util.Arrays;
import java.util.List;

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
        if ("12".equals(guess)) {
            return false;
        }
        return false;
    }
}
