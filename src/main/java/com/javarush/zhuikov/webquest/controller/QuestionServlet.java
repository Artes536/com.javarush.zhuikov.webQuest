package com.javarush.zhuikov.webquest.controller;

import com.javarush.zhuikov.webquest.entity.Answer;
import com.javarush.zhuikov.webquest.entity.Question;
import com.javarush.zhuikov.webquest.service.GameService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "questionServlet", value = "/question-servlet")
public class QuestionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GameService gameService = (GameService) getServletContext().getAttribute("gameService");

        if (gameService == null) {
            resp.sendRedirect(req.getContextPath() + "/jsp/quest.jsp");
            return;
        }
        if ("true".equals(req.getParameter("resetGame"))) {
            session.setAttribute("currentQuestionId", 1);
            Integer attempts = (Integer) session.getAttribute("attempts");
            if (attempts == null) attempts = 0;
            session.setAttribute("attempts", attempts + 1);
            resp.sendRedirect(req.getContextPath() + "/jsp/quest.jsp");
            return;
        }
        String answerIdParam = req.getParameter("answerId");
        if (answerIdParam != null) {
            Integer answerId = Integer.parseInt(answerIdParam);

            Integer currentQuestionId = (Integer) session.getAttribute("currentQuestionId");
            if (currentQuestionId == null) {
                currentQuestionId = 1;
            }

            Question currentQuestion = gameService.getRepository().getQuestionById(currentQuestionId);
            if (currentQuestion != null) {
                for (Answer answer : currentQuestion.getAnswers()) {
                    if (answer.getId().equals(answerId)) {
                        if (answer.getNextQuestion() == -1) {
                            resp.sendRedirect(req.getContextPath() + "/jsp/gameOver.jsp");
                            return;
                        }
                        else if(answer.getNextQuestion() == -2){
                            resp.sendRedirect(req.getContextPath() + "/jsp/victory.jsp");
                            return;
                        }else {
                            session.setAttribute("currentQuestionId", answer.getNextQuestion());
                            resp.sendRedirect(req.getContextPath() + "/jsp/quest.jsp");
                            break;
                        }
                    }
                }
            }
        }

    }
}
