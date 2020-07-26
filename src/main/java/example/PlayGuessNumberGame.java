package example;

import java.io.IOException;

public class PlayGuessNumberGame {

    public static void main(String[] args) throws IOException {
        new GuessNumberGame(new AnswerGenerator(), new GuessValidator()).play();
    }
}
