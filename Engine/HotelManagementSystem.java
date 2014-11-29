package engine;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * This is the main class for the program. This is the file that you will compile from the command line.
 */
public class HotelManagementSystem {
    
    public static void main(String[] args){
        mainframeGUI.LoginFrame gui = new mainframeGUI.LoginFrame();
        gui.setVisible(true);
        
    //++++++
    //initializing the database
    //------
        
    String GuestDB = "C:\\Documents\\database\\Guest.txt";
    String RoomReservationDB = "C:\\Documents\\database\\RoomReservation.txt";
    String InventoryDB = "C:\\Documents\\database\\Inventory.txt";
    String OrderHistoryDB = "C:\\Documents\\database\\OrderHistory.txt";
    String UserDB = "C:\\Documents\\database\\User.txt";
    String RoomDB = "C:\\Documents\\database\\Room.txt";

    File directory = new File("C:\\Documents\\database");
    boolean result = false;
    
    if (directory.exists()) {
        System.out.println("Folder already exists");
    } 
    else {
        result = directory.mkdirs();
        
        //DB_1 (Guest DB)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(GuestDB), "utf-8"))) {
            writer.write("DB1 Guest DB");
        } 
        catch (IOException ex){
            // handle me
        }  
        //DB_2 (Room Reservation DB)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RoomReservationDB), "utf-8"))) {
            writer.write("DB2 Room Reservation DB");
        } 
        catch (IOException ex){
            // handle me
        }
        //DB_3 (Inventory DB)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(InventoryDB), "utf-8"))) {
            writer.write("DB3 Inventory DB");
        } 
        catch (IOException ex){
            // handle me
        }
        
        //DB_4 (Order History DB)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OrderHistoryDB), "utf-8"))) {
            writer.write("DB4 Order History DB");
        } 
        catch (IOException ex){
            // handle me
        }
        
        //DB_5 (User DB)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(UserDB), "utf-8"))) {
            writer.write("DB5 UserDB DB");
        } 
        catch (IOException ex){
            // handle me
        }
    }
    //DB_6 (Room(calendar) DB)
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RoomDB), "utf-8"))) {
            writer.write("DB6 Room(calendar) DB");
        } 
        catch (IOException ex){
            //handle me
        }

        
    }
    
}