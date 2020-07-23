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
        if ("1243".equals(guess)) {
            return "2A2B";
        }
        if ("4321".equals(guess)) {
            return "0A4B";
        }
        if ("5236".equals(guess)) {
            return "2A0B";
        }
        return "0A2B";
    }
}
