<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Поражение</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styleGameOver.css" type="text/css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container text-center">
    <h1 id="game-Over">Вас казнили!</h1>
    <h2>Король в вас разочаровался</h2>
    <p>Хотите попробовать снова?</p>
    <form action="<%= request.getContextPath() %>/question-servlet" method="post">
        <input type="hidden" name="resetGame" value="true">
        <button type="submit" class="btn btn-primary">Начать заново</button>
    </form>
</div>
</body>
</html>
