/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author UBlavins
 */
public class BuyingSharesThread extends Thread {
    private int sharesBought = 0;
    private final long frequency = 200;
    
    public void run() {
        while (sharesBought<10) {
            if (Shares.shareprice>=20) {
                System.out.println("Share bought: " + Shares.shareprice);
                sharesBought++;
            }
            try {
                this.sleep(frequency);
            } catch(java.lang.InterruptedException ie){}
        }
    }
}
