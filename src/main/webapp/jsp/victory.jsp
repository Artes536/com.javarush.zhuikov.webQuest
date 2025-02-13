<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Победа</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%= request.getContextPath() %>/css/styleVictory.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container text-center">
    <h1 id="victory">!!!Вы победили!!!</h1>
    <h2>"Король смеётся, хлопая в ладони. Он явно доволен твоим выступлением"
        <br>
        Ты глубоко кланяешься и произносишь:<br>
        "Ваше Величество, я лишь тень вашей великой мудрости, ведь даже когда я падаю, это лишь потому, что преклоняюсь перед вашим величием!"
        Король смеётся и объявляет: <br>
        "Ты — мой новый любимец!
        <br>Палач, в этот раз твой топор остаётся без дела."</h2>
    <p>Хотите попробовать снова?</p>
    <form action="<%= request.getContextPath() %>/question-servlet" method="post">
        <input type="hidden" name="resetGame" value="true">
        <button type="submit" class="btn btn-primary">Начать заново</button>
    </form>
</div>
</body>
</html>
