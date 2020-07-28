package example;

import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator implements Generator {

    //todo local
    private static final int ANSWER_LENGTH = 4;
    private static final int MAXIMUM_ANSWER = 10;

    @Override
    public String generate() {
        Set<String> answerCharSet = new HashSet<>();
        StringBuilder answer = new StringBuilder();
        while(answerCharSet.size() < ANSWER_LENGTH) {
            answerCharSet.add(Integer.toString((int) Math.floor(Math.random() * MAXIMUM_ANSWER)));
        }
        for (String string : answerCharSet) {
            answer.append(string);
        }
        return answer.toString();
    }
}
