package example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayGuessNumberGame {

    public static void main(String[] args) throws IOException {
        GuessNumberGame guessNumberGame = new GuessNumberGame(new AnswerGenerator(), new GuessValidator());
        String result = "";
        int time = 6;

        while (time > 0 && !"4A0B".equals(result)) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Please enter your answer:");
            String guess = br.readLine();
            if (guessNumberGame.getValidator().validate(guess)) {
                result = guessNumberGame.guess(guess);
                System.out.println(result);
            } else {
                System.out.println("Wrong Input，Input again");
            }
            time --;
        }
        if ("4A0B".equals(result)) {
            System.out.println("You win!");
        } else {
            System.out.println("You lose!");
        }
    }
}
