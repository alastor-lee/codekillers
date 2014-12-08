/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.gui;

import javax.swing.JFrame;
import javax.swing.JSpinner;

/**
 *  Needed fields for creating new reservation:
 * Guest ID, Room #, Check-In, Check-out, # of occupants, preferences, comments, room type
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
        SpecialPreferencesLabel = new javax.swing.JLabel();
        CommentsLabel = new javax.swing.JLabel();
        ContainerPane = new javax.swing.JScrollPane();
        CommentsTextArea = new javax.swing.JTextArea();
        CreateReservationButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        CreateNewGuestButton = new javax.swing.JButton();
        GuestLookupButton = new javax.swing.JButton();
        CheckDateAvailabilityButton = new javax.swing.JButton();
        ErrorTextField = new javax.swing.JLabel();
        CheckInSpinner = new javax.swing.JSpinner();
        CheckOutSpinner = new javax.swing.JSpinner();
        SpecialPrefComboBox = new javax.swing.JComboBox();

        setResizable(false);

        GuestIDField.setText("(must be preexisting guest)");
        GuestIDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuestIDFieldActionPerformed(evt);
            }
        });
        GuestIDField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                GuestIDFieldFocusGained(evt);
            }
        });

        NumberPersonsLabel.setText("Number of Persons:");

        GuestIDLabel.setText("Guest ID:");

        NumPersonsField.setText("(1-6)");
        NumPersonsField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                NumPersonsFieldFocusGained(evt);
            }
        });

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

        RoomNumberField.setText("(100-120, 200-220, 300-320)");
        RoomNumberField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                RoomNumberFieldFocusGained(evt);
            }
        });

        SpecialPreferencesLabel.setText("Special Preferences:");

        CommentsLabel.setText("Comments:");

        CommentsTextArea.setColumns(20);
        CommentsTextArea.setRows(5);
        CommentsTextArea.setText("!!!!CLEAR THIS!!!!\nBeach View: 100-105, 200-205, 300-305\nLand View: 106-120, 206-220, 306-320\nNear Smoking: 100-110, 200-210, 300-310\nSuites: 100-102, 200-202, 300-302\nOne King: 103-110, 203-210, 303-310\nTwo Double: 111-120, 211-220, 311-320\n!!!!CLEAR THIS!!!!");
        CommentsTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                CommentsTextAreaFocusGained(evt);
            }
        });
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

        CheckDateAvailabilityButton.setText("Check Date Availability");
        CheckDateAvailabilityButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckDateAvailabilityButtonActionPerformed(evt);
            }
        });

        CheckInSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_WEEK));
        CheckInSpinner.setToolTipText("");

        CheckOutSpinner.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_MONTH));

        SpecialPrefComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Beach View", "Land View", "Near Smoking Areas" }));

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
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(SpecialPrefComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ContainerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TypeRoomLabel)
                                    .addComponent(NumberPersonsLabel)
                                    .addComponent(CheckInLabel)
                                    .addComponent(GuestIDLabel)
                                    .addComponent(CheckOutLabel)
                                    .addComponent(RoomNumberLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(GuestIDField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(NumPersonsField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(TypeRoomComboBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(RoomNumberField, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(CheckOutSpinner)
                                    .addComponent(CheckInSpinner))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CreateNewGuestButton)
                                    .addComponent(GuestLookupButton)
                                    .addComponent(CheckDateAvailabilityButton)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(ErrorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(CancelButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(CreateReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RoomNumberLabel)
                    .addComponent(RoomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpecialPreferencesLabel)
                    .addComponent(SpecialPrefComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(CommentsLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(ContainerPane, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrorTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateReservationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CancelButton)
                .addContainerGap())
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TypeRoomComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeRoomComboBoxActionPerformed
        // Need code here to change the floor displayed
    }//GEN-LAST:event_TypeRoomComboBoxActionPerformed

    private void CreateNewGuestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewGuestButtonActionPerformed
        NewGuestCreate NewGuest = new NewGuestCreate(); //Create a new instance of the frame
        NewGuest.setLocationRelativeTo(null); //center the frame
        NewGuest.setVisible(true); //Make the frame visible
    }//GEN-LAST:event_CreateNewGuestButtonActionPerformed

    private void GuestLookupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestLookupButtonActionPerformed
        SearchGuestFrame GuestSearch = new SearchGuestFrame(); //Create a new instance of the frame
        GuestSearch.setLocationRelativeTo(null); //center the frame
        GuestSearch.setVisible(true); //Make the frame visible
    }//GEN-LAST:event_GuestLookupButtonActionPerformed

    private void CreateReservationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateReservationButtonActionPerformed
        int check = 0;  //must be initialized to 0
        database.info.ReservationInfo newReserv = new database.info.ReservationInfo();
        
        //fields are preset for following, no error handling required
        newReserv.setTypeOfRoom(Integer.toString(TypeRoomComboBox.getSelectedIndex()));
        //0 - Two Double Beds, 1 - One King Bed, 2 - Suite
        newReserv.setSpecialPref(Integer.toString(SpecialPrefComboBox.getSelectedIndex()));
        //0 - Beach View, 1 - Land View, 2 - Near Smoking Area
        newReserv.setComments(CommentsTextArea.getText());
        
        //check looks for error return values
        check = newReserv.setGuestID(GuestIDField.getText());
        //setGuestID error returns 2
        if(check==0){   //setNumOfPersons error returns 3
            check = newReserv.setNumOfPersons(NumPersonsField.getText());
        }
        if(check==0){   //setRoomNum error returns 7
            check = newReserv.setRoomNum(RoomNumberField.getText());
        }
        if(check==0){   //setCheckIn error returns 5
            System.out.println("Date for check in: "+CheckInSpinner.getValue());
            check = newReserv.setCheckIn(CheckInSpinner.getValue().toString());
        }            
        if(check==0){   //setCheckOut error returns 6
            System.out.println("Date for check out: "+CheckOutSpinner.getValue());
            check = newReserv.setCheckOut(CheckOutSpinner.getValue().toString());
        }
        if(check==0){   //success returns 1, error returns 13
            //engine.ReservationDBManager reservationAdd = new engine.ReservationDBManager();
            //check = reservationAdd.addReservation(newReserv); 
        }
        System.out.println(newReserv.toString());
            switch(check) {
            case 0: ErrorTextField.setText("TESTING HUEHUEHUE");
                break;
            case 1: ErrorTextField.setText("Reservation Added");
                break;
            case 2: ErrorTextField.setText("Invalid Guest ID");  
                break;
            case 3: ErrorTextField.setText("Invalid # of people");
                break;
            case 5: ErrorTextField.setText("Invalid Check In Date");
                break;
            case 6: ErrorTextField.setText("Invalid Check Out Date");
                break;
            case 7: ErrorTextField.setText("Invalid Room #");
                break;
            case 13: ErrorTextField.setText("Invalid Reservation");
                break;
            default: ErrorTextField.setText("Improper Handling");
                break;
        }
        
        //this.dispose(); //Close the frame
    }//GEN-LAST:event_CreateReservationButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose(); //Close the frame
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void CheckDateAvailabilityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckDateAvailabilityButtonActionPerformed
        //TEST CODE
        System.out.println(CheckInSpinner.getValue());
    }//GEN-LAST:event_CheckDateAvailabilityButtonActionPerformed

    private void GuestIDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestIDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuestIDFieldActionPerformed

    private void GuestIDFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuestIDFieldFocusGained
        GuestIDField.selectAll();
    }//GEN-LAST:event_GuestIDFieldFocusGained

    private void NumPersonsFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_NumPersonsFieldFocusGained
        NumPersonsField.selectAll();
    }//GEN-LAST:event_NumPersonsFieldFocusGained

    private void RoomNumberFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RoomNumberFieldFocusGained
        RoomNumberField.selectAll();
    }//GEN-LAST:event_RoomNumberFieldFocusGained

    private void CommentsTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_CommentsTextAreaFocusGained
        CommentsTextArea.selectAll();
    }//GEN-LAST:event_CommentsTextAreaFocusGained

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
    private javax.swing.JLabel ErrorTextField;
    private javax.swing.JTextField GuestIDField;
    private javax.swing.JLabel GuestIDLabel;
    private javax.swing.JButton GuestLookupButton;
    private javax.swing.JTextField NumPersonsField;
    private javax.swing.JLabel NumberPersonsLabel;
    private javax.swing.JTextField RoomNumberField;
    private javax.swing.JLabel RoomNumberLabel;
    private javax.swing.JComboBox SpecialPrefComboBox;
    private javax.swing.JLabel SpecialPreferencesLabel;
    private javax.swing.JComboBox TypeRoomComboBox;
    private javax.swing.JLabel TypeRoomLabel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
