/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package floorlayoutgui;

import javax.swing.JFrame;
import javax.swing.JSpinner;

/**
 *
 * @author Colin
 */
public class NewReservationFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewReservationFrame
     */
    public NewReservationFrame() {
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

        jPanel1 = new javax.swing.JPanel();
        GuestIDField = new javax.swing.JTextField();
        NumberPersonsLabel = new javax.swing.JLabel();
        GuestIDLabel = new javax.swing.JLabel();
        NumPersonsField = new javax.swing.JTextField();
        TypeRoomLabel = new javax.swing.JLabel();
        TypeRoomComboBox = new javax.swing.JComboBox();
        CheckInLabel = new javax.swing.JLabel();
        CheckOutLabel = new javax.swing.JLabel();
        RoomNumberLabel = new javax.swing.JLabel();
        RoomNumberField = new javax.swing.JTextField();
        BeachViewCheckbox = new javax.swing.JCheckBox();
        LandViewCheckbox = new javax.swing.JCheckBox();
        SmokingCheckbox = new javax.swing.JCheckBox();
        SpecialPreferencesLabel = new javax.swing.JLabel();
        CommentsLabel = new javax.swing.JLabel();
        ContainerPane = new javax.swing.JScrollPane();
        CommentsTextArea = new javax.swing.JTextArea();
        CreateReservationButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        CreateNewGuestButton = new javax.swing.JButton();
        GuestLookupButton = new javax.swing.JButton();
        CheckInSpinner = new javax.swing.JSpinner();
        CheckOutSpinner = new javax.swing.JSpinner();
        CheckDateAvailabilityButton = new javax.swing.JButton();

        NumberPersonsLabel.setText("Number of Persons:");

        GuestIDLabel.setText("Guest ID:");

        TypeRoomLabel.setText("Type of Room:");

        TypeRoomComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Two Double Beds", "One King Bed", "Suite" }));
        TypeRoomComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeRoomComboBoxActionPerformed(evt);
            }
        });

        CheckInLabel.setText("Check-In Date:");

        CheckOutLabel.setText("Check-Out Date:");

        RoomNumberLabel.setText("Room Number:");

        RoomNumberField.setFocusable(false);

        BeachViewCheckbox.setText("Beach View");

        LandViewCheckbox.setText("Land View");

        SmokingCheckbox.setText("Near Smoking Areas");

        SpecialPreferencesLabel.setText("Special Preferences:");

        CommentsLabel.setText("Comments:");

        CommentsTextArea.setColumns(20);
        CommentsTextArea.setRows(5);
        ContainerPane.setViewportView(CommentsTextArea);

        CreateReservationButton.setText("Create Reservation");
        CreateReservationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateReservationButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        CreateNewGuestButton.setText("Create New Guest");
        CreateNewGuestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewGuestButtonActionPerformed(evt);
            }
        });

        GuestLookupButton.setText("Guest Lookup");
        GuestLookupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuestLookupButtonActionPerformed(evt);
            }
        });

        CheckInSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MONTH));
        CheckInSpinner.setEditor(new JSpinner.DateEditor(CheckInSpinner, "dd/MM/yyyy"));

        CheckOutSpinner.setModel(new javax.swing.SpinnerDateModel());

        CheckDateAvailabilityButton.setText("Check Date Availability");
        CheckDateAvailabilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDateAvailabilityButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(SpecialPreferencesLabel)
                                        .addGap(1, 1, 1))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(CommentsLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LandViewCheckbox)
                                    .addComponent(BeachViewCheckbox)
                                    .addComponent(SmokingCheckbox)
                                    .addComponent(ContainerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CreateReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TypeRoomLabel)
                                    .addComponent(NumberPersonsLabel)
                                    .addComponent(CheckInLabel)
                                    .addComponent(GuestIDLabel)
                                    .addComponent(CheckOutLabel)
                                    .addComponent(RoomNumberLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(GuestIDField)
                                    .addComponent(NumPersonsField)
                                    .addComponent(TypeRoomComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(CheckInSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(CheckOutSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(RoomNumberField))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreateNewGuestButton)
                                    .addComponent(GuestLookupButton)
                                    .addComponent(CheckDateAvailabilityButton)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(CancelButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuestIDLabel)
                    .addComponent(GuestIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CreateNewGuestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumberPersonsLabel)
                    .addComponent(NumPersonsField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(GuestLookupButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TypeRoomLabel)
                    .addComponent(TypeRoomComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckInLabel)
                            .addComponent(CheckInSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CheckOutLabel)
                            .addComponent(CheckOutSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(CheckDateAvailabilityButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomNumberLabel)
                    .addComponent(RoomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeachViewCheckbox)
                    .addComponent(SpecialPreferencesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LandViewCheckbox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SmokingCheckbox)
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CommentsLabel)
                    .addComponent(ContainerPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CancelButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TypeRoomComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeRoomComboBoxActionPerformed
        // Need code here to change the floor displayed
    }//GEN-LAST:event_TypeRoomComboBoxActionPerformed

    private void CreateNewGuestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewGuestButtonActionPerformed
        //CreateNewGuestFrame NewGuest = new CreateNewGuestFrame(); //Create a new instance of the frame
        //NewGuest.setVisible(true); //Make the frame visible
    }//GEN-LAST:event_CreateNewGuestButtonActionPerformed

    private void GuestLookupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestLookupButtonActionPerformed
        GuestLookupFrame GuestLookup = new GuestLookupFrame(); //Create a new instance of the frame
        GuestLookup.setVisible(true); //Make the frame visible
    }//GEN-LAST:event_GuestLookupButtonActionPerformed

    private void CreateReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateReservationButtonActionPerformed
        // Do stuff here
        this.dispose(); //Close the frame
    }//GEN-LAST:event_CreateReservationButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose(); //Close the frame
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CheckDateAvailabilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDateAvailabilityButtonActionPerformed
        // Do stuff here
    }//GEN-LAST:event_CheckDateAvailabilityButtonActionPerformed

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
            java.util.logging.Logger.getLogger(NewReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewReservationFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewReservationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox BeachViewCheckbox;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CheckDateAvailabilityButton;
    private javax.swing.JLabel CheckInLabel;
    private javax.swing.JSpinner CheckInSpinner;
    private javax.swing.JLabel CheckOutLabel;
    private javax.swing.JSpinner CheckOutSpinner;
    private javax.swing.JLabel CommentsLabel;
    private javax.swing.JTextArea CommentsTextArea;
    private javax.swing.JScrollPane ContainerPane;
    private javax.swing.JButton CreateNewGuestButton;
    private javax.swing.JButton CreateReservationButton;
    private javax.swing.JTextField GuestIDField;
    private javax.swing.JLabel GuestIDLabel;
    private javax.swing.JButton GuestLookupButton;
    private javax.swing.JCheckBox LandViewCheckbox;
    private javax.swing.JTextField NumPersonsField;
    private javax.swing.JLabel NumberPersonsLabel;
    private javax.swing.JTextField RoomNumberField;
    private javax.swing.JLabel RoomNumberLabel;
    private javax.swing.JCheckBox SmokingCheckbox;
    private javax.swing.JLabel SpecialPreferencesLabel;
    private javax.swing.JComboBox TypeRoomComboBox;
    private javax.swing.JLabel TypeRoomLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
