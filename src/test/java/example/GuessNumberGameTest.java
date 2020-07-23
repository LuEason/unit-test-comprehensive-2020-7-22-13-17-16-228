package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    @Test
    void should_return_4A0B_when_answer_is_1234_given_1234() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "1234";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("4A0B", answer);
    }

    @Test
    void should_return_2A2B_when_answer_is_1234_given_1243() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "1243";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("2A2B", answer);
    }

    @Test
    void should_return_0A4B_when_answer_is_1234_given_4321() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "4321";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("0A4B", answer);
    }

    @Test
    void should_return_2A0B_when_answer_is_1234_given_5236() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "5236";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("2A0B", answer);
    }

    @Test
    void should_return_0A2B_when_answer_is_1234_given_4561() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "4561";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("0A2B", answer);
    }

    @Test
    void should_return_0A0B_when_answer_is_1234_given_4561() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "5678";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("0A0B", answer);
    }

    @Test
    void should_return_true_when_valid_guess_given_12() {
        //given
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        String guess = "12";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedGenerator);
        boolean answer = guessNumberGame.validGuess(guess);

        //then
        assertFalse(answer);
    }
}
