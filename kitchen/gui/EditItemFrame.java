package kitchen.gui;

import static engine.InputManager.isPositiveInteger;
import java.text.DecimalFormat;

/**
 *
 * @author Colin
 */
public class EditItemFrame extends javax.swing.JFrame {

    /**
     * Creates new form EditItemFrame
     */
    public EditItemFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ItemNameLabel = new javax.swing.JLabel();
        ItemQuantityLabel = new javax.swing.JLabel();
        ItemPriceLabel = new javax.swing.JLabel();
        ItemNameField = new javax.swing.JTextField();
        ItemQuantityField = new javax.swing.JTextField();
        ItemPriceField = new javax.swing.JTextField();
        CancelButton = new javax.swing.JButton();
        EditItemButton = new javax.swing.JButton();
        outputLabel = new javax.swing.JLabel();

        ItemNameLabel.setText("Item Name:");

        ItemQuantityLabel.setText("Quantity:");

        ItemPriceLabel.setText("Price:");

        ItemNameField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ItemNameFieldFocusGained(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        EditItemButton.setText("Edit Item");
        EditItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditItemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(CancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(EditItemButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(ItemPriceLabel)
                                    .addComponent(ItemQuantityLabel)
                                    .addComponent(ItemNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ItemNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 99, Short.MAX_VALUE)
                                    .addComponent(ItemQuantityField)
                                    .addComponent(ItemPriceField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(outputLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemNameLabel)
                    .addComponent(ItemNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemQuantityLabel)
                    .addComponent(ItemQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ItemPriceLabel)
                    .addComponent(ItemPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CancelButton)
                    .addComponent(EditItemButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose(); //Close the frame
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void EditItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditItemButtonActionPerformed
if(!(ItemNameField.getText().equals("")) && isPositiveInteger(ItemQuantityField.getText()) && (ItemPriceField.getText().matches("^[0-9]*([.]{1}[0-9]{0,2}){0,1}$"))){
            // Delete old record and make new record. Old one must be deleted because we don't have item IDs.
            EditInventoryFrame.deleteItem();
    
            database.info.InventoryInfo NewItem = new database.info.InventoryInfo();
            engine.InventoryDBManager InventoryDBWriter = new engine.InventoryDBManager();
            //setting vars in GuestInfo
            double doublePrice = Double.parseDouble(ItemPriceField.getText());
            DecimalFormat df = new DecimalFormat("#.00");
            String formattedPrice = df.format(doublePrice);
            NewItem.setItemName(ItemNameField.getText());
            NewItem.setItemQuantity(ItemQuantityField.getText());    //no error check
            NewItem.setItemPrice(formattedPrice);      //no error check

            InventoryDBWriter.addItem(NewItem);

            //EditInventoryFrame.SearchField.setText(""); //
            EditInventoryFrame.performSearch();

            this.dispose(); //Close the frame
        } else {
            outputLabel.setText("Error: Invalid Input.");
        }     
        this.dispose(); //Close the frame
    }//GEN-LAST:event_EditItemButtonActionPerformed

    private void ItemNameFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ItemNameFieldFocusGained
        toBeDeletedName = ItemNameField.getText(); //get name of selected item
        toBeDeletedQuantity = ItemQuantityField.getText(); //get quantity
        toBeDeletedPrice = ItemPriceField.getText(); //get price
    }//GEN-LAST:event_ItemNameFieldFocusGained

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
            java.util.logging.Logger.getLogger(EditItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditItemFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditItemFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    public javax.swing.JButton EditItemButton;
    public javax.swing.JTextField ItemNameField;
    private javax.swing.JLabel ItemNameLabel;
    public javax.swing.JTextField ItemPriceField;
    private javax.swing.JLabel ItemPriceLabel;
    public javax.swing.JTextField ItemQuantityField;
    private javax.swing.JLabel ItemQuantityLabel;
    private javax.swing.JLabel outputLabel;
    // End of variables declaration//GEN-END:variables
    String toBeDeletedName; //get name of selected item
    String toBeDeletedQuantity; //get quantity
    String toBeDeletedPrice; //get price
}
