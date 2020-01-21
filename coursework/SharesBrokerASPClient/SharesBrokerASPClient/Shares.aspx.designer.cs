using System;
using System.Web;
using System.Web.UI;

namespace SharesBrokerASPClient
{

    public partial class Shares
    {
		protected System.Web.UI.HtmlControls.HtmlForm filterForm;

		protected System.Web.UI.WebControls.Table filterTable;

		protected System.Web.UI.WebControls.Button filterButton;

		protected System.Web.UI.WebControls.Button resetFilterButton;

		protected System.Web.UI.WebControls.TextBox filterSymbol;

		protected System.Web.UI.WebControls.TextBox filterCompany;

		protected System.Web.UI.WebControls.TextBox filterMin;

		protected System.Web.UI.WebControls.TextBox filterMax;

		protected System.Web.UI.WebControls.DropDownList filterSector;

		protected System.Web.UI.WebControls.DropDownList filterPrice;

		protected System.Web.UI.WebControls.DropDownList currencyCodes;

		protected System.Web.UI.HtmlControls.HtmlForm sharesForm;

		protected System.Web.UI.WebControls.Table sharesTable;

		protected System.Web.UI.WebControls.Label notificationLabel;

		protected System.Web.UI.HtmlControls.HtmlForm transactionsForm;

		protected System.Web.UI.WebControls.DropDownList filterSymbols;
	}
}
