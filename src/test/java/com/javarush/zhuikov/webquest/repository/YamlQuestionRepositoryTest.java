package com.javarush.zhuikov.webquest.repository;

import com.javarush.zhuikov.webquest.entity.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YamlQuestionRepositoryTest {

    @Test
    void loadQuestion() {
        YamlQuestionRepository repository = new YamlQuestionRepository("test_question.yaml");

        Question question = repository.getQuestionById(1);
        assertNotNull(question);
        assertEquals("Тест 1", question.getText());
        assertEquals("Ответ 1",question.getAnswers().getFirst().getText());
    }


}