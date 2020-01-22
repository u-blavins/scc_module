<%@ Page Language="C#" Inherits="SharesBrokerASPClient.Admin" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>Admin</title>
</head>
<body>
    <h1> Shares Broker Client </h1>
    <form runat="server">
        <asp:Button id="sharesButton" runat="server" Text="Company Shares" OnClick="shares"></asp:Button>
        <asp:Button id="viewShareButton" runat="server" Text="My Shares" OnClick="profile"></asp:Button>
        <asp:Button id="logoutButton" runat="server" Text="Logout" OnClick="logout"></asp:Button>
    </form>
    <br>
	<form id="adminForm" runat="server">
        <div>
            <label>Add a new company: </label>
            <br><br>
            <asp:Table id="addShareTable" runat="server">
                <asp:TableRow>
                    <asp:TableCell>Symbol</asp:TableCell>
                    <asp:TableCell>Name</asp:TableCell>
                    <asp:TableCell>Sector</asp:TableCell>
                    <asp:TableCell>Available Shares</asp:TableCell>
                    <asp:TableCell>Logo URL</asp:TableCell>
                    <asp:TableCell>Currency</asp:TableCell>
                    <asp:TableCell>Share Price</asp:TableCell>
                </asp:TableRow>
                <asp:TableRow>
                        <asp:TableCell><asp:TextBox id="companySymbol" runat="server"/></asp:TableCell>
                        <asp:TableCell><asp:TextBox id="companyName" runat="server"/></asp:TableCell>
                        <asp:TableCell>
                            <asp:DropDownList id="ftseSectors" runat="server"></asp:DropDownList>
                        </asp:TableCell>
                        <asp:TableCell><asp:TextBox id="companyShares" runat="server"/></asp:TableCell>
                        <asp:TableCell><asp:TextBox id="companyLogo" runat="server"/></asp:TableCell>
                        <asp:TableCell>
                            <asp:DropDownList id="currencyCodes" runat="server"></asp:DropDownList>
                        </asp:TableCell>
                        <asp:TableCell><asp:TextBox id="companySharePrice" runat="server"/></asp:TableCell>
               </asp:TableRow>
            </asp:Table>
            <asp:Button id="addShareButton" Text="Add Share" runat="server" OnClick="addShare"></asp:Button>
        </div>
        <br>
        <div>
            <label>Remove company: </label>
            <br>
            <asp:DropDownList id="companySymbols" runat="server"></asp:DropDownList>
            <asp:Button id="removeCompanyButton" Text="Remove Company" runat="server" OnClick="removeCompany"></asp:Button>
        </div>
        <br>
        <asp:Label id="notificationLabel" runat="server"/>
	</form>
</body>
</html>
