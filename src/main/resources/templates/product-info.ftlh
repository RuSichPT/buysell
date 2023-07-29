<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BuySell</title>
</head>
<body>
<h1>Buysell</h1>
<hr>
<h4>Подробная информация о товаре</h4>
<#list images as image>
    <img src="/image/${image.id}" alt="image${image.id}" height="60px"><br><br>
</#list>
<b>Название товара:</b> ${product.title} <br>
<b>Описание товара:</b> ${product.description} <br>
<b>Цена:</b> ${product.price} <br>
<b>Город:</b> ${product.city} <br>
<b>Автор:</b> <a href="/user/${product.user.id}"> ${product.user.name}</a> <br>
</body>
</html>