<%-- 
    Document   : shares.jsp
    Created on : 15-Jan-2020, 08:24:03
    Author     : UBlavins
--%>

<%@page import="org.netbeans.xml.schema.shares.ShareType"%>
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
        <form method="post" action="shares.jsp">
            <table>
                  <tr>
                    <th>Company Symbol</th>
                    <th>Company Name</th>
                    <th>FTSE Sector</th>
                    <th>Filter Price</th>
                    <th>Price Range</th>
                    <th></th>
                  </tr>
              <tr>
                  <td><input name="symbol" type="text"></td>
                  <td><input name="name" type="text"></td>
                  <td><input name="sector" type="text"></td>
                  <td>
                      <select name="filterPrice">
                          <option value="none">None</option>
                          <option value="lowest">Lowest</option>
                          <option value="highest">Highest</option>
                      </select>
                  </td>
                  <td>
                      Min: <input name="min" type="number">
                      Max: <input name="max" type="number">
                  </td>
                  <td><input type="submit" value="filter"></td>
              </tr>
            </table>
            <br>
        </form> 
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
            String symbol = request.getParameter("symbol");
            String name = request.getParameter("name");
            String sector = request.getParameter("sector");
            String filterPrice = request.getParameter("filterPrice");
            String min = request.getParameter("min");
            String max = request.getParameter("max");
            
            out.print(request.getParameter("symbol"));
            
            java.util.List<ShareType> shares;
            
            if (symbol==null && name==null && sector==null && 
                    filterPrice.equals("none") && min==null && max==null) {
                try {
                    sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
                    sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
                    // TODO process result here
                    shares = port.getCompanyShares();
                    
                    for (ShareType share : shares) {
                        out.print("<tr>");
                        out.print("<td>"+share.getCompanySymbol()+"</td>");
                        out.print("<td>"+share.getCompanyName()+"</td>");
                        out.print("<td>"+share.getAvailableShares()+"</td>");
                        out.print("<td>"+share.getCompanyFTSESector()+"</td>");
                        out.print("<td>"+share.getSharePrice().getCurrency()+"</td>");
                        out.print("<td>"+share.getSharePrice().getValue()+"</td>");
                        out.print("<td><form method='post' action='share.jsp'>"
                                + "<input type='hidden' name='companySymbol' value='"
                                + share.getCompanySymbol()+ "'><input type='submit'"
                                + " value='View'></form></td>");
                        out.print("</tr>");
                    }   
                } catch (Exception ex) {
                    // TODO handle custom exceptions here
                }
            } else {
                
            }
            
            
        %>
        </table>
    </body>
</html>
