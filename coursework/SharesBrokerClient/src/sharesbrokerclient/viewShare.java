/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokerclient;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.netbeans.xml.schema.shares.ShareType;
import sharesbroker.JAXBException_Exception;
import userws.PurchaseSharesResponse;

/**
 *
 * @author UBlavins
 */
public class viewShare extends javax.swing.JFrame {
    
    private String user = "";
    private ShareType share;
    private boolean updateVolume = false;

    /**
     * Creates new form viewShare
     */
    public viewShare(String username, String symbol) throws JAXBException_Exception {
        initComponents();
        user = username;
        share = getShare(symbol);
        loadShare();
    }
    
    private void loadShare() {
        symbolDataLabel.setText(share.getCompanySymbol());
        companyDataLabel.setText(share.getCompanyName());
        sectorDataLabel.setText(share.getCompanyFTSESector());
        sharesDataLabel.setText(String.valueOf(share.getAvailableShares()));
        currencyDataLabel.setText(share.getSharePrice().getCurrency());
        priceDataLabel.setText(String.valueOf(share.getSharePrice().getValue()));
        try {
            BufferedImage logo = ImageIO.read(new URL(share.getCompanyLogo()));
            imageLabel.setIcon(new javax.swing.ImageIcon(logo));
        } catch(IOException ex) {
            System.out.println(ex);
        }
    }

    viewShare() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        symbolDataLabel = new javax.swing.JLabel();
        compLabel = new javax.swing.JLabel();
        sectorLabel = new javax.swing.JLabel();
        shareLabel = new javax.swing.JLabel();
        currencyLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        logoutButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        companyDataLabel = new javax.swing.JLabel();
        sectorDataLabel = new javax.swing.JLabel();
        sharesDataLabel = new javax.swing.JLabel();
        currencyDataLabel = new javax.swing.JLabel();
        priceDataLabel = new javax.swing.JLabel();
        updateShareButton = new javax.swing.JButton();
        currentPriceButton = new javax.swing.JButton();
        buySharesButton = new javax.swing.JButton();
        buyTextArea = new javax.swing.JTextField();
        buyShareLabel = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(179, 204, 204));

        symbolDataLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        symbolDataLabel.setForeground(new java.awt.Color(0, 0, 0));
        symbolDataLabel.setText("COMP SYMBOL");

        compLabel.setForeground(new java.awt.Color(0, 0, 0));
        compLabel.setText("Company Name: ");

        sectorLabel.setForeground(new java.awt.Color(0, 0, 0));
        sectorLabel.setText("FTSE Sector: ");

        shareLabel.setForeground(new java.awt.Color(0, 0, 0));
        shareLabel.setText("Available Shares: ");

        currencyLabel.setForeground(new java.awt.Color(0, 0, 0));
        currencyLabel.setText("Current Currency: ");

        priceLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceLabel.setText("Current Price: ");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        companyDataLabel.setForeground(new java.awt.Color(0, 0, 0));
        companyDataLabel.setText("company");

        sectorDataLabel.setForeground(new java.awt.Color(0, 0, 0));
        sectorDataLabel.setText("sector");

        sharesDataLabel.setForeground(new java.awt.Color(0, 0, 0));
        sharesDataLabel.setText("shares");

        currencyDataLabel.setForeground(new java.awt.Color(0, 0, 0));
        currencyDataLabel.setText("currency");

        priceDataLabel.setForeground(new java.awt.Color(0, 0, 0));
        priceDataLabel.setText("price");

        updateShareButton.setText("Get Shares");
        updateShareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateShareButtonActionPerformed(evt);
            }
        });

        currentPriceButton.setText("Get Price");
        currentPriceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                currentPriceButtonActionPerformed(evt);
            }
        });

        buySharesButton.setText("Buy Shares");
        buySharesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySharesButtonActionPerformed(evt);
            }
        });

        buyShareLabel.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(updateShareButton)
                                .addGap(18, 18, 18)
                                .addComponent(currentPriceButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                                .addComponent(buyShareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buyTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buySharesButton))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(symbolDataLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(sectorLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(compLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(shareLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(currencyLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(companyDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(imageLabel)
                                        .addGap(180, 180, 180))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(sectorDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(282, 282, 282))
                                    .addComponent(sharesDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(currencyDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(priceDataLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(backButton))
                .addGap(22, 22, 22)
                .addComponent(symbolDataLabel)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel)
                    .addComponent(companyDataLabel)
                    .addComponent(imageLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sectorLabel)
                    .addComponent(sectorDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(shareLabel)
                    .addComponent(sharesDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currencyLabel)
                    .addComponent(currencyDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLabel)
                    .addComponent(priceDataLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateShareButton)
                    .addComponent(currentPriceButton)
                    .addComponent(buySharesButton)
                    .addComponent(buyTextArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buyShareLabel))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        login loginFrame = new login();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        try {
            // TODO add your handling code here:
            shares shareFrame = new shares(user);
            shareFrame.setVisible(true);
            this.dispose();
        } catch (JAXBException_Exception ex) {
            Logger.getLogger(viewShare.class.getName()).log(Level.SEVERE, null, ex);
        } catch (userws.JAXBException_Exception ex) {
            Logger.getLogger(viewShare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    private void updateShareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateShareButtonActionPerformed
        // TODO add your handling code here:
        String newShares = "";
        try {
            newShares = getRealTimeShares(share.getCompanySymbol(), "volume");
        } catch (Exception ex) {
            System.out.println("(UpdateShare) Exception: " + ex);
        }
        if (!newShares.equals("")) {
            updateVolume = true;
            sharesDataLabel.setText(newShares);
        }
    }//GEN-LAST:event_updateShareButtonActionPerformed

    private void currentPriceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_currentPriceButtonActionPerformed
        // TODO add your handling code here:
        String newPrice = "";
        try {
            newPrice = getRealTimeShares(share.getCompanySymbol(), "price");
            priceDataLabel.setText(newPrice);
        } catch(Exception ex){
            System.out.println(ex);
        }
        if (!newPrice.equals("")) {
            updateVolume = true;
        }
    }//GEN-LAST:event_currentPriceButtonActionPerformed

    private void buySharesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySharesButtonActionPerformed
        // TODO add your handling code here:
        String shares = buyTextArea.getText().toString();
        if (!shares.equals("")) {
            try {
                int buyShares = Integer.parseInt(shares);
                purchaseShares(user, share.getCompanySymbol(), buyShares);
                share = getShare(share.getCompanySymbol());
                loadShare();
            } catch (NumberFormatException ex) {
                buyShareLabel.setText("Number not provided");
            } catch (JAXBException_Exception | 
                    userws.DatatypeConfigurationException_Exception | 
                    userws.JAXBException_Exception | 
                    userws.FileNotFoundException_Exception ex) {
                Logger.getLogger(viewShare.class.getName()).log(
                        Level.SEVERE, null, ex);
            }
            
        } else {
            buyShareLabel.setText("Amount not given");
        }
    }//GEN-LAST:event_buySharesButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(viewShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(viewShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(viewShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(viewShare.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new viewShare().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JLabel buyShareLabel;
    private javax.swing.JButton buySharesButton;
    private javax.swing.JTextField buyTextArea;
    private javax.swing.JLabel compLabel;
    private javax.swing.JLabel companyDataLabel;
    private javax.swing.JLabel currencyDataLabel;
    private javax.swing.JLabel currencyLabel;
    private javax.swing.JButton currentPriceButton;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel priceDataLabel;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JLabel sectorDataLabel;
    private javax.swing.JLabel sectorLabel;
    private javax.swing.JLabel shareLabel;
    private javax.swing.JLabel sharesDataLabel;
    private javax.swing.JLabel symbolDataLabel;
    private javax.swing.JButton updateShareButton;
    // End of variables declaration//GEN-END:variables

    private static String getRealTimeShares(java.lang.String symbol, java.lang.String query) {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getRealTimeShares(symbol, query);
    }

    private static ShareType getShare(java.lang.String symbol) throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getShare(symbol);
    }

    private static PurchaseSharesResponse.Return purchaseShares(java.lang.String username, java.lang.String companySymbol, int shares) throws userws.DatatypeConfigurationException_Exception, userws.JAXBException_Exception, userws.FileNotFoundException_Exception {
        userws.UserService_Service service = new userws.UserService_Service();
        userws.UserService port = service.getUserServicePort();
        return port.purchaseShares(username, companySymbol, shares);
    }
}
