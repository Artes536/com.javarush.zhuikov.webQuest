package com.javarush.zhuikov.webquest.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
public class QuestionList {
    private List<Question> questions;
}