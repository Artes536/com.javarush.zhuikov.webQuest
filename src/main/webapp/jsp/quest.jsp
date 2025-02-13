<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.javarush.zhuikov.webquest.entity.Question" %>
<%@ page import="com.javarush.zhuikov.webquest.entity.Answer" %>
<%@ page import="com.javarush.zhuikov.webquest.service.GameService" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Квест</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/styleQuest.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%
    GameService gameService = (GameService) application.getAttribute("gameService");

    Integer currentQuestionId = (Integer) session.getAttribute("currentQuestionId");
    if (currentQuestionId == null) {
        currentQuestionId = 1;
        session.setAttribute("currentQuestionId", currentQuestionId);
    }


    Question question = gameService.getRepository().getQuestionById(currentQuestionId);
%>

<div class="container mt-5">
    <h1 class="text-center">Квест</h1>

    <div class="card mb-3">
        <div class="card-body">
            <h3><%= question != null ? question.getText() : "Ошибка загрузки вопроса" %></h3>
        </div>
    </div>

    <div class="list-group">
        <label form="form-label">Выбери ответ:</label>
        <form action="<%= request.getContextPath() %>/question-servlet" method="post">
            <% if (question != null) {
                for (Answer answer : question.getAnswers()) { %>
            <button type="submit" class="list-group-item list-group-item-action" name="answerId" value="<%= answer.getId() %>">
                <%= answer.getText() %>
            </button>
            <%  } } %>
        </form>
    </div>
</div>

<div class="position-fixed bottom-0 start-0 p-3">
    <div class="card">
        <div class="card-body text-start p-3">
            <p><strong>Имя:</strong> <%= session.getAttribute("playerName") %></p>
            <p><strong>Попытки:</strong> <%= session.getAttribute("attempts") %></p>
        </div>
    </div>
</div>

</body>
</html>
