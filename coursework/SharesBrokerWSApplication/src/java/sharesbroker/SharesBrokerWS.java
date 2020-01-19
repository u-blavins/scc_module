/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbroker;

import docwebservices.CurrencyConversionWSService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.HttpURLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.WebServiceRef;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author UBlavins
 * @pi Z1A0W46XUK1WTUMY
 * @pi 440e71ff10cd41fa92ed3f5e68aac448
 */
@WebService(serviceName = "SharesBrokerWS")
@Stateless()
public class SharesBrokerWS {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/CurrencyConversionWSService/CurrencyConversionWS.wsdl")
    private CurrencyConversionWSService service;
    

    
    /**
     * Method that returns the current date and time in a format that is set 
     * XML.
     * 
     * @return (XMLGregorianCalendar) current date and time
     * @throws DatatypeConfigurationException 
     */
    private XMLGregorianCalendar getCurrentGregorianTime() 
            throws DatatypeConfigurationException{
        GregorianCalendar gregCalendar = new GregorianCalendar();
        DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
        return dataTypeFactory.newXMLGregorianCalendar(gregCalendar);
    }
    
    
    /**
     * Web service operation that lists share information on all companies
     * that are recorded on an external XML file
     *
     * Create a new object 'CompanyShares' and populate object with data 
     * from 'shares.xml' utilising JAXB Bind. Return CompanyShares object
     * containing current companies and share information.
     * 
     * @return currentCompanyShares (CompanyShares) updated company shares
     * @throws javax.xml.bind.JAXBException
     */
    @WebMethod(operationName="listShares")
    public CompanyShares listShares() throws JAXBException {
        CompanyShares companyShares = new CompanyShares();
        
        try {
            javax.xml.bind.JAXBContext jaxbContext = 
                    javax.xml.bind.JAXBContext.newInstance(
                            companyShares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = 
                    jaxbContext.createUnmarshaller();
            File file = new File(
                    "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/shares.xml");
            companyShares = (CompanyShares) unmarshaller.unmarshal(file);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return companyShares;
    }
    
    /**
     * Web service operation that updates the available shares of a company for
     * operations such as purchases, returns, or updates.
     * 
     * Traverse through a list of companies and update the available shares for
     * a company based on the company symbol (UID) provided as a parameter and
     * the amount of shares provided as another parameter. JAXB bind used to
     * marshal the update company shares into 'shares.xml' and also returned.
     * 
     * @param symbol (String) the symbol for a company
     * @param shares (int) the new number of shares for the company
     * @return updatedCompanyShares (CompanyShares) updated company shares
     * @throws JAXBException
     * @throws FileNotFoundException 
     */
    @WebMethod(operationName = "updateCompanyShare")
    public CompanyShares updateCompanyShare(
            @WebParam(name = "symbol") String symbol,
            @WebParam(name = "shares")int shares) throws JAXBException, 
            FileNotFoundException,
            DatatypeConfigurationException {
        CompanyShares updatedCompanyShares = listShares();
        List<ShareType> companyShares = updatedCompanyShares.getShares();
        for (ShareType share : companyShares) {
            if (symbol.equals(share.getCompanySymbol())) {
                share.setAvailableShares(shares);
            }
        }
        String filePath = 
                "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/shares.xml";
        FileOutputStream outFile = new FileOutputStream(filePath);
        try {
            javax.xml.bind.JAXBContext jaxbCtx = 
                    javax.xml.bind.JAXBContext.newInstance(
                        updatedCompanyShares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                    Boolean.TRUE);
            marshaller.marshal(updatedCompanyShares, outFile);
            System.out.println(
                    "Test - " + symbol + ": has  " + shares + " shares");
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return updatedCompanyShares;
    }
    
    /**
     * Web service operation that returns the number of available shares for a
     * company
     * 
     * Iterate through a list of company shares within 'share.xml'. Return the 
     * number of available shares of a company based on the company 'symbol'
     * provided as it acts as a UID.
     * 
     * @param symbol (String) the symbol for a company
     * @return availableShares (int) number of shares that a company has
     * @throws JAXBException 
     */
    @WebMethod(operationName = "getAvailableShares")
    public int getAvailableShares(@WebParam(name = "symbol")String symbol) 
            throws JAXBException {
        int availableShares = 0;
        for (ShareType share : listShares().getShares()) {
            if (symbol.equals(share.getCompanySymbol()))
                availableShares = share.getAvailableShares();
        }
        return availableShares;
    }
    
    /**
     * Web service operation that returns the name of a company
     * 
     * Iterate through a list of company shares within 'share.xml'. Return the 
     * name of a company based on the company 'symbol' provided as it acts as a 
     * UID.
     * 
     * @param symbol (String) the symbol for a company
     * @return companyName (String) name of the company
     * @throws JAXBException 
     */
    @WebMethod(operationName = "getCompanyName")
    public String getCompanyName(
            @WebParam(name = "symbol") String symbol) throws JAXBException {
        String companyName = new String();
        for (ShareType share : listShares().getShares()) {
            if (symbol.equals(share.getCompanySymbol()))
                companyName = share.getCompanyName();
        }
        return companyName;
    }
    
    /**
     * Web service operation that returns a list of all the company symbols that
     * are stored within the web service.
     * 
     * @return companySymbols (List<>) list of company symbols
     * @throws JAXBException 
     */
    @WebMethod(operationName = "getCompanySymbols")
    public List<String> getCompanySymbols() throws JAXBException {
        List<String> companySymbols = new ArrayList<>();
        for (ShareType share : listShares().getShares())
            companySymbols.add(share.getCompanySymbol());
        return companySymbols;
    }
    
    /**
     * Web service operation that returns a list of all the FTSE sectors that
     * are stored within the web service.
     * 
     * @return sectors (List<>) list of FTSE sectors
     * @throws JAXBException 
     */
    @WebMethod(operationName = "getFTSESectors")
    public List<String> getFTSESectors() throws JAXBException {
        List<String> sectors = new ArrayList<>();
        for (ShareType share : listShares().getShares()) {
            if (!sectors.contains(share.getCompanyFTSESector()) &&
                    !share.getCompanyFTSESector().isEmpty())
                sectors.add(share.getCompanyFTSESector());
        }
        return sectors;
    }
    
    /**
     * Web service operation that returns a list of all the company shares
     * 
     * @return listShares().getShares() (List<>) list of company shares
     * @throws JAXBException 
     */
    @WebMethod(operationName = "getCompanyShares")
    public List<ShareType> getCompanyShares() throws JAXBException {
        return listShares().getShares();
    }
    
    @WebMethod(operationName = "getShare")
    public ShareType getShare(
            @WebParam(name="symbol")String symbol) throws JAXBException {
        ShareType companyShare = new ShareType();
        for (ShareType share : getCompanyShares()) {
            if (symbol.equals(share.getCompanySymbol())) {
                companyShare = share;
            }
        }
        return companyShare;
    }
    
    /**
     * Web service operation that adds a new company to an XML file containing
     * a list of company share information.
     * 
     * @param symbol
     * @param company
     * @param ftseSector
     * @param logo
     * @param availableShares
     * @param currency
     * @param shareValue
     * @return currentCompanyShares (CompanyShares)
     * @throws javax.xml.bind.JAXBException 
     * @throws javax.xml.datatype.DatatypeConfigurationException 
     * @throws java.io.FileNotFoundException 
     */
    @WebMethod(operationName = "addNewCompany")
    public CompanyShares addNewCompany(
            @WebParam(name = "symbol") String symbol,
            @WebParam(name = "company") String company,
            @WebParam(name = "ftseSector") String ftseSector,
            @WebParam(name = "logo") String logo,
            @WebParam(name = "availableShares") int availableShares,
            @WebParam(name = "currency") String currency,
            @WebParam(name = "shareValue") float shareValue
            ) throws JAXBException, DatatypeConfigurationException, 
                FileNotFoundException {
        
        boolean isNewCompany = false;
        ShareType newCompanyShare;
        CompanyShares currentCompanyShares = listShares();
        List<ShareType> companyShares = currentCompanyShares.getShares();
        
        if (!symbol.equals("")) {
            if (!getCompanySymbols().contains(symbol)) {
                newCompanyShare = new ShareType();
                ShareType.SharePrice sharePrice = new ShareType.SharePrice();
                newCompanyShare.setCompanySymbol(symbol);
                newCompanyShare.setCompanyName(company);
                newCompanyShare.setCompanyFTSESector(ftseSector);
                newCompanyShare.setCompanyLogo(logo);
                try {
                    String realTimeShare = getRealTimeShares(symbol, "volume");
                    if (!realTimeShare.equals("")) {
                        newCompanyShare.setAvailableShares(
                            Integer.parseInt(realTimeShare));
                    } else {
                        newCompanyShare.setAvailableShares(
                            Integer.parseInt(realTimeShare));
                    }
                } catch (Exception ex) {}
                sharePrice.setCurrency(currency);
                try {
                    String realTimePrice = getRealTimeShares(symbol, "price");
                    if  (!realTimePrice.equals("")) {
                        sharePrice.setValue(Float.parseFloat(realTimePrice));
                    } else sharePrice.setValue(shareValue);
                } catch (Exception ex) {}
                sharePrice.setLastUpdated(getCurrentGregorianTime());
                newCompanyShare.setSharePrice(sharePrice);
                companyShares.add(newCompanyShare);
                isNewCompany = true;
            }
        }
        
        if (isNewCompany) {
            String filePath = 
                "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/shares.xml";
            FileOutputStream outFile = new FileOutputStream(filePath);
            try {
                javax.xml.bind.JAXBContext jaxbCtx = 
                        javax.xml.bind.JAXBContext.newInstance(
                            currentCompanyShares.getClass().getPackage().getName());
                javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                marshaller.setProperty(
                        javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
                marshaller.setProperty(
                        javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                        Boolean.TRUE);
                marshaller.marshal(currentCompanyShares, outFile);
            } catch (javax.xml.bind.JAXBException ex) {
                java.util.logging.Logger.getLogger("global").log(
                        java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        }   
        return currentCompanyShares;
    }
    
    @WebMethod(operationName="removeCompany")
    public CompanyShares removeCompany(
            @WebParam(name="companySymbol")String companySymbol) 
            throws JAXBException, FileNotFoundException {
        
        CompanyShares currentCompanyShares = listShares();
        CompanyShares newCompanyShares = new CompanyShares();
        List<ShareType> newShares = newCompanyShares.getShares();
        for (ShareType share : currentCompanyShares.getShares()) {
            if (!companySymbol.equals(share.getCompanySymbol())) {
                newShares.add(share);
            }
        }
        
        String filePath = 
                "/Users/UBlavins/Desktop/output.xml";
        FileOutputStream outFile = new FileOutputStream(filePath);
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = 
                    javax.xml.bind.JAXBContext.newInstance(
                        newCompanyShares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                    Boolean.TRUE);
            marshaller.marshal(newCompanyShares, outFile);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return newCompanyShares;
    }
    
    // Searching Web Methods
    
    @WebMethod(operationName = "searchBySymbol")
    public List<ShareType> searchBySymbol(
        @WebParam(name="symbol")String symbol,
        @WebParam(name="shares")List<ShareType> shares) {
            List<ShareType> symbols = new ArrayList<>();
            for (ShareType share : shares) {
                if (share.getCompanySymbol().contains(symbol))
                    symbols.add(share);
            }
            return symbols;
    }

    @WebMethod(operationName = "searchByName")
    public List<ShareType> searchByName(
        @WebParam(name="name")String name,
        @WebParam(name="shares")List<ShareType> shares) {
            List<ShareType> company = new ArrayList<>();
            for (ShareType share : shares) {
                if (share.getCompanyName().contains(name))
                    company.add(share);
            }
            return company;
    }

    @WebMethod(operationName = "searchByFTSESector")
    public List<ShareType> searchByFTSESector(
        @WebParam(name="sector")String sector,
        @WebParam(name="shares")List<ShareType> shares) {
            List<ShareType> sectors = new ArrayList<>();
            for (ShareType share : shares) {
                if (share.getCompanyFTSESector().contains(sector))
                    sectors.add(share);
            }
            return sectors;
    }

    @WebMethod(operationName = "searchByRange")
    public List<ShareType> searchByRange(
        @WebParam(name="min")float min,
        @WebParam(name="max")float max,
        @WebParam(name="shares")List<ShareType> shares){
            List<ShareType> ranged = new ArrayList<>();
            for (ShareType share : shares) {
                if (share.getSharePrice().getValue() > min &&
                        share.getSharePrice().getValue() < max)
                    ranged.add(share);
            }
            return ranged;
    }

    @WebMethod(operationName = "searchByLowest")
    public List<ShareType> searchByLowest(
        @WebParam(name="shares")List<ShareType> shares) throws JAXBException{
            shares.sort(
                    (a,b) -> (int)(a.getSharePrice().getValue() - b.getSharePrice().getValue()));
            return shares;
    }

    @WebMethod(operationName = "searchByHighest")
    public List<ShareType> searchByHighest(
        @WebParam(name="shares")List<ShareType> shares) throws JAXBException{
            shares.sort(
                    (a,b) -> (int)(b.getSharePrice().getValue() - a.getSharePrice().getValue()));
            return shares;
    }

    @WebMethod(operationName = "filterQuery")
    public List<ShareType> filterQuery(
        @WebParam(name="symbol")String symbol,
        @WebParam(name="name")String name,
        @WebParam(name="sector")String sector,
        @WebParam(name="filterPrice")String filterPrice,
        @WebParam(name="min")float min,
        @WebParam(name="max")float max) throws JAXBException {
            List<ShareType> shares = getCompanyShares();
            if(!symbol.equals("")) {
                shares = searchBySymbol(symbol, shares);
            }
            if(!name.equals("")) {
                shares = searchByName(name, shares);
            }
            if(!sector.equals("None")) {
                shares = searchByFTSESector(sector, shares);
            }
            if(min!=0 && max!=0) {
                shares = searchByRange(min, max, shares);
            } 
            if(!filterPrice.equals("None")){
                switch (filterPrice) {
                    case "Lowest":
                        shares = searchByLowest(shares);
                        break;
                    case "Highest":
                        shares = searchByHighest(shares);
                        break;
                }
            }
            return shares;
    }
    
    // Currency Conversion Methods
    
    private double getConversionRate(java.lang.String arg0, java.lang.String arg1) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        return port.getConversionRate(arg0, arg1);
    }
    
    @WebMethod(operationName = "getCurrencyCodes")
    public java.util.List<java.lang.String> getCurrencyCodes() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        docwebservices.CurrencyConversionWS port = service.getCurrencyConversionWSPort();
        List<String> currencys = port.getCurrencyCodes();
        List<String> codes = new ArrayList<>();        
        for (String currency : currencys ) {
            codes.add(currency.substring(0, 3));
        }
        return codes;
    }

    @WebMethod(operationName="getPriceByCurrency")
    public List<ShareType> getPriceByCurrency (
            @WebParam(name="newCurrencyCode")String newCurrencyCode,
            @WebParam(name="shares")List<ShareType> shares) {
        double rate;
        Map<String, Object> rates = new HashMap<String, Object>();
        for (ShareType share : shares) {
            try {
                rate = getConversionRate(share.getSharePrice().getCurrency(), 
                        newCurrencyCode);
                rates.put(share.getSharePrice().getCurrency(), rate);
                share.getSharePrice().setValue(
                        (float)(
                        (double)rates.get(share.getSharePrice().getCurrency())
                        * share.getSharePrice().getValue()));
                share.getSharePrice().setCurrency(newCurrencyCode);
            } catch (Exception ex) {
                
            }
        }
        return shares;
    }
    
    // User management
    
    @WebMethod(operationName="listUsers")
    private Users listUsers() throws JAXBException {
        Users newUsers = new Users();
        try {
            javax.xml.bind.JAXBContext jaxbContext = 
                    javax.xml.bind.JAXBContext.newInstance(
                            newUsers.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = 
                    jaxbContext.createUnmarshaller();
            File file = new File(
                    "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/users.xml");
            newUsers = (Users) unmarshaller.unmarshal(file);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return newUsers;
    }
    
    @WebMethod(operationName="getUser")
    public UserType getUser(
            @WebParam(name="username")String username) throws JAXBException {
        UserType user = new UserType();
        for (UserType userType : listUsers().getUsers()) {
            if (username.equals(userType.getUsername())) {
                user = userType;
            }
        }
        return user;
    }
    
    @WebMethod(operationName="registerUser")
    public boolean registerUser(
            @WebParam(name="username")String username,
            @WebParam(name="password")String password,
            @WebParam(name="conpassword")String conpassword
            ) throws JAXBException, FileNotFoundException {
        UserType newUser;
        Users currentUsers = listUsers();
        List<UserType> users = currentUsers.getUsers();
        
        if (password.equals(password)) {
            for (UserType user : users) {
                if (user.getUsername().equals(username)) {
                    return false;
                }
            }
            
            newUser = new UserType();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setIsAdmin(0);
            newUser.getUserShares();
            users.add(newUser);
            String filePath = 
                "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/users.xml";
            FileOutputStream outFile = new FileOutputStream(filePath);
            
            try {
                javax.xml.bind.JAXBContext jaxbCtx = 
                        javax.xml.bind.JAXBContext.newInstance(
                            currentUsers.getClass().getPackage().getName());
                javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
                marshaller.setProperty(
                        javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
                marshaller.setProperty(
                        javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                        Boolean.TRUE);
                marshaller.marshal(currentUsers, outFile);
            } catch (javax.xml.bind.JAXBException ex) {
                java.util.logging.Logger.getLogger("global").log(
                        java.util.logging.Level.SEVERE, null, ex); //NOI18N
            }
        }
        return true;
    }
    
    @WebMethod(operationName="loginUser")
    public boolean loginUser(
            @WebParam(name="username")String username,
            @WebParam(name="password")String password) throws JAXBException {
        for (UserType user : listUsers().getUsers()) {
            if (user.getUsername().equals(username) && 
                    user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    @WebMethod(operationName="purchaseShares")
    public Users purchaseShares(
            @WebParam(name="username")String username,
            @WebParam(name="companySymbol")String companySymbol,
            @WebParam(name="shares")int shares) throws JAXBException, 
            FileNotFoundException, DatatypeConfigurationException {
        
        Users currentUsers = listUsers();
        for (UserType user : currentUsers.getUsers()) {
            if (username.equals(user.getUsername())) {
                boolean hasShare = false;
                List<UserType.UserShares> userShares = user.getUserShares();
                for (UserType.UserShares userShare : userShares ) {
                    if (companySymbol.equals(userShare.getCompanySymbol())) {
                        int currShares = userShare.getCompanyShares();
                        userShare.setCompanyShares(shares + currShares);
                        hasShare = true;
                    }
                }
                if (!hasShare) {
                    UserType.UserShares userShare = new UserType.UserShares();
                    userShare.setCompanyShares(shares);
                    userShare.setCompanySymbol(companySymbol);
                    userShares.add(userShare);
                }
            }
        }
        int compShares = getAvailableShares(companySymbol) - shares;
        updateCompanyShare(companySymbol, compShares);
        
        String filePath = 
                "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/users.xml";
        FileOutputStream outFile = new FileOutputStream(filePath);

        try {
            javax.xml.bind.JAXBContext jaxbCtx = 
                    javax.xml.bind.JAXBContext.newInstance(
                        currentUsers.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                    Boolean.TRUE);
            marshaller.marshal(currentUsers, outFile);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

        return currentUsers;
    }
    
    @WebMethod(operationName="sellShares")
    public Users sellShares(
            @WebParam(name="username")String username,
            @WebParam(name="companySymbol")String companySymbol,
            @WebParam(name="shares")int shares) throws JAXBException, FileNotFoundException, DatatypeConfigurationException {
        
        Users currentUsers = listUsers();
        for (UserType user : currentUsers.getUsers()) {
            if (username.equals(user.getUsername())) {
                List<UserType.UserShares> userShares = user.getUserShares();
                for (UserType.UserShares userShare : userShares ) {
                    if (companySymbol.equals(userShare.getCompanySymbol())) {
                        if (userShare.getCompanyShares()-shares == 0 ||
                                userShare.getCompanyShares()-shares > 0){
                            int currShares = userShare.getCompanyShares()-shares;
                            userShare.setCompanyShares(currShares);
                            int compShares = getAvailableShares(companySymbol) +
                                    shares;
                            updateCompanyShare(companySymbol, compShares);
                        }
                    }
                }
            }
        }
        
        String filePath = 
                "/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/users.xml";
        FileOutputStream outFile = new FileOutputStream(filePath);

        try {
            javax.xml.bind.JAXBContext jaxbCtx = 
                   javax.xml.bind.JAXBContext.newInstance(
                        currentUsers.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                    Boolean.TRUE);
            marshaller.marshal(currentUsers, outFile);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        
        return currentUsers;
    }
    
    @WebMethod(operationName = "getUserShares")
    public List<UserType.UserShares> getUserShares(
            @WebParam(name="username")String username) throws JAXBException {
        List<UserType.UserShares> userShares = new ArrayList<>();
        for (UserType user : listUsers().getUsers()) {
            if (username.equals(user.getUsername())) {
                for (UserType.UserShares shares : user.getUserShares()) {
                    if (shares.getCompanyShares() != 0)
                        userShares.add(shares);
                }
            }
        } 
        return userShares;
    }
    
    // RESTful API
    
    @WebMethod(operationName="getRealTimeShares")
    public String getRealTimeShares(
            @WebParam(name="symbol")String symbol,
            @WebParam(name="query")String query) {
        String API_KEY = "Z1A0W46XUK1WTUMY";
        String function = "GLOBAL_QUOTE";
        String temp = "";
        try {
            String route = "https://www.alphavantage.co/query?function="+
                    function+"&symbol=LON:"+symbol+"&apikey="+API_KEY;
            URL url = new URL(route);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                throw new RuntimeException("HttpResponseCode: " + 
                        conn.getResponseCode());
            } else {
                String response = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNextLine()) {
                    response = sc.nextLine();
                    if (response.contains(query))
                        temp = response.split(":")[1];
                }
                temp = temp.substring(2, temp.length() - 2);
                conn.disconnect();
            }
        }catch (Exception ex) {
                        java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return temp;
    }
    
    @WebMethod(operationName="getRealTimeConversion")
    public double getRealTimeConversion(
            @WebParam(name="arg0")String arg0,
            @WebParam(name="arg1")String arg1) throws org.json.simple.parser.ParseException {
        String inline = new String();
        JSONObject liveResults = new JSONObject();
        String api_key = "";
        try {
            String route = "http://data.fixer.io/api/latest?access_key=" + api_key;
            URL url = new URL(route);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                throw new RuntimeException("HttpResponseCode: "+
                        conn.getResponseCode());
            } else {
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNextLine()) {
                    inline += sc.nextLine();
                }
                conn.disconnect();
            }
        } catch (Exception ex) {
            
        }
        JSONParser parse = new JSONParser();
        JSONObject jobj = (JSONObject) parse.parse(inline);
        liveResults = (JSONObject) jobj.get("rates");
        return (double)liveResults.get(arg1)/(double)liveResults.get(arg0);
    }
    
    @WebMethod(operationName="getStockNews")
    public List<String> getStockNews(
            @WebParam(name="symbol")String symbol){
        String sources = "reuters";
        List<String> test = new ArrayList<>();
        return test;
    }
    
}
