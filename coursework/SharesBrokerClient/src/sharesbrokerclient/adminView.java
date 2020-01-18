/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokerclient;

import java.util.logging.Level;
import java.util.logging.Logger;
import sharesbroker.AddNewCompanyResponse;
import sharesbroker.DatatypeConfigurationException_Exception;
import sharesbroker.FileNotFoundException_Exception;
import sharesbroker.JAXBException_Exception;

/**
 *
 * @author UBlavins
 */
public class adminView extends javax.swing.JFrame {
    
    private String user = "";
    
    /**
     * Creates new form adminView
     */
    public adminView(String username) {
        initComponents();
        user = username;
    }

    adminView() {
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
        logoutButton = new javax.swing.JButton();
        viewSharesButton = new javax.swing.JButton();
        usernameLabel = new javax.swing.JLabel();
        compLabel = new javax.swing.JLabel();
        compLabel1 = new javax.swing.JLabel();
        symbolText = new javax.swing.JTextField();
        compLabel2 = new javax.swing.JLabel();
        nameText = new javax.swing.JTextField();
        compLabel3 = new javax.swing.JLabel();
        logoText = new javax.swing.JTextField();
        compLabel4 = new javax.swing.JLabel();
        sharesText = new javax.swing.JTextField();
        compLabel5 = new javax.swing.JLabel();
        currencyText = new javax.swing.JTextField();
        compLabel6 = new javax.swing.JLabel();
        priceText = new javax.swing.JTextField();
        compLabel7 = new javax.swing.JLabel();
        sectorText = new javax.swing.JTextField();
        addCompanyButton = new javax.swing.JButton();
        notificationLabel = new javax.swing.JLabel();
        symbolCheckBox = new javax.swing.JComboBox();
        compLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 204, 204));

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        viewSharesButton.setText("View Shares");
        viewSharesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewSharesButtonActionPerformed(evt);
            }
        });

        usernameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(0, 0, 0));
        usernameLabel.setText("Admin Page");

        compLabel.setForeground(new java.awt.Color(0, 0, 0));
        compLabel.setText("New Company");

        compLabel1.setForeground(new java.awt.Color(0, 0, 0));
        compLabel1.setText("Symbol: ");

        compLabel2.setForeground(new java.awt.Color(0, 0, 0));
        compLabel2.setText("Name: ");

        compLabel3.setForeground(new java.awt.Color(0, 0, 0));
        compLabel3.setText("Logo: ");

        compLabel4.setForeground(new java.awt.Color(0, 0, 0));
        compLabel4.setText("Shares: ");

        compLabel5.setForeground(new java.awt.Color(0, 0, 0));
        compLabel5.setText("Currency:");

        compLabel6.setForeground(new java.awt.Color(0, 0, 0));
        compLabel6.setText("Price:");

        compLabel7.setForeground(new java.awt.Color(0, 0, 0));
        compLabel7.setText("FTSE Sector:");

        addCompanyButton.setText("Add Company");
        addCompanyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCompanyButtonActionPerformed(evt);
            }
        });

        notificationLabel.setForeground(new java.awt.Color(0, 0, 0));

        symbolCheckBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));

        compLabel8.setForeground(new java.awt.Color(0, 0, 0));
        compLabel8.setText("Update Company");

        jButton1.setText("Remove");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(viewSharesButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(logoutButton)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(compLabel)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(compLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(compLabel6)
                                        .addComponent(compLabel5)
                                        .addComponent(compLabel4)
                                        .addComponent(compLabel2)
                                        .addComponent(compLabel1)
                                        .addComponent(compLabel7))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(nameText)
                                        .addComponent(currencyText)
                                        .addComponent(sharesText)
                                        .addComponent(logoText)
                                        .addComponent(sectorText)
                                        .addComponent(symbolText)
                                        .addComponent(priceText, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(addCompanyButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(usernameLabel)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(notificationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(compLabel8)
                                    .addComponent(symbolCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))))
                        .addGap(0, 200, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(viewSharesButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel)
                    .addComponent(compLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel1)
                    .addComponent(symbolText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(symbolCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(compLabel2)
                    .addComponent(jButton1))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel7)
                    .addComponent(sectorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel3)
                    .addComponent(logoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel4)
                    .addComponent(sharesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel5)
                    .addComponent(currencyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(compLabel6)
                    .addComponent(priceText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCompanyButton)
                    .addComponent(notificationLabel))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        login loginFrame = new login();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void viewSharesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewSharesButtonActionPerformed

        try {
            shares sharesFrame = new shares(user);
            sharesFrame.setVisible(true);
            this.dispose();
        } catch (JAXBException_Exception ex) {
            Logger.getLogger(adminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_viewSharesButtonActionPerformed

    private void addCompanyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCompanyButtonActionPerformed
        // TODO add your handling code here:
        String symbol = symbolText.getText();
        String companyName = nameText.getText();
        String sector = sectorText.getText();
        String logo = logoText.getText();
        String shares = sharesText.getText();
        String currency = currencyText.getText();
        String price = priceText.getText();
        
        if (!symbol.equals("") && !companyName.equals("") && !sector.equals("")
                && !shares.equals("") && !currency.equals("") && !price.equals("")) {
            try {
                int companyShares = Integer.parseInt(shares);
                float sharePrice = Float.parseFloat(price);
                addNewCompany(symbol, companyName, sector, logo, companyShares,
                        currency, sharePrice);
                symbolText.setText("");
                nameText.setText("");
                sectorText.setText("");
                logoText.setText("");
                sharesText.setText("");
                currencyText.setText("");
                priceText.setText("");
            } catch (NumberFormatException ex) {
                notificationLabel.setText("Please enter numbers");
            } catch (FileNotFoundException_Exception | JAXBException_Exception | 
                    DatatypeConfigurationException_Exception ex) {
                Logger.getLogger(adminView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            notificationLabel.setText("Please fill all boxes");
        }
        
    }//GEN-LAST:event_addCompanyButtonActionPerformed

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
            java.util.logging.Logger.getLogger(adminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(adminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(adminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(adminView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new adminView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCompanyButton;
    private javax.swing.JLabel compLabel;
    private javax.swing.JLabel compLabel1;
    private javax.swing.JLabel compLabel2;
    private javax.swing.JLabel compLabel3;
    private javax.swing.JLabel compLabel4;
    private javax.swing.JLabel compLabel5;
    private javax.swing.JLabel compLabel6;
    private javax.swing.JLabel compLabel7;
    private javax.swing.JLabel compLabel8;
    private javax.swing.JTextField currencyText;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField logoText;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField nameText;
    private javax.swing.JLabel notificationLabel;
    private javax.swing.JTextField priceText;
    private javax.swing.JTextField sectorText;
    private javax.swing.JTextField sharesText;
    private javax.swing.JComboBox symbolCheckBox;
    private javax.swing.JTextField symbolText;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JButton viewSharesButton;
    // End of variables declaration//GEN-END:variables

    private static AddNewCompanyResponse.Return addNewCompany(java.lang.String symbol, java.lang.String company, java.lang.String ftseSector, java.lang.String logo, int availableShares, java.lang.String currency, float shareValue) throws FileNotFoundException_Exception, JAXBException_Exception, DatatypeConfigurationException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.addNewCompany(symbol, company, ftseSector, logo, availableShares, currency, shareValue);
    }
}
