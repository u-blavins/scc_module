<%-- 
    Document   : index
    Created on : 02-Jan-2020, 20:11:46
    Author     : UBlavins
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <table>
            <tr>
                <th>Symbol</th>
                <th>Name</th>
                <th>Available Share</th>
                <th>FTSE Sector</th>
                <th>Currency</th>
                <th>Share Price</th>
                <th>Last Updated</th>
                <th>Logo</th>
            </tr>
            
            <%-- start web service invocation --%><hr/>
        <%
        try {
            sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
            sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
            
            java.util.List<String> symbols = port.getCompanySymbols();
            java.lang.String table = "";
            for (String symbol : symbols) {
                java.lang.String tableRow = "<tr>";
                tableRow += 
                    "<td>"+symbol+"</td>"+
                    "<td>"+port.getCompanyName(symbol)+"</td>"+
                    "<td>"+port.getAvailableShares(symbol)+"</td>"+
                    "<td>"+port.getCompanyFTSESector(symbol)+"</td>"+
                    "<td>"+port.getCompanyShareCurrencyFormat(symbol)+"</td>"+
                    "<td>"+port.getCompanyShareValue(symbol)+"</td>"+
                    "<td>"+"Today"+"</td>"+
                    "<td><img src='"+port.getCompanyLogo(symbol)+"'></td>";
                tableRow += "</tr>";
                table += tableRow;
            }
            table += "</table>";
            out.println(table);
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
        %>
        <%-- end web service invocation --%><hr/>

    </body>
</html>
