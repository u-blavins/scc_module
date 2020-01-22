using System;
using System.Web;
using System.Web.UI;

namespace SharesBrokerASPClient
{

    public partial class Admin : System.Web.UI.Page
    {

        protected void Page_Load(object sender, EventArgs args)
        {
            if (Session["username"]==null)
            {
                Response.Redirect("~/Default.aspx");
            } else
            {
                bool admin = new UserWebService.UserService().isUserAdmin(
                    Session["username"].ToString());
                if (!admin)
                {
                    Response.Redirect("~/Deafult.aspx");
                }
            }

            if (!IsPostBack)
            {
                loadSectors();
                loadCodes();
            }
            loadSymbols();
        }

        private void loadSectors()
        {
            string[] sectors = new SharesBroker.SharesBrokerWS().getFTSESectors();
            ftseSectors.DataSource = sectors;
            ftseSectors.DataBind();
        }

        private void loadCodes()
        {
            string[] codes = new SharesBroker.SharesBrokerWS().getCurrencyCodes();
            currencyCodes.DataSource = codes;
            currencyCodes.DataBind();
        }

        private void loadSymbols()
        {
            string[] symbols = new SharesBroker.SharesBrokerWS().getCompanySymbols();
            companySymbols.DataSource = symbols;
            companySymbols.DataBind();
        }

        public async void addShare(object sender, EventArgs args)
        {
            string symbol = companySymbol.Text;
            string name = companyName.Text;
            string sector = ftseSectors.SelectedValue.ToString();
            string shares = companyShares.Text;
            string logo = companyLogo.Text;
            string code = currencyCodes.SelectedValue.ToString();
            string price = companySharePrice.Text;

            SharesBroker.SharesBrokerWS sharesProxy = new SharesBroker.SharesBrokerWS();

            if (symbol!="" && name!="" && shares!="" && price!="")
            {
                if (int.TryParse(shares, out int availShares))
                {
                    if (float.TryParse(price, out float sharePrice))
                    {
                        try
                        {
                            sharesProxy.addNewCompany(symbol, name, sector,
                                logo, availShares, code, sharePrice);
                            notificationLabel.Text = "Company added with up to date volume and price";
                            companySymbol.Text = "";
                            companyName.Text = "";
                            companyShares.Text = "";
                            companyLogo.Text = "";
                            companySharePrice.Text = "";
                        } catch(Exception ex)
                        {
                            notificationLabel.Text = "Company not added";
                        }
                    } else
                    {
                        notificationLabel.Text = "Please enter a flaot in price";
                    }

                } else
                {
                    notificationLabel.Text = "Please enter a number in shares";
                }
            }
        }

        public void removeCompany(object sender, EventArgs args)
        {
            string company = companySymbols.SelectedValue.ToString();
            SharesBroker.SharesBrokerWS sharesWsProxy = new SharesBroker.SharesBrokerWS();
            sharesWsProxy.removeCompany(company);
            Response.Redirect("~/Admin.aspx");
        }

        public void shares(object sender, EventArgs args)
        {
            Response.Redirect("~/Shares.aspx");
        }

        public void profile(object sender, EventArgs args)
        {
            Response.Redirect("~/Profile.aspx");
        }

        public void logout(object sender, EventArgs args)
        {
            Session.Clear();
            Response.Redirect("~/Default.aspx");
        }
    }
}
