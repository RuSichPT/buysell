<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>BuySell</h1>
<h4>Регистрация</h4>
<form action="/registration" method="post">
    <label for="name">Имя пользователя</label> <input id="name" type="text" name="name"> <br> <br>
    <label for="email">Эл. почта</label> <input id="email" type="email" name="email"> <br> <br>
    <label for="phoneNumber">Номер телефона</label> <input id="phoneNumber" type="text" name="phoneNumber"> <br> <br>
    <label for="password">Пароль</label> <input id="password" type="password" name="password"> <br> <br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Зарегистрироваться"><br> <br>
</form>
<#if errorMessage?? >
    <h2 style="color: red">${errorMessage}</h2>
</#if>

</body>
</html>