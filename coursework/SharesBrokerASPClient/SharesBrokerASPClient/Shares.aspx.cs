using System;
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
            SharesBroker.SharesBrokerWS sharesProxy = new SharesBroker.SharesBrokerWS();
            loadSectors();
            loadTable(sharesProxy.getCompanyShares());
        }

        protected void loadSectors()
        {
            SharesBroker.SharesBrokerWS sharesProxy = new SharesBroker.SharesBrokerWS();
            string[] sectors = sharesProxy.getCompanySymbols();
            for (int i = 0; i < sectors.Length; i++)
            {
                filterSector.Items.Add(new ListItem(sectors[i], sectors[i])) ;
            }
        }

        public void filter(object sender, EventArgs args)
        {

        }

        public void reset(object sender, EventArgs args)
        {

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

        public void resetTable(object sender, EventArgs args)
        {
            int rows = shares.Length;
            int i = 1;
            while (rows > 0)
            {
                sharesTable.Rows.Remove(sharesTable.Rows[i]);
                rows--;
            }
        }

    }
}
