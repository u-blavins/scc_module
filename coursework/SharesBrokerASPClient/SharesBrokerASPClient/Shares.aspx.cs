﻿using System;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SharesBrokerASPClient.SharesBroker;

namespace SharesBrokerASPClient
{

    public partial class Shares : System.Web.UI.Page
    {
        private shareType[] shares;

        protected void Page_Load(object sender, EventArgs args)
        {
            if (!IsPostBack)
            {
                loadSectors();
                loadCodes();
            }
            loadTable(new SharesBroker.SharesBrokerWS().getCompanyShares());
        }

        private void loadSectors()
        {
            string[] sectors = new SharesBroker.SharesBrokerWS().getFTSESectors();
            for (int i = 0; i < sectors.Length; i++)
            {
                filterSector.Items.Add(new ListItem(sectors[i], sectors[i]));
            }
        }

        private void loadCodes()
        {
            string[] codes = new CurrConvertor.CurrConvertor().getCurrCodes();
            currencyCodes.DataSource = codes;
            currencyCodes.DataBind();
        }

        public void filter(object sender, EventArgs args)
        {
            string symbol = filterSymbol.Text;
            string company = filterCompany.Text;
            string sector = filterSector.SelectedItem.Text;
            string minStr = filterMin.Text;
            string maxStr = filterMax.Text;
            string priceFilter = filterPrice.SelectedItem.Text;

            SharesBroker.SharesBrokerWS sharesProxy = new SharesBroker.SharesBrokerWS();

            if (symbol.Equals("") && company.Equals("") && sector.Equals("None") &&
                minStr.Equals("") && maxStr.Equals("") && priceFilter.Equals("None"))
            {
                resetTable();
                shareType[] compShares = sharesProxy.getCompanyShares();
                try
                {
                    if (Session["currency"] != null)
                    {
                        compShares = retConvertedCurrency(compShares);
                    }

                    loadTable(compShares);
                } catch (Exception ex)
                {
                    loadTable(shares);
                }

            } else
            {
                float min = 0;
                float max = 0;

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
                        compShares = retConvertedCurrency(compShares);
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

        private shareType[] retConvertedCurrency(shareType[] shareTypes)
        {
            string code = currencyCodes.SelectedItem.Text;
            for (int i = 0; i < shareTypes.Length; i++)
            {
                shareTypes[i].share_price.Value = (float)(shareTypes[i].share_price.Value *
                    new CurrConvertor.CurrConvertor().getConversionRate(
                        shareTypes[i].share_price.Currency, code));
                shareTypes[i].share_price.Currency = code;
            }
            return shareTypes;
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

        public void changeCurr(object sender, EventArgs args)
        {
            SharesBroker.SharesBrokerWS sharesWsProxy = new SharesBroker.SharesBrokerWS();
            string code = currencyCodes.SelectedItem.Text;
            Session.Add("currency", code);
            shareType[] compShares = sharesWsProxy.getCompanyShares();
            compShares = retConvertedCurrency(compShares);
            resetTable();
            loadTable(compShares);
        }

    }
}
