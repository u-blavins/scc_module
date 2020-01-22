<%@ Page Language="C#" Inherits="SharesBrokerASPClient.Profile" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>Profile</title>
</head>
<body>
    <h1> Shares Broker Client </h1>
    <form runat="server">
        <asp:Button id="sharesButton" runat="server" Text="Company Shares" OnClick="shares"></asp:Button>
        <asp:Button id="logoutButton" runat="server" Text="Logout" OnClick="logout"></asp:Button>
    </form>
    <br>
	<form id="userShareForm" runat="server">
        <asp:Table id="userShareTable" runat="server" style="border: 1px solid;">
            <asp:TableRow>
                <asp:TableCell>Company</asp:TableCell>
                <asp:TableCell>Shares</asp:TableCell>
            </asp:TableRow>
        </asp:Table>
        <asp:Label id="notificationLabel" runat="server"/>
	</form>
</body>
</html>
