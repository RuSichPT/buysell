<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BuySell</title>
</head>
<body>
<h1>Buysell</h1>
<hr>
<h4>Панель администратора</h4>
<table border="1">
    <tr>
        <th>Email</th>
        <th>Номер телефона</th>
        <th>Активность</th>
        <th>Роли</th>
        <th>Бан</th>
        <th>Редактирование</th>
        <th>Подробная информация</th>
    </tr>
    <#list users as user >
        <tr>
            <td>${user.email}</td>
            <td>${user.phoneNumber}</td>
            <td><#if user.active>true<#else>false</#if></td>
            <td><#list user.roles as role>
                    ${role}
                    <#sep>,
                </#list>
            </td>
            <td>
                <form action="/admin/user/ban/${user.id}" method="post">
                    <input type="hidden" name="_csrf" value="${_csrf.token}">
                    <input type="submit" value="Бан">
                </form>
            </td>
            <td><a href="admin/user/edit/${user.id}">Редактирование</a></td>
            <td><a href="/user/${user.id}">Подробная информация</a></td>
        </tr>
    <#else>
        <h3>Пользователей нет</h3>
    </#list>
    <tr>

    </tr>
</table>
</body>
</html>