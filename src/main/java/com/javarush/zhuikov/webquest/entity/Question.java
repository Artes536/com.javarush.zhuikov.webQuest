package com.javarush.zhuikov.webquest.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Question {

    Integer id;
    String text;
    List<Answer> answers;

}
