package com.javarush.zhuikov.webquest.entity;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;
@FieldDefaults(level = AccessLevel.PRIVATE)
class AnswerTest {
    Answer answer = new Answer(10,"Текст",100);

    @Test
    void getId() {
        assertEquals(10,answer.getId());
    }

    @Test
    void getText() {
        assertEquals("Текст",answer.getText());
    }

    @Test
    void getNextQuestion() {
        assertEquals(100,answer.getNextQuestion());
    }
}