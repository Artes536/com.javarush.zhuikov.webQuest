package com.javarush.zhuikov.webquest.controller;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "gameServlet", value = "/game-servlet")
public class GameServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerName = req.getParameter("playerName");

        HttpSession session = req.getSession();
        session.setAttribute("playerName",playerName);
        session.setAttribute("attempts",0);

        resp.sendRedirect("jsp/quest.jsp");
    }

}