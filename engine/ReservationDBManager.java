
/*
 * Database manager class modified to handle information relevant 
 */

package engine;

import database.info.*;
import java.io.*;
import java.util.*;
//import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/*
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.lang.reflect.*;
*/

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
    //static final int recPosition_LastName = 1;
    static final int recPosition_Action	= 2;
    static final int recPosition_roomCount = 3;
    static final int recPosition_roomType = 4;
    static final int recPosition_checkInDate = 5;
    static final int recPosition_checkOutDate = 6;
    static final int recPosition_roomRate = 7;

    static final int recPosition_CustomerName = 1;
    static final int recPosition_Address	= 2;
    static final int recPosition_ContactNumber = 3;
    static final int recPosition_Email = 4;
    static final int recPosition_Charges = 5;
    //static final int recPosition_checkOutDate = 6;
    //static final int recPosition_roomRate = 7;

    static final int SUCCESSFUL_OPERATION	= 1;
    static final int SUCCESSFUL_ADDED_RECORD = 3;
    static final int SUCCESSFUL_DELETED_RECORD = 5;
    static final int SUCCESSFUL_MODIFIED_RECORD = 7;

    static final int FAILED_DUPLICATE_RECORD = 13;
    static final int FAILED_INVALID_RECORD = 15;
    static final int FAILED_FILE_READ = 17;

    static final int INVALID_RESERVATION_FIELD_POSITION = 18;
    static final int INVALID_RESERVATION_NEW_VALUE	= 19;

    static final int NEW_RECORD = 21;
    static final int FAILED_ADDED_RECORD = 23;
    static final int FAILED_RECORD_AREADY_EXISTS = 25;

    static final int FOUND_RECORD_TO_DELETE = 31;
    static final int FAILED_DELETED_RECORD = 33;
    static final int NO_DELETE_RECORD_ABSENT = 35;

    static final int FOUND_RECORD_TO_MODIFY = 41;
    static final int FAILED_MODIFIED_RECORD = 43;
    static final int NO_MODIFY_RECORD_ABSENT = 45;
    
    //attempts to add new guest to database
    //checks database to prevent duplication of guests
    //GuestInfo class is passed in to obtain necessary new guest info
    public int addGuest(GuestInfo NewGuest){
        nameOfFile = nameOfFile + "\\guestDatabaseFile.txt";   //provides full path to file
        //System.out.println("File path is:" + nameOfFile);  //TEST
        //piecing together the new line to be added to data file
        String newRecord = NewGuest.getGuestID()+";"+NewGuest.getFirstName()+";"+NewGuest.getLastName()+";"+NewGuest.getAddress()+";"+NewGuest.getContactNum()+";"+NewGuest.getEmail();
        System.out.println("newRecord Test: "+newRecord);  //TEST

        int nReturnValue;
        //int iCount = 1; //must start @ 1
        //int nRecCount;
        String strLine; //will hold one line of file at a time
        String[] fields;
        String[] newRecordFields;
        ArrayList theRecords = new ArrayList();     //theRecords will hold entire database file
        File file = new File(nameOfFile);
        FileWriter writer;

        //not convinced this conditional is necessary, all input validation is done elsewhere
        /*
        if (DBisValidRecord(newRecord) != true) {
            return FAILED_INVALID_RECORD;
            }
        */
        try {   //theRecords will hold everything in the data file if this is successful
            theRecords = DatabaseReader.DBreadFile(nameOfFile);
        }
        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString());
            nReturnValue = FAILED_FILE_READ;
            return nReturnValue;
        }
        //setting each value(guest ID, name, address, email, phone #, etc.) into
        //separate array indexes for comparison to fields in data file
        newRecordFields = newRecord.split(";");

        //nRecCount = theRecords.size();  //hold # of lines in the current data file
        Iterator itr = theRecords.iterator();
        itr.next(); //skips first line in data file, as it contains only the name of the file
        //while loop makes sure there is a next line in the file
        while (itr.hasNext()) {
            //if (iCount < nRecCount + 1) {   //makes sure the end of the file has not been reached
            strLine = itr.next().toString();
            //strLine = (String)theRecords.get(iCount);   //strLine is now the info for guest at line iCount in file
            fields = strLine.split(";");
            //pretty sure the following is just to test that strLine is getting placed into fields[] correctly
            //System.out.print("...\n");
            System.out.println(strLine);
            /*
            for (int i=0; i<fields.length; i++)  {
                System.out.println(fields[i].trim());
            }*/
            //setting variables to values of preexisting entry, for comparison
            
            /*_GuestID = fields[0].trim();
            _FirstName = fields[1].trim();
            _LastName = fields[2].trim();
            _Address = fields[3].trim();
            _ContactNumber = fields[4].trim();
            _Email = fields[5].trim();
            //_Charges = fields[6].trim();      //not handling this yet
            
                    
            //comparing current entry at given iterator count to the new entry
            //only guestID and email need to be checked for duplicate records
            if (_GuestID.equalsIgnoreCase(newRecordFields[0]) || _Email.equalsIgnoreCase(newRecordFields[5]))
            {
                System.out.println("Duplicate Record");
                nReturnValue = FAILED_DUPLICATE_RECORD;
                return nReturnValue;
            }
            else{
                System.out.println("NOT A DUP");
                nReturnValue = NEW_RECORD;
            //}
            //iCount++;
            }
        }
        */
        //once the iterator has hit the end of file nReturnValue needs to be set 
        //so that a new recod is created in the file
        //to get to this point means there is no next line in the file
        //nReturnValue = NEW_RECORD;

        //if (NEW_RECORD == nReturnValue){
            try {
                writer = new FileWriter(file, true);
                PrintWriter printer = new PrintWriter(writer);
                //
                //printer.append("\n"); //most other Managers will need this
                printer.append(newRecord);
                printer.close();
                System.out.println("SUCCESSFUL WRITE");
                nReturnValue = SUCCESSFUL_OPERATION;

            }
            catch (IOException ee) {
                System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
                ee.printStackTrace();
                nReturnValue = FAILED_ADDED_RECORD;
                return nReturnValue;
            }
        //}  //if
        return nReturnValue;
        }
