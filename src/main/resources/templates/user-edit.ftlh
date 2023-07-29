<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>BuySell</title>
</head>
<body>
<h1>Buysell</h1>
<hr>
<h3>Редактирование пользователя ${user.name}</h3>
<form method="post" action="/admin/user/edit">
    <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked","")}>${role}</label>
            </div>
    </#list>
    <input type="hidden" name="userId" value="${user.id}">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Сохранить"><br> <br>
</form>
</body>
</html>