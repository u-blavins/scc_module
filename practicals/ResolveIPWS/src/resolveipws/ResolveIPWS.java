/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolveipws;

import com.cdyne.ws.IPInformation;

/**
 *
 * @author UBlavins
 */
public class ResolveIPWS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String city;
        IPInformation myIP;
        
        myIP = resolveIP("216.58.212.99", "");
        city = myIP.getCity();
        
        System.out.println("City: " + city);
        System.out.println("Area Code: " + myIP.getAreaCode());
        System.out.println("Country: " + myIP.getCountry());
        System.out.println("Country Code: " + myIP.getCountryCode());
        System.out.println("Organisation: " + myIP.getOrganization());
        System.out.println("Region: " + myIP.getRegionName());
        System.out.println("State: " + myIP.getStateProvince());
        System.out.println("Time Zone: " + myIP.getTimeZone());
    }

    private static IPInformation resolveIP(java.lang.String ipAddress, java.lang.String licenseKey) {
        com.cdyne.ws.IP2Geo service = new com.cdyne.ws.IP2Geo();
        com.cdyne.ws.IP2GeoSoap port = service.getIP2GeoSoap12();
        return port.resolveIP(ipAddress, licenseKey);
    }
    
}
