package example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class GuessNumberGameTest {
    private static GuessNumberGame guessNumberGame;

    @BeforeAll
    static void initTestEnv() {
        Generator mockedGenerator = Mockito.mock(Generator.class);
        when(mockedGenerator.generate()).thenReturn("1234");
        guessNumberGame = new GuessNumberGame(mockedGenerator, new GuessValidator());
    }

    @Test
    void should_return_4A0B_when_answer_is_1234_given_1234() {
        //given
        String guess = "1234";

        //when
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("4A0B", answer);
    }

    @Test
    void should_return_2A2B_when_answer_is_1234_given_1243() {
        //given
        String guess = "1243";

        //when
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("2A2B", answer);
    }

    @Test
    void should_return_0A4B_when_answer_is_1234_given_4321() {
        //given
        String guess = "4321";

        //when
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("0A4B", answer);
    }

    @Test
    void should_return_2A0B_when_answer_is_1234_given_5236() {
        //given
        String guess = "5236";

        //when
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("2A0B", answer);
    }

    @Test
    void should_return_0A2B_when_answer_is_1234_given_4561() {
        //given
        String guess = "4561";

        //when
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("0A2B", answer);
    }

    @Test
    void should_return_0A0B_when_answer_is_1234_given_4561() {
        //given
        String guess = "5678";

        //when
        String answer = guessNumberGame.guess(guess);

        //then
        assertEquals("0A0B", answer);
    }

    @Test
    void test_play() throws IOException {
        //given
        String inputMessage = "1236\n"
                + "2345\n"
                + "5678\n"
                + "6789\n"
                + "1235\n"
                + "1234";
        System.setIn(new ByteArrayInputStream(inputMessage.getBytes()));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //when
        guessNumberGame.play();

        //then
        assertTrue(outContent.toString().endsWith("You win!\r\n"));
    }
}
