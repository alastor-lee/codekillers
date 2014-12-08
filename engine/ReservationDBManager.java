
/*
 * Database manager class modified to handle information relevant
 * to rservation creation.  Guest ID will be used to link the guest to the
 * appropriate reservation.
 */

package engine;

import database.info.*;
import java.io.*;
import java.util.*;
//import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReservationDBManager {

    //IMPORTANT: gets path to database files 
    String nameOfFile = new File("").getAbsolutePath()+"\\database_files";

    //variables for comparison and setting
    public static String _GuestID;
    public static String _NumOfPersons;
    public static String _TypeOfRoom;
    public static String _CheckIn;
    public static String _CheckOut;
    public static String _RoomNum;
    public static String _SpecialPref;
    public static String _Comments;

    //FLAG VARIABLES
    static final int SUCCESSFUL_OPERATION	= 1;

    static final int FAILED_DUPLICATE_RECORD = 13;
    static final int FAILED_FILE_READ = 17;

    static final int NEW_RECORD = 21;
    static final int FAILED_ADDED_RECORD = 23;
    
    //attempts to add new guest to database
    //checks database to prevent duplication of guests
    //GuestInfo class is passed in to obtain necessary new guest info
    public int addReservation(ReservationInfo NewReservation){
        nameOfFile = nameOfFile + "\\reservationDatabaseFile.txt";   //provides full path to file
        //System.out.println("File path is:" + nameOfFile);  //TEST
        int nReturnValue;
        //piecing together the new line to be added to data file
        String newRecord = NewReservation.toString();
        System.out.println("newRecord Test: "+newRecord);  //TEST
        ArrayList theRecords = new ArrayList();     //theRecords will hold entire database file
        File file = new File(nameOfFile);
        //file writing happening here
        FileWriter writer;
        //no input checking s required here, has already been handled elsewhere
            try {
                writer = new FileWriter(file, true);
                PrintWriter printer = new PrintWriter(writer);
                printer.append("\n"); //most Managers will need this
                printer.append(newRecord);
                printer.close();
                System.out.println("SUCCESSFUL WRITE");
                nReturnValue = SUCCESSFUL_OPERATION;
                return nReturnValue;
            }
            catch (IOException ee) {
                System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
                ee.printStackTrace();
                nReturnValue = FAILED_ADDED_RECORD;
                return nReturnValue;
            }
    }
}
