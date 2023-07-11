<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BuySell</title>
</head>
<body>
<h1>
    Buysell
</h1>
<hr>
<h4>
    Товары:
</h4>
<form action="/" method="get">
    <label for="searchByTitle"></label> <input type="text" name="title" id="searchByTitle"/>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">Подробнее...</a></p>
    </div>
<#else>
    <br>
    <div>Товаров нет!</div>
</#list>
<hr>
<h3>Создать новый товар</h3>
<form action="/product/create" method="post">
    <label for="title">Название объявления:</label> <input type="text" id="title" name="title"> <br><br>
    <label for="description">Описание объявления:</label> <input type="text" id="description" name="description">
    <br><br>
    <label for="price">Цена:</label> <input type="number" id="price" name="price"> <br><br>
    <label for="city">Город:</label> <input type="text" id="city" name="city"> <br><br>
    <label for="author">Автор:</label> <input type="text" id="author" name="author"> <br><br>
    <input type="submit" value="Добавить товар"/> <br><br>
</form>
</body>
</html>