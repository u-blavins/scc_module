<%-- 
    Document   : login
    Created on : 15-Jan-2020, 08:14:22
    Author     : UBlavins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SharesBroker</title>
    </head>
    <body> 
        
        <form name="loginForm" method="post" action="session.jsp">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
        <a href="register.jsp">Register</a>
    </body>
</html>
