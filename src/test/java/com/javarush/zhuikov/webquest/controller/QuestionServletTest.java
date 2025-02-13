package com.javarush.zhuikov.webquest.controller;

import com.javarush.zhuikov.webquest.entity.Answer;
import com.javarush.zhuikov.webquest.entity.Question;
import com.javarush.zhuikov.webquest.repository.YamlQuestionRepository;
import com.javarush.zhuikov.webquest.service.GameService;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
class QuestionServletTest {

    QuestionServlet servlet;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;
    ServletContext servletContext;
    GameService gameService;
    YamlQuestionRepository yamlQuestionRepository;


    @BeforeEach
    void init(){
        servlet = new QuestionServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        servletContext = mock(ServletContext.class);
        gameService = mock(GameService.class);
        yamlQuestionRepository = mock(YamlQuestionRepository.class);

        when(request.getSession()).thenReturn(session);
        when(servletContext.getAttribute("gameService")).thenReturn(gameService);
        when(gameService.getRepository()).thenReturn(yamlQuestionRepository);

        ServletConfig config = mock(ServletConfig.class);
        when(config.getServletContext()).thenReturn(servletContext);
        try {
            servlet.init(config);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    void testResetGame(){
        when(request.getParameter("resetGame")).thenReturn("true");

        try {
            servlet.doPost(request,response);

            verify(session).setAttribute("currentQuestionId",1);
            verify(response).sendRedirect(request.getContextPath() +"/jsp/quest.jsp");
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testCorrectAnswerLeadsToNextQuestion(){
        when(request.getParameter("answerId")).thenReturn("1");
        when(session.getAttribute("currentQuestionId")).thenReturn(1);

        Question question = new Question(1,"Вопрос1", List.of(new Answer(1,"Ответ",2)));
        when(yamlQuestionRepository.getQuestionById(1)).thenReturn(question);

        try {
            servlet.doPost(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        verify(session).setAttribute("currentQuestionId",2);
        try {
            verify(response).sendRedirect(request.getContextPath() +"/jsp/quest.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testGameOverRedirect(){
        when(request.getParameter("answerId")).thenReturn("1");
        when(session.getAttribute("currentQuestionId")).thenReturn(1);

        Question question = new Question(1,"Вопрос1", List.of(new Answer(1,"Ответ",-1)));
        when(yamlQuestionRepository.getQuestionById(1)).thenReturn(question);

        try {
            servlet.doPost(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            verify(response).sendRedirect(request.getContextPath() +"/jsp/gameOver.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testVictoryRedirect(){
        when(request.getParameter("answerId")).thenReturn("1");
        when(session.getAttribute("currentQuestionId")).thenReturn(1);

        Question question = new Question(1,"Вопрос1", List.of(new Answer(1,"Ответ",-2)));
        when(yamlQuestionRepository.getQuestionById(1)).thenReturn(question);

        try {
            servlet.doPost(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            verify(response).sendRedirect(request.getContextPath()+"/jsp/victory.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    void testInvalidAnswerParameter(){
        when(request.getParameter("answerId")).thenReturn(null);

        try {
            servlet.doPost(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            verify(response, never()).sendRedirect(anyString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}