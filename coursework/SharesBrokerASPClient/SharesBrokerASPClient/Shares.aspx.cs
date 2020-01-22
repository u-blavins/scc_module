using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SharesBrokerASPClient.SharesBroker;

namespace SharesBrokerASPClient
{

    public partial class Shares : System.Web.UI.Page
    {
        private shareType[] shares;
        private string username;
        private bool isAdmin;

        protected void Page_Load(object sender, EventArgs args)
        {
            if (Session["username"]!=null)
            {
                username = Session["username"].ToString();
                
            } else
            {
                Response.Redirect("~/Default.aspx");
            }
            if (!IsPostBack)
            {
                viewAdminButton();
                loadSectors();
                loadCodes();
                loadSymbols();
            }
            loadTable(new SharesBroker.SharesBrokerWS().getCompanyShares());
        }

        private void viewAdminButton()
        {
            UserWebService.UserService userProxy = new UserWebService.UserService();
            if (!userProxy.isUserAdmin(Session["username"].ToString()))
            {
                adminButton.Attributes.CssStyle.Add("display", "none");
            }
        }

        private void loadSectors()
        {
            string[] sectors = new SharesBroker.SharesBrokerWS().getFTSESectors();
            for (int i = 0; i < sectors.Length; i++)
            {
                filterSector.Items.Add(new ListItem(sectors[i], sectors[i]));
            }
        }

        private void loadSymbols()
        {
            string[] symbols = new SharesBroker.SharesBrokerWS().getCompanySymbols();
            for (int i = 0; i < symbols.Length; i++)
            {
                companySymbols.Items.Add(new ListItem(symbols[i], symbols[i]));
            }
        }

        private void loadCodes()
        {
            string[] codes = new SharesBroker.SharesBrokerWS().getCurrencyCodes();
            for (int i = 0; i < codes.Length; i++)
            {
                filterCurrencyCodes.Items.Add(new ListItem(codes[i], codes[i]));
            }
        }

        public void filter(object sender, EventArgs args)
        {
            string symbol = filterSymbol.Text;
            string company = filterCompany.Text;
            string sector = filterSector.SelectedItem.Text;
            string minStr = filterMin.Text;
            string maxStr = filterMax.Text;
            string priceFilter = filterPrice.SelectedItem.Text;
            string currency = filterCurrencyCodes.SelectedItem.Text;

            SharesBroker.SharesBrokerWS sharesProxy = new SharesBroker.SharesBrokerWS();

            if (symbol.Equals("") && company.Equals("") && sector!="None" &&
                minStr.Equals("") && maxStr.Equals("") && priceFilter!="None" &&
                currency.Equals(""))
            {
                resetTable();
                shareType[] compShares = sharesProxy.getCompanyShares();
                loadTable(compShares);

            } else
            {
                float min = 0;
                float max = 0;

                if (currency!="None")
                {
                    Session.Add("currency", currency);
                }

                try
                {
                    min = float.Parse(minStr, System.Globalization.CultureInfo.InvariantCulture);
                    max = float.Parse(maxStr, System.Globalization.CultureInfo.InvariantCulture);
                } catch (Exception ex) {}

                try
                {
                    shareType[] compShares = sharesProxy.getCompanyShares();
                    if (Session["currency"]!=null)
                    {
                        compShares = sharesProxy.getPriceByCurrency(
                            Session["currency"].ToString(), compShares);
                    }
                    compShares = sharesProxy.filterQuery(symbol, company, sector, priceFilter, min, max, compShares);
                    resetTable();
                    loadTable(compShares);
                } catch (Exception ex) {}

            }

        }

        public void reset(object sender, EventArgs args)
        {
            filterSymbol.Text = "";
            filterCompany.Text = "";
            filterSector.SelectedItem.Value = "None";
            filterMin.Text = "";
            filterMax.Text = "";
            filterPrice.SelectedItem.Value = "None";
            filterCurrencyCodes.SelectedItem.Value = "None";
            notificationLabel.Text = "";
        }

        public void loadTable(shareType[] companyShares)
        {
            shares = companyShares;
            int numShares = companyShares.Length;
            for (int i = 0; i < numShares; i++)
            {
                TableRow tr = new TableRow();
                string[] data = getData(companyShares[i]);
                for (int j = 0; j < 7; j++) 
                {
                    TableCell tc = new TableCell();
                    tc.Text = data[j];
                    tr.Cells.Add(tc);
                }
                sharesTable.Rows.Add(tr);
            }
        }

        private string[] getData(shareType share)
        {
            string[] data = new string[7];
            data[0] = share.CompanySymbol;
            data[1] = share.CompanyName;
            data[2] = share.AvailableShares.ToString();
            data[3] = share.CompanyFTSESector;
            data[4] = share.share_price.Currency;
            data[5] = share.share_price.Value.ToString();
            data[6] = share.share_price.LastUpdated.ToString();
            return data;
        }

        private void resetTable()
        {
            int rows = shares.Length;
            int i = 1;
            while (rows > 0)
            {
                sharesTable.Rows.Remove(sharesTable.Rows[i]);
                rows--;
            }
        }

        public void buyShares(object sender, EventArgs args)
        {
            string company = companySymbols.SelectedValue.ToString();
            string buySharesText = buyShareText.Text.ToString();
            if (buySharesText!="")
            {
                if (int.TryParse(buySharesText, out int buyShare))
                {
                    if (company!="None")
                    {
                        UserWebService.UserService userProxy = new UserWebService.UserService();
                        userProxy.purchaseShares(Session["username"].ToString(), company, buyShare);
                        companySymbols.SelectedValue = "None";
                        buyShareText.Text = "";
                        resetTable();
                        loadTable(new SharesBrokerWS().getCompanyShares());
                    } else
                    {
                        notificationLabel.Text = "Please select a company";
                    }
                    
                } else
                {
                    notificationLabel.Text = "Enter a number for buying shares";
                }
            }
        }

        public void sellShares(object sender, EventArgs args)
        {
            string company = companySymbols.SelectedValue.ToString();
            string sellSharesText = sellShareText.Text.ToString();
            if (sellSharesText != "")
            {
                if (int.TryParse(sellSharesText, out int sellShare))
                {
                    if (company != "None")
                    {
                        UserWebService.UserService userProxy = new UserWebService.UserService();
                        userProxy.sellShares(Session["username"].ToString(), company, sellShare);
                        companySymbols.SelectedValue = "None";
                        buyShareText.Text = "";
                        resetTable();
                        loadTable(new SharesBrokerWS().getCompanyShares());
                    }
                    else
                    {
                        notificationLabel.Text = "Please select a company";
                    }

                }
                else
                {
                    notificationLabel.Text = "Enter a number for selling shares";
                }
            }
        }

        public async void updateShare(object sender, EventArgs args)
        {
            SharesBroker.SharesBrokerWS shareProxy = new SharesBroker.SharesBrokerWS();
            string symbol = companySymbols.SelectedValue.ToString();
            string updatedSharePrice;
            if (symbol!="None")
            {
                try
                {
                    updatedSharePrice = shareProxy.getRealTimeShares(symbol, "price");
                    if (updatedSharePrice != "")
                    {
                        shareProxy.updateSharePrice(symbol, float.Parse(updatedSharePrice));
                        resetTable();
                        loadTable(shareProxy.getCompanyShares());
                        notificationLabel.Text = "Share price has been updated";
                    } else
                    {
                        notificationLabel.Text = "Share price has not been updated";
                    }
                } catch (Exception ex)
                {
                    notificationLabel.Text = "Share not updated";
                }
            }
        }

        public void profile(object sender, EventArgs args)
        {
            Response.Redirect("~/Profile.aspx");
        }

        public void admin(object sender, EventArgs args)
        {
            Response.Redirect("~/Admin.aspx");
        }

        public void logout(object sender, EventArgs args)
        {
            Session.Clear();
            Response.Redirect("~/Default.aspx");
        }

        public void updateCurrency(object sender, EventArgs args)
        {
            bool updated = new SharesBroker.SharesBrokerWS().updateRates();
            if (updated)
            {
                notificationLabel.Text = "Rates have been updated";
            } else
            {
                notificationLabel.Text = "Rates are already up to date";
            }


        }

    }
}