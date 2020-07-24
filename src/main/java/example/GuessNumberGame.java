package example;

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

    public Validator getValidator() {
        return validator;
    }
}
