<%@ Page Language="C#" Inherits="SharesBrokerASPClient.Shares" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>SharesBroker</title>
</head>
<body>
    <h1> Shares Broker Client </h1>
    <div id="tableForm" runat="server" style="margin:0; text-align:center; width: 100%;">
	    <form id="filterForm" runat="server" style="margin:0 auto;">
            <asp:Table id="filterTable" runat="server" width="70%">
                <asp:TableRow>
                    <asp:TableCell>Symbol</asp:TableCell>
                    <asp:TableCell>Company</asp:TableCell>
                    <asp:TableCell>FTSE Sector</asp:TableCell>
                    <asp:TableCell>Price Range</asp:TableCell>
                    <asp:TableCell>Filter</asp:TableCell>
                    <asp:TableCell><asp:Button id="filterButton" runat="server" Text="Filter" OnClick="filter"></asp:Button></asp:TableCell>
                </asp:TableRow>
                <asp:TableRow>
                    <asp:TableCell><asp:TextBox id="filterSymbol" runat="server"/></asp:TableCell>
                    <asp:TableCell><asp:TextBox id="filterCompany" runat="server"/></asp:TableCell>
                    <asp:TableCell>
                        <asp:DropDownList id="filterSector" runat="server">
                            <asp:ListItem>None</asp:ListItem>
                        </asp:DropDownList>
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:TextBox id="filterMin" runat="server" TextMode="Number"/>
                        <asp:TextBox id="filterMax" runat="server" TextMode="Number"/>
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:DropDownList id="filterPrice" runat="server">
                            <asp:ListItem value="None">None</asp:ListItem>
                            <asp:ListItem value="Lowest">Lowest</asp:ListItem>
                            <asp:ListItem value="Highest">Highest</asp:ListItem>
                        </asp:DropDownList>
                    </asp:TableCell>
                    <asp:TableCell>
                        <asp:Button id="resetFilterButton" runat="server" Text="Reset" OnClick="reset"></asp:Button>
                    </asp:TableCell>
                </asp:TableRow>
            </asp:Table>
	    </form>
        <br>
        <form id="sharesForm" runat="server">
            <asp:Table id="sharesTable" runat="server" width="70%" style="border: 1px solid;">
                <asp:TableHeaderRow>
                    <asp:TableCell>Symbol</asp:TableCell>
                    <asp:TableCell>Company</asp:TableCell>
                    <asp:TableCell>Available Shares</asp:TableCell>
                    <asp:TableCell>FTSE Sector</asp:TableCell>
                    <asp:TableCell>Currency</asp:TableCell>
                    <asp:TableCell>Price</asp:TableCell>
                    <asp:TableCell>Last Updated</asp:TableCell>
                </asp:TableHeaderRow>
            </asp:Table>
        </form>
        <br>
        <form id="currencyForm" runat="server">
            <lable>Select Curreny to conver to: </label>
            <asp:DropDownList id="currencyCodes" runat="server"></asp:DropDownList>
            <asp:Button id="changeCurrButton" runat="server" Text="Change" OnClick="changeCurr"></asp:Button>
        </form>
        <br>
        <form id="notificationForm" runat="server">
            <asp:Label id="notificationLabel" runat="server"/>
        </form>
    </div>
</body>
</html>
