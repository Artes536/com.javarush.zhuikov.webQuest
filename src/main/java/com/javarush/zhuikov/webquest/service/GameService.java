package com.javarush.zhuikov.webquest.service;

import com.javarush.zhuikov.webquest.repository.YamlQuestionRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
public class GameService {
    YamlQuestionRepository repository;
}
