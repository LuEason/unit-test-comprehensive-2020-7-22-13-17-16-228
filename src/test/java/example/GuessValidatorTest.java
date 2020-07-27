package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GuessValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void initTestEnv() {
        validator = new GuessValidator();
    }

    private List<Boolean> testValidate(List<String> guesses) {
        List<Boolean> expectedValidate = new ArrayList<>();
        for (String guess : guesses) {
            expectedValidate.add(validator.validate(guess));
        }
        return expectedValidate;
    }

    @Test
    void should_return_false_when_valid_guess_given_12() {
        //given
        String guess = "12";

        //when
        boolean answer = validator.validate(guess);

        //then
        assertFalse(answer);
    }

    @Test
    void should_return_false_when_valid_guess_given_1122() {
        //given
        String guess = "1122";

        //when
        boolean answer = validator.validate(guess);

        //then
        assertFalse(answer);
    }

    @Test
    void should_return_false_when_valid_guess_given_a234() {
        //given
        String guess = "a234";

        //when
        boolean answer = validator.validate(guess);

        //then
        assertFalse(answer);
    }

    @Test
    void should_return_true_when_valid_guess_given_1234() {
        //given
        String guess = "1234";

        //when
        boolean answer = validator.validate(guess);

        //then
        assertTrue(answer);
    }

    @Test
    void should_return_false_when_valid_guess_given_12345() {
        //given
        String guess = "12345";

        //when
        boolean answer = validator.validate(guess);

        //then
        assertFalse(answer);
    }

    @Test
    void testAllStateOfValidate() {
        //given
        List<String> guesses = new ArrayList<>();
        guesses.add("12");
        guesses.add("1122");
        guesses.add("a234");
        guesses.add("1234");
        guesses.add("12344");
        List<Boolean> expectedValidates = new ArrayList<>();
        expectedValidates.add(Boolean.FALSE);
        expectedValidates.add(Boolean.FALSE);
        expectedValidates.add(Boolean.FALSE);
        expectedValidates.add(Boolean.TRUE);
        expectedValidates.add(Boolean.FALSE);

        //when
        List<Boolean> validates = testValidate(guesses);

        //then
        for (int i = 0; i < validates.size(); i++) {
            assertEquals(expectedValidates.get(i), validates.get(i));
        }
    }
}
