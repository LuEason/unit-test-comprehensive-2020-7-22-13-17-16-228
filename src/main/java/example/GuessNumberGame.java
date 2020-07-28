package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessNumberGame {
    private static final String WRONG_INPUT = "Wrong Input，Input again";
    private static final int MAX_INPUT_TIME = 6;
    private static final String VICTORY_CONDITION = "4A0B";
    private static final String ENTER_ANSWER = "Please enter your answer:";
    private static final String YOU_WIN = "You win!";
    private static final String YOU_LOSE = "You lose!";

    private final String answer;
    private final Validator validator;

    public GuessNumberGame(Generator generator, Validator validator) {
        this.answer = generator.generate();
        this.validator = validator;
    }

    public String guess(String guess) {
        int rightNumberAndPosition = 0;
        int rightNumberButWrongPosition = 0;
        for (int index = 0; index < guess.length(); index++) {
            if (guess.charAt(index) == answer.charAt(index)) {
                rightNumberAndPosition ++;
            } else {
                int indexInAnswerChars = answer.indexOf(guess.charAt(index));
                if (indexInAnswerChars != -1 && index != indexInAnswerChars) {
                    rightNumberButWrongPosition ++;
                }
            }
        }
        return String.format("%sA%sB", rightNumberAndPosition, rightNumberButWrongPosition);
    }

    public void play() throws IOException {
        String result = "";
        int time = 0;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (time < MAX_INPUT_TIME && !VICTORY_CONDITION.equals(result)) {
            System.out.print(ENTER_ANSWER);
            String guessNumber = bufferedReader.readLine();
            if (validator.validate(guessNumber)) {
                result = guess(guessNumber);
                System.out.println(result);
            } else {
                System.out.println(WRONG_INPUT);
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
