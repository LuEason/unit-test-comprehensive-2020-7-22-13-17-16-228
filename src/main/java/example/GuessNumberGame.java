package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessNumberGame {
    private static final String WRONG_INPUT_INPUT_AGAIN = "Wrong Input，Input again";
    private static final int MAX_INPUT_TIME = 6;
    private static final String VICTORY_CONDITION = "4A0B";
    private static final String PLEASE_ENTER_YOUR_ANSWER = "Please enter your answer:";
    private static final String YOU_WIN = "You win!";
    private static final String YOU_LOSE = "You lose!";

    private final String answer;
    private final Validator validator;

    public GuessNumberGame(Generator generator, Validator validator) {
        this.answer = generator.generate();
        this.validator = validator;
    }

    public String guess(String guess) {
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
        return String.format("%sA%sB", aNumber, bNumber);
    }

    public void play() throws IOException {
        String result = "";
        int time = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (time < MAX_INPUT_TIME && !VICTORY_CONDITION.equals(result)) {
            String guess;
            System.out.print(PLEASE_ENTER_YOUR_ANSWER);
            guess = br.readLine();
            if (validator.validate(guess)) {
                result = guess(guess);
                System.out.println(result);
            } else {
                System.out.println(WRONG_INPUT_INPUT_AGAIN);
            }

            time ++;
        }
        if (VICTORY_CONDITION.equals(result)) {
            System.out.println(YOU_WIN);
        } else {
            System.out.println(answer);
            System.out.println(YOU_LOSE);
        }
    }
}
