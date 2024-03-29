﻿<%@ Page Language="C#" Inherits="SharesBrokerASPClient.Shares" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>SharesBroker</title>
</head>
<body>
    <h1> Shares Broker Client </h1>
    <form runat="server">
        <asp:Button id="viewShareButton" runat="server" Text="My Shares" OnClick="profile"></asp:Button>
        <asp:Button id="adminButton" runat="server" Text="Admin Page" OnClick="admin"></asp:Button>
        <asp:Button id="logoutButton" runat="server" Text="Logout" OnClick="logout"></asp:Button>
    </form>
    <br>
    <div id="tables" runat="server" style="margin:0; text-align:center; width: 100%;">
	    <form id="filterForm" runat="server" style="margin:0 auto;">
            <asp:Table id="filterTable" runat="server" width="70%">
                <asp:TableRow>
                    <asp:TableCell>Symbol</asp:TableCell>
                    <asp:TableCell>Company</asp:TableCell>
                    <asp:TableCell>FTSE Sector</asp:TableCell>
                    <asp:TableCell>Price Range</asp:TableCell>
                    <asp:TableCell>Filter Price</asp:TableCell>
                    <asp:TableCell>Currency</asp:TableCell>
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
                        <asp:DropDownList id="filterCurrencyCodes" runat="server">
                            <asp:ListItem value="None">None</asp:ListItem>
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
            <asp:Table id="sharesTable" runat="server" width="70%" style="border: 1px solid; text-align: left;">
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
        <form id="transactionForm" runat="server" style="text-align: left;">
            <label>Update Currency Conversion</label>
            <asp:Button id="updateCurrButton" runat="server" Text="Update Currency" OnClick="updateCurrency"></asp:Button>
            <lable>Select Company to buy/sell shares from: </label>
            <asp:DropDownList id="companySymbols" runat="server">
                <asp:ListItem value="None">None</asp:ListItem>
            </asp:DropDownList>
            <asp:TextBox id="buyShareText" runat="server"/>
            <asp:Button id="buyShareButton" runat="server" Text="Buy" OnClick="buyShares"></asp:Button>
            <asp:TextBox id="sellShareText" runat="server"/>
            <asp:Button id="sellShareButton" runat="server" Text="Sell" OnClick="sellShares"></asp:Button>
            <asp:Button id="updateSharePriceButton" runat="server" Text="Update Share Price" OnClick="updateShare"></asp:Button>
        </form>
        <br>
        <form id="notificationForm" runat="server">
            <asp:Label id="notificationLabel" runat="server"/>
        </form>
    </div>
</body>
</html>
