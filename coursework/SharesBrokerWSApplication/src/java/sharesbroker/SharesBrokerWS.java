/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbroker;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author UBlavins
 */
@WebService(serviceName = "SharesBrokerWS")
@Stateless()
public class SharesBrokerWS {
    
    
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
            FileNotFoundException {
        CompanyShares updatedCompanyShares = listShares();
        List<ShareType> companyShares = updatedCompanyShares.getShares();
        for (ShareType share : companyShares) {
            if (symbol.equals(share.getCompanySymbol()))
                share.setAvailableShares(shares);
        }
        String filePath = 
                "/Users/UBlavins/Desktop/output.xml";
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
     * Web service operation that returns the FTSE sector of a company
     * 
     * Iterate through a list of company shares within 'share.xml'. Return the 
     * FTSE sector of a company based on the company 'symbol' provided as it 
     * acts as a UID.
     * 
     * @param symbol (String) the symbol for a company
     * @return companyFTSESector (String) the name of the FTSE Sector
     * @throws JAXBException
     */
    @WebMethod(operationName = "getCompanyFTSESector")
    public String getCompanyFTSESector(
            @WebParam(name = "symbol") String symbol) throws JAXBException {
        String companyFTSESector = new String();
        for (ShareType share : listShares().getShares()) {
            if (symbol.equals(share.getCompanySymbol())) 
                companyFTSESector = share.getCompanyFTSESector();
        }
        return companyFTSESector;
    }
    
    /**
     * Web service operation that returns a URL string for the logo of a company
     * 
     * Iterate through a list of company shares within 'share.xml'. Return the 
     * logo URL of a company based on the company 'symbol' provided as it 
     * acts as a UID.
     * 
     * @param symbol (String) the symbol for a company
     * @return companyLogo (String) the company logo URL
     * @throws JAXBException
     */
    @WebMethod(operationName = "getCompanyLogo")
    public String getCompanyLogo(
            @WebParam(name = "symbol") String symbol) throws JAXBException {
        String companyLogo = new String();
        for (ShareType share : listShares().getShares()) {
            if (symbol.equals(share.getCompanySymbol()))
                companyLogo = share.getCompanyLogo();
        }
        return companyLogo;
    }
    
    /**
     * Web service operation that returns the currency format for the shares of
     * a company.
     * 
     * Iterate through a list of company shares within 'share.xml'. Return the 
     * currency format of a company's shares based on the company 'symbol' 
     * provided as it acts as a UID.
     * 
     * @param symbol (String) the symbol for a company
     * @return currencyFormat (String) format of currency of a company share
     * @throws JAXBException
     */
    @WebMethod(operationName = "getCompanyShareCurrencyFormat")
    public String getCompanyShareCurrencyFormat(
            @WebParam(name = "symbol") String symbol) throws JAXBException {
        String currencyFormat = new String();
        for (ShareType share : listShares().getShares()) {
            if (symbol.equals(share.getCompanySymbol()))
                currencyFormat = share.getSharePrice().getCurrency();
        }
        return currencyFormat;
    }
    
    /**
     * Web service operation that returns the value of a company share.
     * 
     * Iterate through a list of company shares within 'share.xml'. Return the 
     * share value of a company based on the company 'symbol' provided as it 
     * acts as a UID.
     * 
     * @param symbol (String) the symbol for a company
     * @return shareValue (float) the value of a share for a company
     * @throws JAXBException
     */
    @WebMethod(operationName = "getCompanyShareValue")
    public float getCompanyShareValue(
            @WebParam(name = "symbol") String symbol) throws JAXBException {
        float shareValue = 0;
        for (ShareType share : listShares().getShares()) {
            if (symbol.equals(share.getCompanySymbol()))
                shareValue = share.getSharePrice().getValue();
        }
        return shareValue;
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
        
        ShareType newCompanyShare;
        CompanyShares currentCompanyShares = listShares();
        List<ShareType> companyShares = currentCompanyShares.getShares();
        
        for (ShareType share : companyShares) {
            if (symbol.equals(share.getCompanySymbol()))
                return currentCompanyShares;
        }
        
        newCompanyShare = new ShareType();
        newCompanyShare.setCompanySymbol(symbol);
        newCompanyShare.setCompanyName(company);
        newCompanyShare.setCompanyFTSESector(ftseSector);
        newCompanyShare.setCompanyLogo(logo);
        newCompanyShare.setAvailableShares(availableShares);
        ShareType.SharePrice sharePrice = new ShareType.SharePrice();
        sharePrice.setCurrency(currency);
        sharePrice.setValue(shareValue);
        sharePrice.setLastUpdated(getCurrentGregorianTime());
        newCompanyShare.setSharePrice(sharePrice);
        companyShares.add(newCompanyShare);
        
        String filePath = 
                "/Users/UBlavins/Desktop/output.xml";
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
        
        return currentCompanyShares;
    }
    
    // Searching Web Methods
    
    @WebMethod(operationName = "searchBySymbol")
    public List<ShareType> searchBySymbol(
            @WebParam(name = "symbol") String symbol) throws JAXBException {
        List<ShareType> symbols = new ArrayList<>();
        for (ShareType share : listShares().getShares()) {
            if (share.getCompanySymbol().contains(symbol)) symbols.add(share);
        }
        return symbols;
    }
    
    @WebMethod(operationName = "searchByName")
    public List<ShareType> searchByName(
            @WebParam(name = "name") String name) throws JAXBException {
        List<ShareType> names = new ArrayList<>();
        for (ShareType share : listShares().getShares()) {
            if (share.getCompanyName().contains(name)) names.add(share);
        }
        return names;
    }
    
    @WebMethod(operationName = "searchByFTSESector")
    public List<ShareType> searchByFTSESector(@WebParam(name = "ftseSector") 
            String ftseSector) throws JAXBException {
        List<ShareType> sectors = new ArrayList<>();
        for (ShareType share : listShares().getShares()) {
            if (ftseSector.equals(share.getCompanyFTSESector()))
                sectors.add(share);
        }
        return sectors;
    }
    
    @WebMethod(operationName = "searchByLowestSharePrice")
    public List<ShareType> searchByLowestSharePrice() throws JAXBException {
        ShareType share;
        List<ShareType> sharesLower = listShares().getShares();
        int shares = sharesLower.size();
        // Bubble sort
        for (int i = 0; i < shares; i++) {
            for (int j = 1; j < (shares - i); j++) {
                if (sharesLower.get(j-1).getSharePrice().getValue() > 
                    sharesLower.get(j).getSharePrice().getValue()) {
                    share = sharesLower.get(j-1);
                    sharesLower.set(j-1, sharesLower.get(j));
                    sharesLower.set(j, share);
                }
            }
        }
        return sharesLower;
    }
    
    @WebMethod(operationName = "searchByHighestSharePrice")
    public List<ShareType> searchByHighestSharePrice() throws JAXBException {
        ShareType share;
        List<ShareType> sharesLower = listShares().getShares();
        int shares = sharesLower.size();
        // Bubble sort
        for (int i = 0; i < shares; i++) {
            for (int j = 1; j < (shares - i); j++) {
                if (sharesLower.get(j-1).getSharePrice().getValue() < 
                    sharesLower.get(j).getSharePrice().getValue()) {
                    share = sharesLower.get(j-1);
                    sharesLower.set(j-1, sharesLower.get(j));
                    sharesLower.set(j, share);
                }
            }
        }
        return sharesLower;
    }
    
    @WebMethod(operationName = "searchBySharePriceRange")
    public List<ShareType> searchBySharePriceRange(
            @WebParam(name = "lowerBound") float lowerBound,
            @WebParam(name = "higherBound") float higherBound) 
            throws JAXBException {
        List<ShareType> shares = new ArrayList<>();
        for (ShareType share : listShares().getShares()) {
            if (share.getSharePrice().getValue() > lowerBound &&
                    share.getSharePrice().getValue() < higherBound)
                shares.add(share);
        }
        return shares;
    }
    
}
