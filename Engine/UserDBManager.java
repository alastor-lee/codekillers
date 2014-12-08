/*
 * This class handles all reading and writing to the Guest Database
 * Checks for duplicate entries
 */
package engine;

import database.info.*;
import java.io.*;
import java.util.*;

//start of class
public class UserDBManager {

//variables
    public static String _UserID;
    public static String _UserName;
    public static String _Password;

//gets path to flat files
    String nameOfFile = new File("").getAbsolutePath() + "\\database_files";

//static final int recPosition_LastName = 1;
    static final int recPosition_Action = 2;
    static final int recPosition_roomCount = 3;
    static final int recPosition_roomType = 4;
    static final int recPosition_checkInDate = 5;
    static final int recPosition_checkOutDate = 6;
    static final int recPosition_roomRate = 7;

    static final int recPosition_CustomerName = 1;
    static final int recPosition_Address = 2;
    static final int recPosition_ContactNumber = 3;
    static final int recPosition_Email = 4;
    static final int recPosition_Charges = 5;
//static final int recPosition_checkOutDate = 6;
//static final int recPosition_roomRate = 7;

    static final int SUCCESSFUL_OPERATION = 1;
    static final int SUCCESSFUL_ADDED_RECORD = 3;
    static final int SUCCESSFUL_DELETED_RECORD = 5;
    static final int SUCCESSFUL_MODIFIED_RECORD = 7;

    static final int FAILED_DUPLICATE_RECORD = 13;
    static final int FAILED_INVALID_RECORD = 15;

    static final int INVALID_RESERVATION_FIELD_POSITION = 17;
    static final int INVALID_RESERVATION_NEW_VALUE = 18;

    static final int NEW_RECORD = 21;
    static final int FAILED_ADDED_RECORD = 23;
    static final int FAILED_RECORD_AREADY_EXISTS = 25;

    static final int FOUND_RECORD_TO_DELETE = 31;
    static final int FAILED_DELETED_RECORD = 33;
    static final int NO_DELETE_RECORD_ABSENT = 35;

    static final int FOUND_RECORD_TO_MODIFY = 41;
    static final int FAILED_MODIFIED_RECORD = 43;
    static final int NO_MODIFY_RECORD_ABSENT = 45;

//method to search for username or password. This is actually bad and doesn't make sure that they are for the same user id.
    public int searchDB(UserInfo ExistingUser) {
        //Variables
        nameOfFile = nameOfFile + "\\userDatabaseFile.txt";
        String strLine;
        String[] fields;
        ArrayList theRecords = new ArrayList();
        //opening and reading database file for comparison purposes
        try {
            //Get all the file records in the Array
            theRecords = DatabaseReader.DBreadFile(nameOfFile);
        } //try
        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() + "..stack: " + ee.getStackTrace().toString());
        } //catch

        //searching for matching records for UserName and Password
        Iterator it = theRecords.iterator();
        //for (Iterator it = theRecords.iterator(); it.hasNext(); ) {
        do {
            strLine = (String) it.next();
            strLine = strLine.trim();
            fields = strLine.split(";");    //delimiter is ;

            // fields[1] is user ID. Not used at the moment but it exists if we want to use it.
            _UserName = fields[1].trim();
            _Password = fields[2].trim();

            /* For debug purposes
             System.out.println("_UserName: "+_UserName);
             System.out.println("_Password: "+_Password);
             System.out.println("ExistingUser.getPassword(): "+ExistingUser.getUserName());
             System.out.println("new String(ExistingUser.getPassword()): "+new String(ExistingUser.getPassword()));
             */
            if (ExistingUser.getUserName().equalsIgnoreCase(_UserName) && new String(ExistingUser.getPassword()).equals(_Password)) {
                return 1;
            }
        } while (it.hasNext());
        return 0;
    }  //method
}