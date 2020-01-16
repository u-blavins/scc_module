/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sharesbrokerclient;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.netbeans.xml.schema.shares.ShareType;
import sharesbroker.JAXBException_Exception;

/**
 *
 * @author UBlavins
 */
public class shares extends javax.swing.JFrame {
    
    private String currentCurrency = "GBP";
    /**
     * Creates new form shares
     */
    public shares() throws JAXBException_Exception {
        initComponents();
        loadTable(getCompanyShares());
        loadSectors();
    }
    
    public void loadSectors() throws JAXBException_Exception {
        for (String symbol : getFTSESectors()) {
            sectorText.addItem(symbol);
        }
    }
    
    public void loadTable(List<ShareType> shares) {
        DefaultTableModel model = (DefaultTableModel)sharesTable.getModel();
        Object[] row = new Object[7];
        for (ShareType share : shares) {
            row[0] = share.getCompanySymbol();
            row[1] = share.getCompanyName();
            row[2] = share.getAvailableShares();
            row[3] = share.getCompanyFTSESector();
            row[4] = share.getSharePrice().getCurrency();
            row[5] = share.getSharePrice().getValue();
            row[6] = share.getSharePrice().getLastUpdated();
            model.addRow(row);
        }
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

        priceFilter1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "None", "Lowest", "Highest" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(179, 204, 204));
        jPanel1.setAutoscrolls(true);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Shares Broker Client");

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 704, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(466, 466, 466)
                        .addComponent(messageLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(305, 305, 305)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(symbolText, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(companyText, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(sectorText, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel5)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel6)
                                .addGap(112, 112, 112)
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(priceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(filterButton)
                                .addGap(531, 531, 531)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jLabel3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(messageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(filterButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(symbolText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(companyText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(minText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(priceFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sectorText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(145, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
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
                loadTable(getCompanyShares());
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
                List<ShareType> filterShares = filterQuery(symbol, company, sector,
                        filterPrice, min, max);
                removeData();
                loadTable(filterShares);
            } catch (JAXBException_Exception ex) {
                Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filterButtonActionPerformed

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
                try {
                    new shares().setVisible(true);
                } catch (JAXBException_Exception ex) {
                    Logger.getLogger(shares.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField companyText;
    private javax.swing.JButton filterButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField maxText;
    private javax.swing.JLabel messageLabel;
    private javax.swing.JTextField minText;
    private javax.swing.JComboBox priceFilter;
    private javax.swing.JComboBox priceFilter1;
    private javax.swing.JComboBox sectorText;
    private javax.swing.JTable sharesTable;
    private javax.swing.JTextField symbolText;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> getCompanyShares() throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getCompanyShares();
    }

    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> getPriceByCurrency(java.lang.String currentCurrencyCode, java.lang.String newCurrencyCode, java.util.List<org.netbeans.xml.schema.shares.ShareType> shares) {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getPriceByCurrency(currentCurrencyCode, newCurrencyCode, shares);
    }
    
    private static java.util.List<org.netbeans.xml.schema.shares.ShareType> filterQuery(java.lang.String symbol, java.lang.String name, java.lang.String sector, java.lang.String filterPrice, float min, float max) throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.filterQuery(symbol, name, sector, filterPrice, min, max);
    }

    private static java.util.List<java.lang.String> getFTSESectors() throws JAXBException_Exception {
        sharesbroker.SharesBrokerWS_Service service = new sharesbroker.SharesBrokerWS_Service();
        sharesbroker.SharesBrokerWS port = service.getSharesBrokerWSPort();
        return port.getFTSESectors();
    }
}
