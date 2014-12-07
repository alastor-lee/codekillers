/*
  MAIN CLASS -- RUN THIS FROM COMMAND LINE

  PROGRAM OUTLINE 
       engine
            - only contains MANAGERS, READERS, or WRITERS that do some sort of logical work
            - does all logic handling and database management
            - handles all input verification
       database.info
            - classes in this package are PURELY for holding INFORMATION
            - Guest, Inventory, Reservation, Room etc.
            - These will all work very closely with the engine
            - Often will be created by GUI and then handled by ENGINE
       all GUI packages
            - PURELY FOT DISPLAY PURPOSES
            - all information passed in will IMMEDIATELY be passed to INFO classes
 */

package engine;

//below imports are unused until file checking works
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class HotelManager {
    
    public static void main(String[] args){
        mainframe.gui.LoginFrame master = new mainframe.gui.LoginFrame();
        master.setLocationRelativeTo(null); //centers spawned window
        master.getRootPane().setDefaultButton(master.LoginButton);
        master.setVisible(true);
        
    /*
     * The following will check for flat file existence
     * If needed files do not exist, they will be created in a new database folder
     */
    
     
    String GuestDB = new File("").getAbsolutePath()+"\\database_files\\guestDatabaseFile.txt";
    String RoomReservationDB = new File("").getAbsolutePath()+"\\database_files\\reservationDatabaseFile.txt";
    String InventoryDB = new File("").getAbsolutePath()+"\\database_files\\inventoryDatabaseFile.txt";
    String OrderHistoryDB = new File("").getAbsolutePath()+"\\database_files\\orderDatabaseFile.txt";
    String UserDB = new File("").getAbsolutePath()+"\\database_files\\userDatabaseFile.txt";
    String RoomDB = new File("").getAbsolutePath()+"\\database_files\\roomDatabaseFile.txt";

    File directory = new File(new File("").getAbsolutePath()+"\\database_files");
    boolean result = false;
    
    if (directory.exists()) {
        System.out.println("Folder already exists");
    } 
        else {
            result = directory.mkdirs();
            System.out.println(result);
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(GuestDB), "utf-8"))) {
                writer.write("DB1 Guest DB:0"); //:0 is essential for guestID creation
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }
            //creation of Guest Database
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(GuestDB), "utf-8"))) {
                writer.write("DB1 Guest DB:0"); //:0 is essential for guestID creation
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }  
            //creation of Reservation Database
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RoomReservationDB), "utf-8"))) {
                writer.write("DB2 Room Reservation DB");
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }
            //creation of Inventory Database
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(InventoryDB), "utf-8"))) {
                writer.write("DB3 Inventory DB\n"
                        + "Chicken;30;9.99\n"
                        + "Eggs;20;3.99\n"
                        + "Burger;15;5.99\n"
                        + "Soda;50;.99\n"
                        + "Hot Dog;15;3.99\n"
                        + "Steak;30;12.99\n"
                        + "Wine;50;4.99\n"
                        + "Donut;30;.99\n"
                        + "Ice Cream;30;2.99\n"
                        + "Beer;50;2.99\n"
                        + "Popsicle;20;1.99\n"
                        + "Candy;30;.99");
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }
            //creation of Order History Database
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OrderHistoryDB), "utf-8"))) {
                writer.write("DB4 Order History DB:0");
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }
            //creation of User Database
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(UserDB), "utf-8"))) {
                writer.write("DB5 UserDB DB1;admin;password");
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }
            //creation of Room Database
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(RoomDB), "utf-8"))) {
                writer.write("DB6 Room(calendar) DB");
            } 
            catch (IOException ex){
                System.out.println("Exception found: "+ex);
                System.exit(1);
            }
        }
    }
}