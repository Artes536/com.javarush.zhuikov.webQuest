package com.javarush.zhuikov.webquest.service;

import com.javarush.zhuikov.webquest.repository.YamlQuestionRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
@FieldDefaults(level = AccessLevel.PRIVATE)
class GameServiceTest {

    YamlQuestionRepository mockRepository;
    GameService gameService;

    @BeforeEach
    void init(){
        mockRepository = Mockito.mock(YamlQuestionRepository.class);
        gameService = new GameService(mockRepository);
    }
    @Test
    void testGameServiceInitialization() {
        assertNotNull(gameService);
        assertSame(mockRepository, gameService.getRepository());
    }

}