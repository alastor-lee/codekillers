/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.gui;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

public class SearchGuestFrame extends javax.swing.JFrame {
    /**
     * Creates new form SearchGuestFrame
     */
    public SearchGuestFrame() {
        initComponents();
    }
    
    //variables
    String searchReturn;
    int focus = 1;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        GuestIDLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        SearchButton = new javax.swing.JButton();
        CloseButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTable = new javax.swing.JTable();

        setResizable(false);

        IDField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                IDFieldFocusGained(evt);
            }
        });

        LastNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                LastNameFieldFocusGained(evt);
            }
        });

        GuestIDLabel.setText("Guest ID:");

        LastNameLabel.setText("Last Name:");

        SearchButton.setText("Search");
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });

        CloseButton.setText("Close");
        CloseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseButtonActionPerformed(evt);
            }
        });

        outputTable.setAutoCreateRowSorter(true);
        outputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "First Name", "Last Name", "Address", "Phone Number", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(outputTable);
        if (outputTable.getColumnModel().getColumnCount() > 0) {
            outputTable.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(GuestIDLabel)
                        .addGap(12, 12, 12)
                        .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(CloseButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuestIDLabel)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LastNameLabel)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CloseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //planning on changing this later
    //currently getting an error if match is not found
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        database.info.GuestInfo GuestSearch = new database.info.GuestInfo();
        if(focus == 1){
            GuestSearch.setGuestID(IDField.getText()); //this cannot be used like this, modifies DB file when setGuestID is called w/o String input
            GuestSearch.setLastName("99999999999999999999"); //the purpose of this is to set it equal to a value that should never be in database
        }
        
        if(focus == 2){
            GuestSearch.setGuestID("qqqqqqqqqqqqqqqqqqqqq"); //the purpose of this is to set it equal to a value that should never be in database
            GuestSearch.setLastName(LastNameField.getText());
        }
        
        if(IDField.getText().equals("") && focus == 1){
            //print all records
            String query = "";

            try{
                GuestSearch.setLastName(query);
            } catch(NullPointerException e) {
                //string not found
            }

            engine.GuestDBManager manager = new engine.GuestDBManager();
            try {
                ArrayList<String> output = manager.printAllRecords(GuestSearch);
                
                String listString = "";
                for (String s : output) {
                    listString += s + "\t";
                }
                String[] split = listString.split(Pattern.quote("\t")); //split into pieces
                System.out.println("split: "+split);
                DefaultTableModel model = (DefaultTableModel) outputTable.getModel();
                model.setRowCount(0);
                
                for (int i = 0; i <= split.length; i++) {
                    String[] newSplit = split[i].split(Pattern.quote(";"));
                    model.addRow(newSplit);
                }
            } catch(ArrayIndexOutOfBoundsException e){
                //ViewInventoryOutput.setText("No matching item found in inventory.");
            }
        }
        
        else if(LastNameField.getText().equals("") && focus == 2){
            //print all records
            String query = "";

            try{
                GuestSearch.setLastName(query);
            } catch(NullPointerException e) {
                //string not found
            }

            engine.GuestDBManager manager = new engine.GuestDBManager();
            try {
                ArrayList<String> output = manager.printAllRecords(GuestSearch);
                
                String listString = "";
                for (String s : output) {
                    listString += s + "\t";
                }
                String[] split = listString.split(Pattern.quote("\t")); //split into pieces
                
                DefaultTableModel model = (DefaultTableModel) outputTable.getModel();
                model.setRowCount(0);
                
                for (int i = 0; i <= split.length; i++) {
                    String[] newSplit = split[i].split(Pattern.quote(";"));
                    model.addRow(newSplit);
                }
            } catch(ArrayIndexOutOfBoundsException e){
                //ViewInventoryOutput.setText("No matching item found in inventory.");
            }
        } else {
            //TEST GuestInfoText.setText(IDField.getText()+"\n"+LastNameField.getText());       
            engine.GuestDBManager manager = new engine.GuestDBManager();
            searchReturn = manager.searchDB(GuestSearch);
            String[] split = searchReturn.split(";");
            DefaultTableModel model = (DefaultTableModel) outputTable.getModel();
            model.setRowCount(0);
            model.addRow(split);
        }
    }//GEN-LAST:event_SearchButtonActionPerformed

    private void CloseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseButtonActionPerformed
        this.dispose(); //close the frame
    }//GEN-LAST:event_CloseButtonActionPerformed

    private void IDFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_IDFieldFocusGained
        focus = 1;
    }//GEN-LAST:event_IDFieldFocusGained

    private void LastNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_LastNameFieldFocusGained
        focus = 2;
    }//GEN-LAST:event_LastNameFieldFocusGained

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
            java.util.logging.Logger.getLogger(SearchGuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchGuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchGuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchGuestFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchGuestFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CloseButton;
    private javax.swing.JLabel GuestIDLabel;
    private javax.swing.JTextField IDField;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameLabel;
    public javax.swing.JButton SearchButton;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable outputTable;
    // End of variables declaration//GEN-END:variables
}
