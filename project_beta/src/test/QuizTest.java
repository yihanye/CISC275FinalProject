package test;

import org.junit.*;
import model.*;
import static org.junit.Assert.assertEquals;

public class QuizTest {
    @Test
    public void quizTest() {
        Quiz quiz1 = new Quiz("I am a question", 1, "I am explanation");
        assertEquals("I am a question", quiz1.getQuestion());
        assertEquals("Incorrect!", quiz1.getResult());
        assertEquals("I am explanation", quiz1.getExplanation());
        assertEquals(false, quiz1.getCorrectornot());
        assertEquals(false, quiz1.checkAnswer(true, false));

        quiz1.setCorrectornot(true);
        assertEquals(true, quiz1.getCorrectornot());
    }
}

