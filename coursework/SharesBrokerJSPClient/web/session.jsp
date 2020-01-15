<%--
    Document   : session.jsp
    Created on : 15-Jan-2020, 09:02:55
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
        <%
            String user = request.getParameter("username");
            String pass = request.getParameter("password");

            if (user!=null && user.length()!=0) {
                try {
                    sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
                    sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
                    boolean result = port.loginUser(user, pass);
                    
                    out.print("<p>"+ result+ "</p>");
                    
                    if (result) {
                        session.setAttribute("username", user);
                        response.sendRedirect("shares.jsp");
                    } else {
                        response.sendRedirect("login.jsp");
                    }
                    
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            } else {
                response.sendRedirect("login.jsp");
            }
        %>
    </body>
</html>
