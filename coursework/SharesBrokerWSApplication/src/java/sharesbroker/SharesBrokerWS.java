/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbroker;

import java.io.File;
import java.util.GregorianCalendar;
import java.util.List;
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
public class SharesBrokerWS {
    
    
    public XMLGregorianCalendar getCurrentGregorianTime() 
            throws DatatypeConfigurationException{
        GregorianCalendar gregCalendar = new GregorianCalendar();
        DatatypeFactory dataTypeFactory = DatatypeFactory.newInstance();
        return dataTypeFactory.newXMLGregorianCalendar(gregCalendar);
    }
    
    /**
     * This is a sample web service operation
     * @return currentCompanyShares
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
            File file = new File("/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/shares.xml");
            companyShares = (CompanyShares) unmarshaller.unmarshal(file);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return companyShares;
    }
    
    @WebMethod(operationName = "listAvailableShares")
    public int listAvailableShares(@WebParam(name = "companyName")String companyName) throws JAXBException {
        int availableShares = 0;
        List<ShareType> companyShares = listShares().getShares();
        for (ShareType share : companyShares) {
            if (share.getCompanyName().equals(companyName)){
                availableShares = share.getAvailableShares();
            }
        }
        return availableShares;
    }
    
    @WebMethod(operationName = "updateCompanyShare")
    public CompanyShares updateCompanyShare(
            @WebParam(name = "symbol") String symbol,
            @WebParam(name = "shares")int shares) throws JAXBException {
        CompanyShares updatedCompanyShares = listShares();
        List<ShareType> companyShares = updatedCompanyShares.getShares();
        for (ShareType share : companyShares) {
            if (share.getCompanySymbol().equals(symbol)) {
                share.setAvailableShares(shares);
            }
        }
        try {
            javax.xml.bind.JAXBContext jaxbCtx = 
                    javax.xml.bind.JAXBContext.newInstance(
                            companyShares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, 
                    Boolean.TRUE);
            System.out.println(
                    "Test - " + symbol + ": has  " + shares + " shares");
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return updatedCompanyShares;
    }
   
}
