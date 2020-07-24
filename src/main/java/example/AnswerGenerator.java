package example;

import java.util.HashSet;
import java.util.Set;

public class AnswerGenerator implements Generator {
    @Override
    public String generate() {
        Set<String> answerCharSet = new HashSet<>();
        StringBuilder answer = new StringBuilder();
        while(answerCharSet.size() < 4) {
            answerCharSet.add(Integer.toString((int) Math.floor(Math.random() * 10)));
        }
        for (String string : answerCharSet) {
            answer.append(string);
        }
        return answer.toString();
    }
}
