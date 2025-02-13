package com.javarush.zhuikov.webquest.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
class GameServletTest {
    GameServlet servlet;
    HttpServletRequest request;
    HttpServletResponse response;
    HttpSession session;

    @BeforeEach
    void init() {
        servlet = new GameServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);

        when(request.getSession()).thenReturn(session);
    }

    @Test
    void testSetSessionAttributeAndRedirect() {

        when(request.getParameter("playerName")).thenReturn("TestPlayer");

        try {
            servlet.doPost(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        verify(session).setAttribute("playerName", "TestPlayer");
        verify(session).setAttribute("attempts", 0);
        try {
            verify(response).sendRedirect("jsp/quest.jsp");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
