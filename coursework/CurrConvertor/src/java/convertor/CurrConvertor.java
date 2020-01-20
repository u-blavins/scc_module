/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertor;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author UBlavins
 */
@WebService(serviceName = "CurrConvertor")
@Stateless()
public class CurrConvertor {

    /**
     * This is a sample web service operation
     */
    
    public JSONObject currentRates;
    
    public CurrConvertor() {
        currentRates = getLatestExchangeRates();
    }
    
    /** 
     * Method that returns CurrencyRates that are from storage. Used for offline
     * use if API times out.
     */
    @WebMethod(operationName="getLocalRates")
    public CurrencyRates getLocalRates() {
        CurrencyRates rates = new CurrencyRates();
        try {
            javax.xml.bind.JAXBContext jaxbContext = 
                    javax.xml.bind.JAXBContext.newInstance(
                            rates.getClass().getPackage().getName());
            javax.xml.bind.Unmarshaller unmarshaller = 
                    jaxbContext.createUnmarshaller();
            File file = new File(
                    "/Users/UBlavins/ntu_year3/scc_module/coursework/CurrConvertor/Files/rates.xml");
            rates = (CurrencyRates) unmarshaller.unmarshal(file);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
        return rates;
    }
    
    /**
     * Method that updates the conversion rates from an API and stored in XML
     * for a level of persistence.
     * @return updated (boolean) if the rates have been updated
     */
    @WebMethod(operationName="updateRates")
    public boolean updateRates() {
        boolean updated = false;
        JSONObject newRates = new JSONObject();
        try {
            newRates = getLatestExchangeRates();
            if (newRates!=null) {
                updated = true;
                currentRates = newRates;
            }
            saveToXml(currentRates);
        } catch (NullPointerException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.INFO, null, ex);
        }
        return updated;
    }
    
    private void saveToXml(JSONObject obj) {
        CurrencyRates rates = getLocalRates();
        for (CurrencyRate rate : rates.getRates()) {
            rate.setRate(
                Double.parseDouble(
                        obj.get(rate.getCurrencyCode()).toString()
                        ));
        }
        try {
            javax.xml.bind.JAXBContext jaxbContext = 
                    javax.xml.bind.JAXBContext.newInstance(
                            rates.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = 
                    jaxbContext.createMarshaller();
            File file = new File(
                    "/Users/UBlavins/ntu_year3/scc_module/coursework/CurrConvertor/Files/rates.xml");
            marshaller.marshal(rates, file);
        } catch (javax.xml.bind.JAXBException ex) {
            java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
    }
    
    private JSONObject getLatestExchangeRates() {
        JSONObject jobj = new JSONObject();
        try {
            String route = 
                    "http://data.fixer.io/api/latest?access_key=2659143600aef20857f455347368c5da";
            URL url = new URL(route);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            if (conn.getResponseCode() != 200) {
                conn.disconnect();
                throw new RuntimeException("HttpResponseCode: "+
                        conn.getResponseCode());
            } else {
                String response = "";
                Scanner sc = new Scanner(url.openStream());
                while (sc.hasNextLine()) {
                    response = sc.nextLine();
                }
                JSONParser parser = new JSONParser();
                jobj = (JSONObject)parser.parse(response);
                jobj = (JSONObject)jobj.get("rates");
                saveToXml(jobj);
                conn.disconnect();
            }
        } catch (Exception ex) {}  
        return jobj;
    }
    
    @WebMethod(operationName="getCurrCodes")
    public List<String> getCurrCodes() {
        List<String> codes = new ArrayList<>();
        try {
            for (Object keys : currentRates.keySet()) {
               codes.add(String.valueOf(keys));
            }
        } catch (Exception ex) {
            for (CurrencyRate rate : getLocalRates().getRates()) {
                codes.add(rate.getCurrencyCode());
            }
        }
        return codes;
    }
    
    @WebMethod(operationName="getConversionRate")
    public double getConversionRate(
            @WebParam(name="arg0")String arg0,
            @WebParam(name="arg1")String arg1) {
        double rate0 = 0;
        double rate1 = 0;
        try {
            rate0 = (double)currentRates.get(arg0);
            rate1 = (double)currentRates.get(arg1);
        } catch (Exception ex) {
            for (CurrencyRate rate : getLocalRates().getRates()) {
                if (rate.getCurrencyCode().equals(arg0))
                    rate0 = rate.getRate();
                if (rate.getCurrencyCode().equals(arg1))
                    rate1 = rate.getRate();
            }
        }
        return rate1/rate0;
    }
    
}
