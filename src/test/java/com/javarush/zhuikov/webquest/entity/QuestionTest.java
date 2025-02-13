package com.javarush.zhuikov.webquest.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@FieldDefaults(level = AccessLevel.PRIVATE)
class QuestionTest {
    Question question = new Question(10,"Текст", List.of());

    @Test
    void getId() {
        assertEquals(10,question.getId());
    }

    @Test
    void getText() {
        assertEquals("Текст",question.getText());
    }

}