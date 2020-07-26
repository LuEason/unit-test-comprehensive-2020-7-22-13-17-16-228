package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GuessNumberGame {
    private final String answer;
    private final Validator validator;

    public GuessNumberGame(Generator generator, Validator validator) {
        this.answer = generator.generate();
        this.validator = validator;
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

    public void play() throws IOException {
        String result = "";
        int time = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (time < 6 && !"4A0B".equals(result)) {
            String guess;
            System.out.print("Please enter your answer:");
            guess = br.readLine();
            if (validator.validate(guess)) {
                result = guess(guess);
                System.out.println(result);
            } else {
                System.out.println("Wrong Input，Input again");
            }
            time ++;
        }
        if ("4A0B".equals(result)) {
            System.out.println("You win!");
        } else {
            System.out.println(answer);
            System.out.println("You lose!");
        }
    }
}
