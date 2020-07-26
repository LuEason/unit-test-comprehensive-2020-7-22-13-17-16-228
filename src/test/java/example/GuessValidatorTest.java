package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class GuessValidatorTest {
    private static Validator validator;

    @BeforeAll
    static void initTestEnv() {
        validator = new GuessValidator();
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
}
