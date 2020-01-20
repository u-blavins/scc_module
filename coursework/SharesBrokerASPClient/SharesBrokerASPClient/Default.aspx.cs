using System;
using System.Web;
using System.Web.UI;

namespace SharesBrokerASPClient
{

    public partial class Default : System.Web.UI.Page
    {

        protected void Page_Load(object sender, EventArgs args)
        {

        }

        public void login(object sender, EventArgs args)
        {
            UserWebService.UserService userWsProxy = new UserWebService.UserService();
            Boolean isUser = false;
            if (loginUsername.Text!="" && loginPassword.Text!="")
            {
                isUser = userWsProxy.loginUser(loginUsername.Text, loginPassword.Text);
                if (isUser)
                {
                    Session.Add("username", loginUsername.Text);
                    Response.Redirect("~/Shares.aspx");
                } else
                {
                    notifcationLabel.Text = "Incorrect login details";
                }
            }
            else
            {
                notifcationLabel.Text = "Please fill in login fields";
            }
                
        }

        public void register(object sender, EventArgs args)
        {
            UserWebService.UserService userWsProxy = new UserWebService.UserService();
            Boolean registered = false;
            if (regUsername.Text!="" && regPassword.Text!="" && regConPassword.Text!="")
            {
                if (regPassword.Text == regConPassword.Text)
                {
                    registered = userWsProxy.registerUser(regUsername.Text,
                        regPassword.Text, regConPassword.Text);
                    if (registered)
                    {
                        notifcationLabel.Text = "User account created";
                    }
                    else
                    {
                        notifcationLabel.Text = "User account already exists";
                    }
                }

            } else
            {
                notifcationLabel.Text = "Please fill in register fields";
            }
        }
    }
}
