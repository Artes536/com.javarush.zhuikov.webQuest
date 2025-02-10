package com.javarush.zhuikov.webquest.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Question {

    Integer id;
    String text;
    List<Answer> answers;

}
