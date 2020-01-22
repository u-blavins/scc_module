using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SharesBrokerASPClient.UserWebService;

namespace SharesBrokerASPClient
{

    public partial class Profile : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs args)
        {
            if (Session["username"] == null)
            {
                Response.Redirect("~/Default.aspx");
            }
            loadTable();
        }

        public void loadTable()
        {
            UserWebService.UserService userProxy = new UserWebService.UserService();
            userType user = userProxy.getUser(Session["username"].ToString());
            for (int i = 0; i < user.UserShares.Length; i++)
            {
                TableRow tr = new TableRow();
                if (user.UserShares[i].CompanyShares != 0 && user.UserShares
                    [i].CompanyShares >= 0)
                {
                    TableCell tc = new TableCell();
                    tc.Text = user.UserShares[i].CompanySymbol;
                    tr.Cells.Add(tc);
                    TableCell tc1 = new TableCell();
                    tc1.Text = user.UserShares[i].CompanyShares.ToString();
                    tr.Cells.Add(tc1);
                }
                userShareTable.Rows.Add(tr);
            }
        }

        public void shares(object sender, EventArgs args)
        {
            Response.Redirect("~/Shares.aspx");
        }

        public void logout(object sender, EventArgs args)
        {
            Session.Clear();
            Response.Redirect("~/Default.aspx");
        }
    }
}
