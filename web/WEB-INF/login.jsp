<%-- 
    Document   : login
    Created on : 9-Oct-2022, 1:43:30 AM
    Author     : Hashem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <form action="login" method="post">
        <h1>Login</h1>
        <label>Username: </label>
        <input type="text" name="username" value="${username}">
        <br>
        <label>Password: </label>
        <input type="password" name="password" value="${password}">
        <br>
        <input type="submit" name="submit" value="Log In">    
        <p>${message}</p>
        </form>
    </body>
</html>