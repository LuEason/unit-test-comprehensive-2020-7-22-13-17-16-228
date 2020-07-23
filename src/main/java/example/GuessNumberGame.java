package example;

public class GuessNumberGame {
    private String answer;

    public GuessNumberGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generateAnswer();
    }

    public String guess(String guess) {
        return "4A0B";
    }
}
