/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbroker;

import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 *
 * @author UBlavins
 */
public class Main {
    public static void main(String[] args) throws DatatypeConfigurationException{
        shareOrder.CompanyShares companyShares = new shareOrder.CompanyShares();
        List<shareOrder.ShareType> latest_shares = companyShares.getShares();
        shareOrder.ShareType share;
        shareOrder.ShareType.SharePrice sharePrice;
        
        GregorianCalendar gregCalendar = new GregorianCalendar();
        DatatypeFactory datatypeFactory = DatatypeFactory.newInstance();
        XMLGregorianCalendar now = 
                datatypeFactory.newXMLGregorianCalendar(gregCalendar);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("LLOYDS GRP.");
        share.setCompanySymbol("LLOY");
        share.setCompanyFTSESector("Banks");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/087/0870612.gif");
        share.setAvailableShares(214869640);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float) 61.48);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("VODAFONE GRP.");
        share.setCompanySymbol("VOD");
        share.setCompanyFTSESector("Telecommunications Service Providers");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/bh4/bh4hks3.gif");
        share.setAvailableShares(60712110);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float) 142.74);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("EXPERIAN PLC");
        share.setCompanySymbol("EXPN");
        share.setCompanyFTSESector("Industrial Support Services");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/b19/b19nlv4.gif");
        share.setAvailableShares(1529816);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float) 2454.00);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("BP PLC");
        share.setCompanySymbol("BP");
        share.setCompanyFTSESector("Oil, Gas and Coal");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/079/0798059.gif");
        share.setAvailableShares(28922431);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float) 469.30);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("BT GRP.");
        share.setCompanySymbol("BT.A");
        share.setCompanyFTSESector("Telecommunications Service Providers");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/309/3091357.gif");
        share.setAvailableShares(24348195);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float) 188.70);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("TALK TALK");
        share.setCompanySymbol("TALK");
        share.setCompanyFTSESector("Telecommunications Service Providers");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/309/3091357.gifhttps://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/b4y/b4ycdf5.gif");
        share.setAvailableShares(918477);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float) 104.70);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("ASOS PLC");
        share.setCompanySymbol("ASC");
        share.setCompanyFTSESector("Retailers");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/309/3092725.gif");
        share.setAvailableShares(253747);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)2956.00);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("BOOHOO");
        share.setCompanySymbol("BOO");
        share.setCompanyFTSESector("Retailers");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/bg6/bg6l729.gif");
        share.setAvailableShares(6350925);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)266.70);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("ROYAL BANK OF SCOTLAND PLC");
        share.setCompanySymbol("RBS");
        share.setCompanyFTSESector("Banks");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/b7t/b7t7721.gif");
        share.setAvailableShares(17496969);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)229.30);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("BARCLAYS PLC");
        share.setCompanySymbol("BARC");
        share.setCompanyFTSESector("Banks");
        share.setCompanyLogo("");
        share.setAvailableShares(49665292);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)170.14);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("G4S");
        share.setCompanySymbol("GFS");
        share.setCompanyFTSESector("Industrial Support Services");
        share.setCompanyLogo("");
        share.setAvailableShares(2581928);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)206.90);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("SSE PLC");
        share.setCompanySymbol("SSE");
        share.setCompanyFTSESector("Electricity");
        share.setCompanyLogo("https://www.londonstockexchange.com/prices-and-markets/stocks/logos-companies/079/0790873.gif");
        share.setAvailableShares(3015864);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)1310.00);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        share = new shareOrder.ShareType();
        share.setCompanyName("Dixons Carphone PLC");
        share.setCompanySymbol("CD.");
        share.setCompanyFTSESector("");
        share.setCompanyLogo("");
        share.setAvailableShares(1);
        sharePrice = new shareOrder.ShareType.SharePrice();
        sharePrice.setCurrency("GBX");
        sharePrice.setValue((float)0.00);
        sharePrice.setLastUpdated(now);
        share.setSharePrice(sharePrice);
        latest_shares.add(share);
        
        try {
            javax.xml.bind.JAXBContext jaxbCtx = 
                    javax.xml.bind.JAXBContext.newInstance(companyShares.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(
                    javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(companyShares, System.out);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
