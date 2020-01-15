<%-- 
    Document   : shares.jsp
    Created on : 15-Jan-2020, 08:24:03
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
        <h1>Shares Broker</h1>
        <h2>Hello, <%=session.getAttribute("username")%></h2>
        <a href="logout.jsp">Logout</a>
        <table>
            <tr>
                <th>Symbol</th>
                <th>Name</th>
                <th>Available Share</th>
                <th>FTSE Sector</th>
                <th>Currency</th>
                <th>Share Price</th>
                <th>Last Updated</th>
                <th></th>
            </tr>
        <%
            String symbol = request.getParameter("symbols");
            if (symbol==null || symbol.length()==0) {
                
                try {
                    sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
                    sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
                    // TODO process result here
                    java.util.List<sharesbroker.ShareType> result = port.getCompanyShares();
                    
                    for (sharesbroker.ShareType share : result) {
                        out.print("<tr>");
                        out.print("<td>"+share.getCompanySymbol()+"</td>");
                        out.print("<td>"+share.getCompanyName()+"</td>");
                        out.print("<td>"+share.getAvailableShares()+"</td>");
                        out.print("<td>"+share.getCompanyFTSESector()+"</td>");
                        out.print("<td>"+
                                share.getSharePrice().getCurrency()+"</td>");
                        out.print("<td>"+share.getSharePrice().getValue()+"</td>");
                        out.print("<td>"+
                                share.getSharePrice().getLastUpdated()+"</td>");
                        out.print("<td>"
                                + "<form name='shareForm' method='post' action='share.jsp'>"
                                + "<input type='hidden' name='company' value='"+ share.getCompanySymbol()
                                +"''><input type='submit' value='View'></form>"
                                + "</td>");
                        out.print("</tr>");
                    }


                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            }
        %>
        </table>
    </body>
</html>
