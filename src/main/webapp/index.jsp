<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добро пожаловать в Квест</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styleIndex.css" rel="stylesheet" type="text/css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container text-center">
    <h1 class="mb-4">Добро пожаловать в мир приключений!</h1>

    <div class="text-container mb-4">
        <div class="box">
            <h3>Предыстория</h3>
            <p>Король Аврелиус III славится своим жестоким нравом и капризностью. Ему легко наскучивают привычные развлечения, а недовольство он выражает самым радикальным образом – отсекая головы тем, кто не смог его развеселить.

                Последние несколько месяцев он особенно мрачен. Поговаривают, что его терзают кошмары, но никто не осмеливается спросить. Единственное, что может удержать короля от вспышек гнева – это смех, но найти то, что его рассмешит, становится всё труднее.

                Арлекины один за другим теряли свои жизни, пытаясь угодить монарху. Те, кто переигрывал, выглядели жалкими. Те, кто шутил неудачно, вызывали раздражение. А те, кто пытался показать себя умнее короля, встречались со сталью палача.

                Теперь твоя очередь. Ты – новый арлекин, вызванный ко двору. У тебя есть всего один шанс повеселить короля… или разделить участь своих предшественников.</p>
        </div>
        <div class="box">
            <h3>Текущая ситуация</h3>
            <p>Ты стоишь в тронном зале. Огромные колонны уходят вверх, свечи отбрасывают пляшущие тени на стены, а гвардейцы смотрят на тебя с равнодушием людей, привыкших к казням.

                На троне, тяжело опершись на руку, восседает король Аврелиус III. Его глаза смотрят на тебя с ленивым безразличием, но в них сверкает опасный огонёк.

                – Ещё один? – он зевает, осматривая тебя с головы до ног. – Ну что ж, шут, развесели меня. Или будешь веселить червей под землёй.

                В зале воцаряется напряжённая тишина. Все ждут твоего выступления.

                Ты понимаешь, что всего одна ошибка – и тебя не станет.</p>
        </div>
    </div>

    <form action="game-servlet" method="post">
        <div class="mb-3">
            <label for="playerName" class="form-label">Как тебя зовут, путешественник?</label>
            <input type="text" id="playerName" name="playerName" class="form-control" required>
        </div>
        <button type="submit" class="btn btn-primary">Начать игру</button>
    </form>
</div>

</body>
</html>
