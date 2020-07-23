package example;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AnswerGeneratorTest {
    @Test
    void should_return_4_length_String_when_generate() {
        //given
        Generator generator = new AnswerGenerator();

        //when
        String answer = generator.generate();

        //then
        Set<Character> answerCharSet = new HashSet<>();
        boolean between0and10 = true;
        for (char character : answer.toCharArray()) {
            answerCharSet.add(character);
        }
        for (char character : answerCharSet) {
            if (character < '0' || character > '9') {
                between0and10 = false;
            }
        }
        assertTrue(between0and10);
        assertEquals(4, answerCharSet.size());
    }
}
