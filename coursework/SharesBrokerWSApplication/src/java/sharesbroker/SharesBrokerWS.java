/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbroker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;

/**
 *
 * @author UBlavins
 */
@WebService(serviceName = "SharesBrokerWS")
public class SharesBrokerWS {

    /**
     * This is a sample web service operation
     * @return currentCompanyShares
     */
    @WebMethod(operationName="listShares")
    public CompanyShares listShares() {
        CompanyShares currentCompanyShares = new CompanyShares();
        
        try {
            javax.xml.bind.JAXBContext jaxbContext = 
                    javax.xml.bind.JAXBContext.newInstance(
                            currentCompanyShares.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = 
                    jaxbContext.createUnmarshaller();
            File file = new File("/Users/UBlavins/ntu_year3/scc_module/coursework/SharesBrokerWSApplication/Files/shares.xml");
            currentCompanyShares = (CompanyShares) unmarshaller.unmarshal(file);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return currentCompanyShares;
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
}
