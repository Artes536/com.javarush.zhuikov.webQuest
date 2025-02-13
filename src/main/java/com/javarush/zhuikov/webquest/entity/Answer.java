package com.javarush.zhuikov.webquest.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Answer {

    Integer id;
    String text;
    Integer nextQuestion;

}
