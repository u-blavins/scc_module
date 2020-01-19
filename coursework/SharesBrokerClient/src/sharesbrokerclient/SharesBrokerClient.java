/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokerclient;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author UBlavins
 */
public class SharesBrokerClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String route = "https://api.exchangeratesapi.io/latest";
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
                    System.out.println(response);
                }
                conn.disconnect();
            }
        } catch (Exception ex) {
            
        }
    }
    
    public void alphvantageApi() {
        String symbol = "LLOY";
        String API_KEY = "Z1A0W46XUK1WTUMY";
        String function = "GLOBAL_QUOTE";
        String price = "", totShares = "";
        String output = "";
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
                    if (response.split(":")[0].contains("price"))
                        price = response.split(":")[1];
                    if (response.split(":")[0].contains("volume"))
                        totShares = response.split(":")[1];
                }
                price = price.substring(2, price.length()-2);
                totShares = totShares.substring(2, totShares.length()-2);
                System.out.println(price);
                System.out.println(totShares);
                conn.disconnect();
            }
        }catch (Exception ex) {
                        java.util.logging.Logger.getLogger("global").log(
                    java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }
    }
    
}
