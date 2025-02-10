package com.javarush.zhuikov.webquest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.javarush.zhuikov.webquest.entity.Question;

import java.io.IOException;
import java.io.InputStream;

import java.util.List;

public class YamlQuestionRepository {
    private List<Question> questionList;

    public YamlQuestionRepository(){
        loadQuestion();
    }

    public void loadQuestion() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("questions.yaml")) {
            if (input == null) {
                throw new RuntimeException("Файл questions.yaml не найден!");
            }
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            questionList = mapper.readValue(input,List.class);
        } catch (IOException e) {
            throw new RuntimeException("Ошибка при загрузке YAML", e);
        }
    }

    public Question getQuestionById(int id) {
        return questionList.stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Question> getQuestionList() {
        return questionList;
    }
}
