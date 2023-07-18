<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BuySell</title>
</head>
<body>
<h1>BuySell</h1>
<h4>Авторизация</h4>
<form action="/login" method="post">
    <label for="email">Эл. почта</label><input id="email" type="email" name="username"> <br> <br>
    <label for="password">Пароль</label><input id="password" type="password" name="password"> <br> <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход"><br> <br>
</form>
<a href="/registration">Зарегистрироваться</a>
</body>
</html>