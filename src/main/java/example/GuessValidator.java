package example;

import java.util.regex.Pattern;

public class GuessValidator implements Validator {

    public static final String ONLY_NUMBER_REGEX = ".*[^0-9]+.*";
    public static final String NO_REPEAT_NUMBER_REGEX = ".*(.).*\\1.*";
    public static final int GUESS_NUMBER_LENGTH = 4;

    @Override
    public boolean validate(String guess) {
        if (guess.length() != GUESS_NUMBER_LENGTH) {
            return false;
        }
        return !Pattern.matches(ONLY_NUMBER_REGEX, guess) && !Pattern.matches(NO_REPEAT_NUMBER_REGEX, guess);
    }
}
