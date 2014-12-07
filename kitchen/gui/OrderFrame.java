/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kitchen.gui;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import mainframe.gui.MainContainerFrame;

/**
 *
 * @author Colin
 */
public class OrderFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewOrderFrame
     */
    public OrderFrame() {
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
        GuestIDLabel = new javax.swing.JLabel();
        OrderNumberLabel = new javax.swing.JLabel();
        RoomNumberLabel = new javax.swing.JLabel();
        OrderLabel = new javax.swing.JLabel();
        SpecialRequestsLabel = new javax.swing.JLabel();
        GuestIDField = new javax.swing.JTextField();
        OrderNumberField = new javax.swing.JTextField();
        RoomNumberField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        SpecialRequestsField = new javax.swing.JTextArea();
        CancelButton = new javax.swing.JButton();
        SubmitButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        FirstNameLabel = new javax.swing.JLabel();
        LastNameLabel = new javax.swing.JLabel();
        FirstNameField = new javax.swing.JTextField();
        LastNameField = new javax.swing.JTextField();
        ErrorOutputLabel = new javax.swing.JLabel();
        EggsButton = new javax.swing.JButton();
        DonutButton = new javax.swing.JButton();
        BurgerButton = new javax.swing.JButton();
        IceCreamButton = new javax.swing.JButton();
        SodaButton = new javax.swing.JButton();
        BeerButton = new javax.swing.JButton();
        ChickenButton = new javax.swing.JButton();
        HotdogButton = new javax.swing.JButton();
        SteakButton = new javax.swing.JButton();
        PopsicleButton = new javax.swing.JButton();
        CandyButton = new javax.swing.JButton();
        WineButton = new javax.swing.JButton();
        GuestLookupButton = new javax.swing.JButton();

        GuestIDLabel.setText("Guest ID:");

        OrderNumberLabel.setText("Order Number:");

        RoomNumberLabel.setText("Room Number:");

        OrderLabel.setText("Order:");

        SpecialRequestsLabel.setText("Special Requests:");

        GuestIDField.setText("GuestID");
        GuestIDField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GuestIDFieldFocusLost(evt);
            }
        });

        OrderNumberField.setFocusable(false);

        RoomNumberField.setFocusable(false);

        SpecialRequestsField.setColumns(20);
        SpecialRequestsField.setRows(5);
        jScrollPane2.setViewportView(SpecialRequestsField);

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        SubmitButton.setText("Submit");
        SubmitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitButtonActionPerformed(evt);
            }
        });

        DeleteButton.setBackground(new java.awt.Color(255, 255, 255));
        DeleteButton.setFont(DeleteButton.getFont().deriveFont(DeleteButton.getFont().getStyle() | java.awt.Font.BOLD));
        DeleteButton.setForeground(new java.awt.Color(255, 0, 0));
        DeleteButton.setText("X");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        orderTable.setAutoCreateRowSorter(true);
        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Quantity", "Item Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderTable);
        if (orderTable.getColumnModel().getColumnCount() > 0) {
            orderTable.getColumnModel().getColumn(0).setPreferredWidth(1);
        }

        FirstNameLabel.setText("First Name:");

        LastNameLabel.setText("Last Name:");

        FirstNameField.setFocusable(false);

        LastNameField.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(OrderLabel)
                            .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(RoomNumberLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(RoomNumberField))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(OrderNumberLabel)
                                    .addComponent(GuestIDLabel)
                                    .addComponent(FirstNameLabel)
                                    .addComponent(LastNameLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(GuestIDField)
                                        .addComponent(OrderNumberField, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                                        .addComponent(FirstNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))
                                    .addComponent(LastNameField, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE))))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(SpecialRequestsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addComponent(ErrorOutputLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuestIDLabel)
                    .addComponent(GuestIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OrderNumberLabel)
                    .addComponent(OrderNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FirstNameLabel)
                    .addComponent(FirstNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LastNameLabel)
                    .addComponent(LastNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RoomNumberField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RoomNumberLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ErrorOutputLabel)
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(OrderLabel)
                        .addGap(44, 44, 44)
                        .addComponent(DeleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SpecialRequestsLabel)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SubmitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        EggsButton.setText("Eggs");
        EggsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EggsButtonActionPerformed(evt);
            }
        });

        DonutButton.setText("Donut");
        DonutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DonutButtonActionPerformed(evt);
            }
        });

        BurgerButton.setText("Burger");
        BurgerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BurgerButtonActionPerformed(evt);
            }
        });

        IceCreamButton.setText("Ice Cream");
        IceCreamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IceCreamButtonActionPerformed(evt);
            }
        });

        SodaButton.setText("Soda");
        SodaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SodaButtonActionPerformed(evt);
            }
        });

        BeerButton.setText("Beer");
        BeerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeerButtonActionPerformed(evt);
            }
        });

        ChickenButton.setText("Chicken");
        ChickenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ChickenButtonActionPerformed(evt);
            }
        });

        HotdogButton.setText("Hot Dog");
        HotdogButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HotdogButtonActionPerformed(evt);
            }
        });

        SteakButton.setText("Steak");
        SteakButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SteakButtonActionPerformed(evt);
            }
        });

        PopsicleButton.setText("Popsicle");
        PopsicleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PopsicleButtonActionPerformed(evt);
            }
        });

        CandyButton.setText("Candy");
        CandyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CandyButtonActionPerformed(evt);
            }
        });

        WineButton.setText("Wine");
        WineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WineButtonActionPerformed(evt);
            }
        });

        GuestLookupButton.setText("Guest Lookup");
        GuestLookupButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuestLookupButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(BurgerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(SteakButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(WineButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(EggsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(HotdogButton, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                    .addComponent(SodaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DonutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IceCreamButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BeerButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ChickenButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(PopsicleButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CandyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(GuestLookupButton))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(GuestLookupButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SteakButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(WineButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DonutButton)
                            .addComponent(EggsButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IceCreamButton)
                            .addComponent(BurgerButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BeerButton)
                            .addComponent(SodaButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ChickenButton)
                            .addComponent(HotdogButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PopsicleButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CandyButton)))
                .addGap(100, 100, 100))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        int toBeRemoved = orderTable.getSelectedRow();
        model.removeRow(toBeRemoved);
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void SubmitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitButtonActionPerformed
        /*
            GuestInfo class will set guest information and check for input error
            GuestDBManager will write to the database if input is correct
        */
        ArrayList<String> orderContentsArray = new ArrayList<String>();
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        for(int row = 0; row < model.getRowCount(); row++){
            orderContentsArray.add(model.getValueAt(row,1).toString()+":"+model.getValueAt(row,0).toString());
        }
        
        database.info.OrderInfo NewOrder = new database.info.OrderInfo();
        engine.OrderDBManager orderManager = new engine.OrderDBManager();
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy HH:mm");
        Date date = new Date();
        //getting and setting guest info into/from GuestInfo class
        NewOrder.setOrderID(); //TODO: generate order ID
        NewOrder.setGuestID(GuestIDField.getText());
        NewOrder.setFirstName(FirstNameField.getText());    //no error check
        NewOrder.setLastName(LastNameField.getText());      //no error check
        NewOrder.setRoomNumber(RoomNumberField.getText());
        NewOrder.setOrderContents(orderContentsArray);
        NewOrder.setSpecialRequests(SpecialRequestsField.getText());
        NewOrder.setTotalCost("24.99"); //TODO: add total cost
        NewOrder.setReadyForPickup("0");
        NewOrder.setTimeStamp(dateFormat.format(date));
        orderManager.addOrder(NewOrder);
        System.out.println(NewOrder.toString());    //TEST
        this.dispose(); //Close the frame
        MainContainerFrame.orderSearch();
    }//GEN-LAST:event_SubmitButtonActionPerformed

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose(); //Close the frame
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void EggsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EggsButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",EggsButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_EggsButtonActionPerformed

    private void GuestLookupButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuestLookupButtonActionPerformed
        reservation.gui.SearchGuestFrame SearchFrame = new reservation.gui.SearchGuestFrame(); //Create a new instance of the frame
        SearchFrame.setLocationRelativeTo(null); //Center the frame
        SearchFrame.getRootPane().setDefaultButton(SearchFrame.SearchButton);
        SearchFrame.setVisible(true); //Make the frame visible
    }//GEN-LAST:event_GuestLookupButtonActionPerformed

    private void BurgerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BurgerButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",BurgerButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_BurgerButtonActionPerformed

    private void SodaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SodaButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",SodaButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_SodaButtonActionPerformed

    private void HotdogButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HotdogButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",HotdogButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_HotdogButtonActionPerformed

    private void SteakButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SteakButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",SteakButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_SteakButtonActionPerformed

    private void WineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WineButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",WineButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_WineButtonActionPerformed

    private void DonutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DonutButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",DonutButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_DonutButtonActionPerformed

    private void IceCreamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IceCreamButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",IceCreamButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_IceCreamButtonActionPerformed

    private void BeerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeerButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",BeerButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_BeerButtonActionPerformed

    private void ChickenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ChickenButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",ChickenButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_ChickenButtonActionPerformed

    private void PopsicleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PopsicleButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",PopsicleButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_PopsicleButtonActionPerformed

    private void CandyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CandyButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) orderTable.getModel();
        String[] item = {"1",CandyButton.getText()};
        model.addRow(item);
    }//GEN-LAST:event_CandyButtonActionPerformed

    private void GuestIDFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GuestIDFieldFocusLost
        try{
            String guestIDtoBeSearched = GuestIDField.getText();
            database.info.GuestInfo GuestSearch = new database.info.GuestInfo();
            GuestSearch.setGuestID(guestIDtoBeSearched);
            GuestSearch.setLastName("999999999999999999");
            //TEST GuestInfoText.setText(IDField.getText()+"\n"+LastNameField.getText());       
            engine.GuestDBManager manager = new engine.GuestDBManager();
            String searchReturn = manager.searchDB(GuestSearch);
            String[] split = searchReturn.split(";");
            ErrorOutputLabel.setText("");
            FirstNameField.setText(split[1]);
            LastNameField.setText(split[2]);
            //RoomNumberField.setText();
            System.out.println(searchReturn);
        } catch (IndexOutOfBoundsException e){
            ErrorOutputLabel.setText("Error: Guest ID does not exist.");
        }
        
    }//GEN-LAST:event_GuestIDFieldFocusLost

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
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BeerButton;
    private javax.swing.JButton BurgerButton;
    private javax.swing.JButton CancelButton;
    private javax.swing.JButton CandyButton;
    private javax.swing.JButton ChickenButton;
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DonutButton;
    private javax.swing.JButton EggsButton;
    private javax.swing.JLabel ErrorOutputLabel;
    private javax.swing.JTextField FirstNameField;
    private javax.swing.JLabel FirstNameLabel;
    private javax.swing.JTextField GuestIDField;
    private javax.swing.JLabel GuestIDLabel;
    private javax.swing.JButton GuestLookupButton;
    private javax.swing.JButton HotdogButton;
    private javax.swing.JButton IceCreamButton;
    private javax.swing.JTextField LastNameField;
    private javax.swing.JLabel LastNameLabel;
    private javax.swing.JLabel OrderLabel;
    private javax.swing.JTextField OrderNumberField;
    private javax.swing.JLabel OrderNumberLabel;
    private javax.swing.JButton PopsicleButton;
    private javax.swing.JTextField RoomNumberField;
    private javax.swing.JLabel RoomNumberLabel;
    private javax.swing.JButton SodaButton;
    private javax.swing.JTextArea SpecialRequestsField;
    private javax.swing.JLabel SpecialRequestsLabel;
    private javax.swing.JButton SteakButton;
    private javax.swing.JButton SubmitButton;
    private javax.swing.JButton WineButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable orderTable;
    // End of variables declaration//GEN-END:variables
}
