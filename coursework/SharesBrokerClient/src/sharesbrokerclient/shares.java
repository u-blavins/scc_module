/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokerclient;


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import org.netbeans.xml.schema.users.UserType;
import sharesbroker.JAXBException_Exception;
import org.netbeans.xml.schema.shares.ShareType;

/**
 *
 * @author UBlavins
 */
public class shares extends javax.swing.JFrame {
    
    private List<ShareType> currShares;
    private UserType user;
    private boolean currencySet = false;
    
    /**
     * Creates new form shares
     * @throws sharesbroker.JAXBException_Exception
     */
    public shares(String username) throws JAXBException_Exception, userws.JAXBException_Exception {
        initComponents();
        user = getUser(username);
        if (user.getIsAdmin()==0) {
            adminButton.setVisible(false);
        }
        loadTable(getCompanyShares());
        loadSectors();
        loadCodes();
        loadSymbols();
    }

    private shares() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void loadSectors() throws JAXBException_Exception {
        for (String symbol : getFTSESectors()) {
            sectorText.addItem(symbol);
        }
    }
    
    public void loadCodes() {
        for (String code : getCurrencyCodes()) {
            currencyCodesBox.addItem(code);
        }
    }
    
    public void loadSymbols() throws JAXBException_Exception {
        for (String code : getCompanySymbols()) {
            symbolsBox.addItem(code);
        } 
    }
    
    public void loadTable(List<ShareType> shares) {
        currShares = shares;
        DefaultTableModel model = (DefaultTableModel)sharesTable.getModel();
        Object[] row = new Object[7];
        for (ShareType share : shares) {
            row[0] = share.getCompanySymbol();
            row[1] = share.getCompanyName();
            row[2] = share.getAvailableShares();
            row[3] = share.getCompanyFTSESector();
            row[4] = share.getSharePrice().getCurrency();
            row[5] = share.getSharePrice().getValue();
            row[6] = convertDate(
                    String.valueOf(share.getSharePrice().getLastUpdated()));
            model.addRow(row);
        }
        
    }
    
    private String convertDate(String date) {
        return date.split("T")[0];
    }
    
    public void removeData() {
        ((DefaultTableModel)sharesTable.getModel()).setRowCount(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        priceFilter1 = new javax.swing.JComboBox();
        sectorText1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        messageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sharesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        filterButton = new javax.swing.JButton();
        symbolText = new javax.swing.JTextField();
        companyText = new javax.swing.JTextField();
        maxText = new javax.swing.JTextField();
        minText = new javax.swing.JTextField();
        priceFilter = new javax.swing.JComboBox();
        sectorText = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        resetFilterButton = new javax.swing.JButton();
        changeCodeButton = new javax.swing.JButton();
        currencyCodesBox = new javax.swing.JComboBox();
        logoutButton = new javax.swing.JButton();
        profileButton = new javax.swing.JButton();
        adminButton = new javax.swing.JButton();
        symbolsBox = new javax.swing.JComboBox();
        buySharesButton = new javax.swing.JButton();

        priceFilter1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Lowest", "Highest" }));

        sectorText1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        sectorText1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectorText1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 204, 204));
        jPanel1.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Shares Broker");

        sharesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Symbol", "Company", "Available Shares", "FTSE Sector", "Currency", "Price", "Last Updated"
            }
        ));
        jScrollPane1.setViewportView(sharesTable);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Symbol");

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Company Name");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("FTSE Sector");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Price Range");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Filter");

        filterButton.setText("Filter");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        maxText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxTextActionPerformed(evt);
            }
        });

        minText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minTextActionPerformed(evt);
            }
        });

        priceFilter.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Lowest", "Highest" }));

        sectorText.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));
        sectorText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sectorTextActionPerformed(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Change Currency");

        resetFilterButton.setText("Reset");
        resetFilterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetFilterButtonActionPerformed(evt);
            }
        });

        changeCodeButton.setText("Change");
        changeCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeCodeButtonActionPerformed(evt);
            }
        });

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        profileButton.setText("View Profie");
        profileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileButtonActionPerformed(evt);
            }
        });

        adminButton.setText("Admin Portal");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        symbolsBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None" }));

        buySharesButton.setText("Buy Shares");
        buySharesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buySharesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(adminButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(logoutButton)
                .addGap(493, 493, 493))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(symbolText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(companyText))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sectorText, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jLabel5)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(75, 75, 75)
                                        .addComponent(jLabel6)
                                        .addGap(89, 89, 89)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(priceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(resetFilterButton)
                                        .addGap(10, 10, 10)
                                        .addComponent(currencyCodesBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(changeCodeButton))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(filterButton)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel8)))
                                .addGap(48, 48, 48))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 961, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)))
                        .addComponent(jLabel4)
                        .addGap(466, 466, 466)
                        .addComponent(messageLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(467, 467, 467)
                        .addComponent(symbolsBox, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buySharesButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logoutButton)
                    .addComponent(profileButton))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(adminButton)
                    .addComponent(jLabel3))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(247, 247, 247)
                        .addComponent(messageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel1)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(symbolText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(companyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(priceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sectorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(changeCodeButton)
                                            .addComponent(currencyCodesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(filterButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(resetFilterButton)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(symbolsBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buySharesButton))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1065, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sectorTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectorTextActionPerformed

    }//GEN-LAST:event_sectorTextActionPerformed

    private void minTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_minTextActionPerformed

    private void maxTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxTextActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        // TODO add your handling code here:
        
        String symbol = symbolText.getText();
        String company = companyText.getText();
        String sector = sectorText.getSelectedItem().toString();
        String filterPrice = priceFilter.getSelectedItem().toString();
        String minStr = minText.getText();
        String maxStr = maxText.getText();
        
        if (symbol.equals("") && company.equals("") && sector.equals("None") 
                && filterPrice.equals("None") && maxStr.equals("") && minStr.equals("")) {
            removeData();
            try {
                if (currencySet){ 
                    String code = currencyCodesBox.getSelectedItem().toString();
                    List<ShareType> shares = getPriceByCurrency(code, getCompanyShares());
                    loadTable(shares);
                } else {
                    loadTable(getCompanyShares());
                }
            } catch (JAXBException_Exception ex) {
                Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            float min = 0;
            float max = 0;
            
            try {
                min = Float.parseFloat(minStr);
                max = Float.parseFloat(maxStr);
            } catch (Exception ex) {
                System.out.println(ex);
            }
            
            try {
                List<ShareType> shares = getCompanyShares();
                if (currencySet) {
                    String code = currencyCodesBox.getSelectedItem().toString();
                    shares = getPriceByCurrency(code, shares);
                }
                List<ShareType> filterShares = filterQuery(symbol, company, sector,
                        filterPrice, min, max, shares);
                removeData();
                loadTable(filterShares);
            } catch (JAXBException_Exception ex) {
                Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filterButtonActionPerformed

    private void resetFilterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetFilterButtonActionPerformed
        // TODO add your handling code here:
        symbolText.setText(null);
        companyText.setText(null);
        minText.setText(null);
        maxText.setText(null);
    }//GEN-LAST:event_resetFilterButtonActionPerformed

    private void changeCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeCodeButtonActionPerformed
        // TODO add your handling code here:
        currencySet = true;
        String code = currencyCodesBox.getSelectedItem().toString();
        List<ShareType> shares = getPriceByCurrency(code, currShares);
        removeData();
        loadTable(shares);
    }//GEN-LAST:event_changeCodeButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        // TODO add your handling code here:
        login loginFrame = new login();
        loginFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void profileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileButtonActionPerformed
        try {
            // TODO add your handling code here:
            viewProfile profileFrame = new viewProfile(user.getUsername());
            profileFrame.setVisible(true);
            this.dispose();
        } catch (JAXBException_Exception ex) {
            Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_profileButtonActionPerformed

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        // TODO add your handling code here:
        adminView adminFrame;
        try {
            adminFrame = new adminView(user.getUsername());
            adminFrame.setVisible(true);
            this.dispose();
        } catch (JAXBException_Exception ex) {
            Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_adminButtonActionPerformed

    private void sectorText1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sectorText1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sectorText1ActionPerformed

    private void buySharesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buySharesButtonActionPerformed
        // TODO add your handling code here:
        String symbol = symbolsBox.getSelectedItem().toString();
        if (!symbol.equals("None")) {
            viewShare viewShareFrame;
            try {
                viewShareFrame = new viewShare(user.getUsername(), symbol);
                viewShareFrame.setVisible(true);
                this.dispose();
            } catch (JAXBException_Exception ex) {
                Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            java.util.logging.Logger.getLogger(shares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(shares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(shares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(shares.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new shares().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JButton buySharesButton;
    private javax.swing.JButton changeCodeButton;
    private javax.swing.JTextField companyText;
    private javax.swing.JComboBox currencyCodesBox;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField maxText;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField minText;
    private javax.swing.JComboBox priceFilter;
    private javax.swing.JComboBox priceFilter1;
    private javax.swing.JButton profileButton;
    private javax.swing.JButton resetFilterButton;
    private javax.swing.JComboBox sectorText;
    private javax.swing.JComboBox sectorText1;
    private javax.swing.JTable sharesTable;
    private javax.swing.JTextField symbolText;
    private javax.swing.JComboBox symbolsBox;
    // End of variables declaration//GEN-END:variables

//    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> getCompanyShares() throws JAXBException_Exception {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.getCompanyShares();
//    }
//
//    private static java.util.List<java.lang.String> getFTSESectors() throws JAXBException_Exception {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.getFTSESectors();
//    }
//
//    private static java.util.List<java.lang.String> getCurrencyCodes() {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.getCurrencyCodes();
//    }
//
//    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> getPriceByCurrency(java.lang.String newCurrencyCode, java.util.List<org.netbeans.xml.schema.shares.ShareType> shares) {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.getPriceByCurrency(newCurrencyCode, shares);
//    }
//
//    private static java.util.List<java.lang.String> getCompanySymbols() throws JAXBException_Exception {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.getCompanySymbols();
//    }
//
//    private static UserType getUser(java.lang.String username) throws JAXBException_Exception {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.getUser(username);
//    }
//
//    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> filterQuery(java.lang.String symbol, java.lang.String name, java.lang.String sector, java.lang.String filterPrice, float min, float max, java.util.List<org.netbeans.xml.schema.shares.ShareType> shares) throws JAXBException_Exception {
//        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
//        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
//        return port.filterQuery(symbol, name, sector, filterPrice, min, max, shares);
//    }

    private static UserType getUser(java.lang.String username) throws userws.JAXBException_Exception {
        userws.UserService_Service service = new userws.UserService_Service();
        userws.UserService port = service.getUserServicePort();
        return port.getUser(username);
    }

    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> getCompanyShares() throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getCompanyShares();
    }

    private static java.util.List<java.lang.String> getFTSESectors() throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getFTSESectors();
    }

    private static java.util.List<java.lang.String> getCurrencyCodes() {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getCurrencyCodes();
    }

    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> getPriceByCurrency(java.lang.String newCurrencyCode, java.util.List<org.netbeans.xml.schema.shares.ShareType> shares) {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getPriceByCurrency(newCurrencyCode, shares);
    }

    private static java.util.List<java.lang.String> getCompanySymbols() throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getCompanySymbols();
    }

    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> filterQuery(java.lang.String symbol, java.lang.String name, java.lang.String sector, java.lang.String filterPrice, float min, float max, java.util.List<org.netbeans.xml.schema.shares.ShareType> shares) throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.filterQuery(symbol, name, sector, filterPrice, min, max, shares);
    }
    
    
    
}
