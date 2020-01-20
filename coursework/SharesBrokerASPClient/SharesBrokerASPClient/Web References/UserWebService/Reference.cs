//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace SharesBrokerASPClient.UserWebService {
    using System.Xml.Serialization;
    using System.Diagnostics;
    using System.Web.Services;
    using System.Web.Services.Protocols;
    using System.ComponentModel;
    using System;
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Web.Services.WebServiceBindingAttribute(Name="UserServicePortBinding", Namespace="http://userws/")]
    public partial class UserService : System.Web.Services.Protocols.SoapHttpClientProtocol {
        
        private System.Threading.SendOrPostCallback getUserOperationCompleted;
        
        private System.Threading.SendOrPostCallback registerUserOperationCompleted;
        
        private System.Threading.SendOrPostCallback loginUserOperationCompleted;
        
        private System.Threading.SendOrPostCallback purchaseSharesOperationCompleted;
        
        private System.Threading.SendOrPostCallback sellSharesOperationCompleted;
        
        private System.Threading.SendOrPostCallback getUserSharesOperationCompleted;
        
        /// <remarks/>
        public UserService() {
            this.Url = "http://localhost:8080/UserService/UserService";
        }
        
        public UserService(string url) {
            this.Url = url;
        }
        
        /// <remarks/>
        public event getUserCompletedEventHandler getUserCompleted;
        
        /// <remarks/>
        public event registerUserCompletedEventHandler registerUserCompleted;
        
        /// <remarks/>
        public event loginUserCompletedEventHandler loginUserCompleted;
        
        /// <remarks/>
        public event purchaseSharesCompletedEventHandler purchaseSharesCompleted;
        
        /// <remarks/>
        public event sellSharesCompletedEventHandler sellSharesCompleted;
        
        /// <remarks/>
        public event getUserSharesCompletedEventHandler getUserSharesCompleted;
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://userws/", ResponseNamespace="http://userws/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public userType getUser([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string username) {
            object[] results = this.Invoke("getUser", new object[] {
                        username});
            return ((userType)(results[0]));
        }
        
        /// <remarks/>
        public void getUserAsync(string username) {
            this.getUserAsync(username, null);
        }
        
        /// <remarks/>
        public void getUserAsync(string username, object userState) {
            if ((this.getUserOperationCompleted == null)) {
                this.getUserOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetUserOperationCompleted);
            }
            this.InvokeAsync("getUser", new object[] {
                        username}, this.getUserOperationCompleted, userState);
        }
        
        private void OngetUserOperationCompleted(object arg) {
            if ((this.getUserCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getUserCompleted(this, new getUserCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://userws/", ResponseNamespace="http://userws/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool registerUser([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string username, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string password, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string conpassword) {
            object[] results = this.Invoke("registerUser", new object[] {
                        username,
                        password,
                        conpassword});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void registerUserAsync(string username, string password, string conpassword) {
            this.registerUserAsync(username, password, conpassword, null);
        }
        
        /// <remarks/>
        public void registerUserAsync(string username, string password, string conpassword, object userState) {
            if ((this.registerUserOperationCompleted == null)) {
                this.registerUserOperationCompleted = new System.Threading.SendOrPostCallback(this.OnregisterUserOperationCompleted);
            }
            this.InvokeAsync("registerUser", new object[] {
                        username,
                        password,
                        conpassword}, this.registerUserOperationCompleted, userState);
        }
        
        private void OnregisterUserOperationCompleted(object arg) {
            if ((this.registerUserCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.registerUserCompleted(this, new registerUserCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://userws/", ResponseNamespace="http://userws/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public bool loginUser([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string username, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string password) {
            object[] results = this.Invoke("loginUser", new object[] {
                        username,
                        password});
            return ((bool)(results[0]));
        }
        
        /// <remarks/>
        public void loginUserAsync(string username, string password) {
            this.loginUserAsync(username, password, null);
        }
        
        /// <remarks/>
        public void loginUserAsync(string username, string password, object userState) {
            if ((this.loginUserOperationCompleted == null)) {
                this.loginUserOperationCompleted = new System.Threading.SendOrPostCallback(this.OnloginUserOperationCompleted);
            }
            this.InvokeAsync("loginUser", new object[] {
                        username,
                        password}, this.loginUserOperationCompleted, userState);
        }
        
        private void OnloginUserOperationCompleted(object arg) {
            if ((this.loginUserCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.loginUserCompleted(this, new loginUserCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://userws/", ResponseNamespace="http://userws/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlArrayAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        [return: System.Xml.Serialization.XmlArrayItemAttribute("users")]
        public userType[] purchaseShares([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string username, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string companySymbol, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] int shares) {
            object[] results = this.Invoke("purchaseShares", new object[] {
                        username,
                        companySymbol,
                        shares});
            return ((userType[])(results[0]));
        }
        
        /// <remarks/>
        public void purchaseSharesAsync(string username, string companySymbol, int shares) {
            this.purchaseSharesAsync(username, companySymbol, shares, null);
        }
        
        /// <remarks/>
        public void purchaseSharesAsync(string username, string companySymbol, int shares, object userState) {
            if ((this.purchaseSharesOperationCompleted == null)) {
                this.purchaseSharesOperationCompleted = new System.Threading.SendOrPostCallback(this.OnpurchaseSharesOperationCompleted);
            }
            this.InvokeAsync("purchaseShares", new object[] {
                        username,
                        companySymbol,
                        shares}, this.purchaseSharesOperationCompleted, userState);
        }
        
        private void OnpurchaseSharesOperationCompleted(object arg) {
            if ((this.purchaseSharesCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.purchaseSharesCompleted(this, new purchaseSharesCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://userws/", ResponseNamespace="http://userws/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlArrayAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        [return: System.Xml.Serialization.XmlArrayItemAttribute("users")]
        public userType[] sellShares([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string username, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string companySymbol, [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] int shares) {
            object[] results = this.Invoke("sellShares", new object[] {
                        username,
                        companySymbol,
                        shares});
            return ((userType[])(results[0]));
        }
        
        /// <remarks/>
        public void sellSharesAsync(string username, string companySymbol, int shares) {
            this.sellSharesAsync(username, companySymbol, shares, null);
        }
        
        /// <remarks/>
        public void sellSharesAsync(string username, string companySymbol, int shares, object userState) {
            if ((this.sellSharesOperationCompleted == null)) {
                this.sellSharesOperationCompleted = new System.Threading.SendOrPostCallback(this.OnsellSharesOperationCompleted);
            }
            this.InvokeAsync("sellShares", new object[] {
                        username,
                        companySymbol,
                        shares}, this.sellSharesOperationCompleted, userState);
        }
        
        private void OnsellSharesOperationCompleted(object arg) {
            if ((this.sellSharesCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.sellSharesCompleted(this, new sellSharesCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        [System.Web.Services.Protocols.SoapDocumentMethodAttribute("", RequestNamespace="http://userws/", ResponseNamespace="http://userws/", Use=System.Web.Services.Description.SoapBindingUse.Literal, ParameterStyle=System.Web.Services.Protocols.SoapParameterStyle.Wrapped)]
        [return: System.Xml.Serialization.XmlElementAttribute("return", Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public getUserSharesResponseReturn[] getUserShares([System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)] string username) {
            object[] results = this.Invoke("getUserShares", new object[] {
                        username});
            return ((getUserSharesResponseReturn[])(results[0]));
        }
        
        /// <remarks/>
        public void getUserSharesAsync(string username) {
            this.getUserSharesAsync(username, null);
        }
        
        /// <remarks/>
        public void getUserSharesAsync(string username, object userState) {
            if ((this.getUserSharesOperationCompleted == null)) {
                this.getUserSharesOperationCompleted = new System.Threading.SendOrPostCallback(this.OngetUserSharesOperationCompleted);
            }
            this.InvokeAsync("getUserShares", new object[] {
                        username}, this.getUserSharesOperationCompleted, userState);
        }
        
        private void OngetUserSharesOperationCompleted(object arg) {
            if ((this.getUserSharesCompleted != null)) {
                System.Web.Services.Protocols.InvokeCompletedEventArgs invokeArgs = ((System.Web.Services.Protocols.InvokeCompletedEventArgs)(arg));
                this.getUserSharesCompleted(this, new getUserSharesCompletedEventArgs(invokeArgs.Results, invokeArgs.Error, invokeArgs.Cancelled, invokeArgs.UserState));
            }
        }
        
        /// <remarks/>
        public new void CancelAsync(object userState) {
            base.CancelAsync(userState);
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://xml.netbeans.org/schema/Users")]
    public partial class userType {
        
        /// <remarks/>
        public string Username;
        
        /// <remarks/>
        public string Password;
        
        /// <remarks/>
        public int IsAdmin;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("UserShares")]
        public userTypeUserShares[] UserShares;
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://xml.netbeans.org/schema/Users")]
    public partial class userTypeUserShares {
        
        /// <remarks/>
        public string CompanySymbol;
        
        /// <remarks/>
        public int CompanyShares;
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(AnonymousType=true, Namespace="http://userws/")]
    public partial class getUserSharesResponseReturn {
        
        /// <remarks/>
        public string CompanySymbol;
        
        /// <remarks/>
        public int CompanyShares;
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    public delegate void getUserCompletedEventHandler(object sender, getUserCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getUserCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getUserCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public userType Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((userType)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    public delegate void registerUserCompletedEventHandler(object sender, registerUserCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class registerUserCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal registerUserCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    public delegate void loginUserCompletedEventHandler(object sender, loginUserCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class loginUserCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal loginUserCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public bool Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((bool)(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    public delegate void purchaseSharesCompletedEventHandler(object sender, purchaseSharesCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class purchaseSharesCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal purchaseSharesCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public userType[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((userType[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    public delegate void sellSharesCompletedEventHandler(object sender, sellSharesCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class sellSharesCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal sellSharesCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public userType[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((userType[])(this.results[0]));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    public delegate void getUserSharesCompletedEventHandler(object sender, getUserSharesCompletedEventArgs e);
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("XamarinStudio", "8.4.1.4")]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    public partial class getUserSharesCompletedEventArgs : System.ComponentModel.AsyncCompletedEventArgs {
        
        private object[] results;
        
        internal getUserSharesCompletedEventArgs(object[] results, System.Exception exception, bool cancelled, object userState) : 
                base(exception, cancelled, userState) {
            this.results = results;
        }
        
        /// <remarks/>
        public getUserSharesResponseReturn[] Result {
            get {
                this.RaiseExceptionIfNecessary();
                return ((getUserSharesResponseReturn[])(this.results[0]));
            }
        }
    }
}
