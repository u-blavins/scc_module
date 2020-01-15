<%-- 
    Document   : register
    Created on : 15-Jan-2020, 08:56:22
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
        <form name="registerForm" method="post" action="register.jsp">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            Confirm Password: <input type="password" name="conpassword"><br>
            <input type="submit" value="Login">
        </form>
        <%
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String conpass = request.getParameter("conpassword");
            
            if (user!=null && user.length()!=0 && pass!=null && 
                    pass.length()!=0 && conpass!=null && conpass.length()!=0) {
                try {
                    sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
                    sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
                    // TODO process result here
                    boolean result = port.registerUser(user, pass, conpass);
                    if (result) {
                        response.sendRedirect("login.jsp");
                    } else {
                        response.sendRedirect("register.jsp");
                    }
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }

            } 
        %>
    </body>
</html>
