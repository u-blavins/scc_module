<%-- 
    Document   : share
    Created on : 15-Jan-2020, 13:18:05
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
        <h1>Hello <%=session.getAttribute("username")%></h1>
        <a href="logout.jsp">Logout</a>
        <%
            String companySymbol = request.getParameter("company");
            out.print("<h1>"+companySymbol+"</h1>");
        %>
    </body>
</html>
