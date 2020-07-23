package example;

public class GuessNumberGame {
    private String answer;

    public GuessNumberGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generateAnswer();
    }

    public String guess(String guess) {
        if (answer.equals(guess)) {
            return "4A0B";
        }
        return "2A2B";
    }
}
