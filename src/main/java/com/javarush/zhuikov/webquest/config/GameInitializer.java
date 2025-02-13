package com.javarush.zhuikov.webquest.config;

import com.javarush.zhuikov.webquest.repository.YamlQuestionRepository;
import com.javarush.zhuikov.webquest.service.GameService;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class GameInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();

        YamlQuestionRepository repository = new YamlQuestionRepository("questions.yaml");
        GameService gameService = new GameService(repository);

        servletContext.setAttribute("gameService",gameService);
    }
}
