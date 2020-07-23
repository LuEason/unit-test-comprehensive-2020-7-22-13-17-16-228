package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;

public class GuessNumberGameTest {

    @Test
    void should_return_4A0B_when_answer_is_1234_given_1234() {
        //given
        AnswerGenerator mockedAnswerGenerator = Mockito.mock(AnswerGenerator.class);
        when(mockedAnswerGenerator.generateAnswer()).thenReturn("1234");
        String guess = "1234";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedAnswerGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("4A0B", answer);
    }

    @Test
    void should_return_2A2B_when_answer_is_1234_given_1243() {
        //given
        AnswerGenerator mockedAnswerGenerator = Mockito.mock(AnswerGenerator.class);
        when(mockedAnswerGenerator.generateAnswer()).thenReturn("1234");
        String guess = "1243";

        //when
        GuessNumberGame guessNumberGame = new GuessNumberGame(mockedAnswerGenerator);
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("2A2B", answer);
    }
}
