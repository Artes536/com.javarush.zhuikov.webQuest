package com.javarush.zhuikov.webquest.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Answer {

    Integer id;
    String text;
    Integer nextQuestionId;

}
