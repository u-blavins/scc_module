<%@ Page Language="C#" Inherits="SharesBrokerASPClient.Default" %>
<!DOCTYPE html>
<html>
<head runat="server">
	<title>SharesBroker</title>
</head>
<body>
   <h1> Shares Broker Client </h1>
	<form id="loginForm" runat="server">
        <h3> Login </h3>
        <label>Username: </label>
        <asp:TextBox id="loginUsername" runat="server"/>
        <br>
        <label>Password: </label>
        <asp:TextBox id="loginPassword" runat="server" TextMode="Password"/>
        <br>
        <asp:Button id="loginButton" runat="server" Text="Login" OnClick="login"/>
	</form>
   <br>
   <form id="registerForm" runat="server">
        <h3> Register </h3>
        <label>Username: </label>
        <asp:TextBox id="regUsername" runat="server"/>
        <br>
        <label>Password: </label>
        <asp:TextBox id="regPassword" runat="server" TextMode="Password"/>
        <br>
        <label>Confirm Password: </label>
        <asp:TextBox id="regConPassword" runat="server" TextMode="Password"/>
        <br>
        <asp:Button id="registerButton" runat="server" Text="Register" OnClick="register"/>
   </form>
   <asp:Label id="notifcationLabel" runat="server"/>
</body>
</html>
