/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.ws.WebServiceRef;
import sharesbroker.DatatypeConfigurationException_Exception;
import sharesbroker.FileNotFoundException_Exception;
import sharesbroker.JAXBException_Exception;
import sharesbroker.SharesBrokerWS_Service;
import sharesbroker.UpdateCompanyShareResponse;

/**
 *
 * @author UBlavins
 */
@WebService(serviceName = "UserService")
@Stateless()
public class UserService {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SharesBrokerWS/SharesBrokerWS.wsdl")
    private SharesBrokerWS_Service service;
    
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
        int compShares;
        try {
            compShares = getAvailableShares(companySymbol) - shares;
            updateCompanyShare(companySymbol, compShares);
        } catch (FileNotFoundException_Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException_Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException_Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
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
                            int compShares;
                            try {
                                compShares = getAvailableShares(companySymbol) +
                                    shares;
                                updateCompanyShare(companySymbol, compShares);
                            } catch (FileNotFoundException_Exception ex) {
                                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (DatatypeConfigurationException_Exception ex) {
                                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (JAXBException_Exception ex) {
                                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                            }
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

    private UpdateCompanyShareResponse.Return updateCompanyShare(java.lang.String symbol, int shares) throws FileNotFoundException_Exception, DatatypeConfigurationException_Exception, JAXBException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.updateCompanyShare(symbol, shares);
    }

    private int getAvailableShares(java.lang.String symbol) throws JAXBException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getAvailableShares(symbol);
    }

}
