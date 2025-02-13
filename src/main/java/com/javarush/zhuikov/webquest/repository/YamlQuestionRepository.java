package com.javarush.zhuikov.webquest.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.javarush.zhuikov.webquest.entity.Question;
import com.javarush.zhuikov.webquest.entity.QuestionList;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class YamlQuestionRepository {
    private QuestionList questionList;

    public YamlQuestionRepository(String pathFile) {
        loadQuestion(pathFile);
    }

    public void loadQuestion(String pathFile) {
        InputStream input = getClass().getClassLoader().getResourceAsStream(pathFile);
            if (input == null) {
                throw new RuntimeException("Файл questions.yaml не найден!");
            }
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            try {
                questionList = mapper.readValue(input, QuestionList.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

    }

    public Question getQuestionById(int id) {
        return questionList.getQuestions().stream()
                .filter(q -> q.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Question> getQuestionList() {
        return questionList.getQuestions();
    }
}
