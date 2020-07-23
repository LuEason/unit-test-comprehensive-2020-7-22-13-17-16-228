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
            List guessChars = Arrays.asList(guess.split(""));
            List answerChars = Arrays.asList(answer.split(""));
            for (int i = 0; i < guessChars.size(); i++) {
                if (guessChars.get(i).equals(answerChars.get(i))) {
                    aNumber ++;
                } else {
                    int indexInAnswerChars = answerChars.indexOf(guessChars.get(i));
                    if (indexInAnswerChars != -1 && i != indexInAnswerChars) {
                        bNumber ++;
                    }
                }
            }
            result = String.format("%sA%sB", aNumber, bNumber);
        }
        return result;
    }
}
