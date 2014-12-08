/*
 * This class handles all reading and writing to the Guest Database
 * Checks for duplicate entries
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

public class GuestDBManager {

    //IMPORTANT: gets path to database files 
    String nameOfFile = new File("").getAbsolutePath()+"\\database_files";

    //variables for comparison and setting
    public static String _GuestID;
    public static String _FirstName;
    public static String _LastName;
    public static String _Address;
    public static String _ContactNumber;
    public static String _Email;
    public static String _Charges;

    //FLAG VARIABLES
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
        //piecing together the new line to be added to data file
        String newRecord = NewGuest.getGuestID()+";"+NewGuest.getFirstName()+";"+NewGuest.getLastName()+";"+NewGuest.getAddress()+";"+NewGuest.getContactNum()+";"+NewGuest.getEmail();
        //System.out.println("newRecord Test: "+newRecord);  //TEST

        int nReturnValue;
        String strLine; //will hold one line of file at a time
        String[] fields;
        String[] newRecordFields;
        ArrayList theRecords = new ArrayList();  //theRecords will hold entire database file
        File file = new File(nameOfFile);
        FileWriter writer;
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
        Iterator itr = theRecords.iterator();
        itr.next(); //skips first line in data file, as it contains only the name of the file
        //while loop makes sure there is a next line in the file
        while (itr.hasNext()) {
            strLine = itr.next().toString();
            fields = strLine.split(";");
            //System.out.println(strLine);
            //setting variables to values of preexisting entry, for comparison
            _GuestID = fields[0].trim();
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
            }
        }
        //once the iterator has hit the end of file it means there is no
        //duplicate record in the preexisting file, so go ahead with the guest
        //addition to database
            try {
                writer = new FileWriter(file, true);
                PrintWriter printer = new PrintWriter(writer);
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
        return nReturnValue;
        }

    //something like this is needed, will heavily modify later
    public int DBremoveGuest(String reservationFile, String delRecord){

        int nReturnValue = 0;
        int nRecCount = 0;
        int iCount = 0;
        String strLine = null;
        String[] fields = null;
        String[] delRecordFields = null;
        ArrayList theRecords = new ArrayList();
        BufferedWriter out = null;
        Iterator it = null;

        //Code
        if (DBisValidRecord(delRecord) != true) {
            //the Record was not valid; so do not process it
            return FAILED_INVALID_RECORD;
        }


        try {
            theRecords = DatabaseReader.DBreadFile(reservationFile);
        } //try

        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
        }  //catch

        delRecordFields = delRecord.split(",");

        iCount =0;

        nRecCount = theRecords.size();

        for (it = theRecords.iterator(); it.hasNext(); ) {
            if (iCount < nRecCount + 1) {
                strLine = (String) it.next();
                strLine = strLine.trim();

                if (strLine.equals("") || strLine.equals(" ")) {
                    //if a blank record is in the file ..then skip it
                    iCount++;
                }

                else{
                    fields = strLine.split(",");
                    _GuestID = fields[0].trim();
                    _LastName = fields[1].trim();
                    _Address = fields[2].trim();
                    _ContactNumber = fields[3].trim();
                    _Email = fields[4].trim();
                    _Charges = fields[5].trim();

                    //
                    //If all of the fields in the newRecord are equal to theRecords 
                    //Record theres an error
                    //

                    iCount++;

                    if (_GuestID.trim().equalsIgnoreCase(delRecordFields[0].trim()) &&
                        _LastName.trim().equalsIgnoreCase(delRecordFields[1].trim()) &&
                        _Address.trim().equalsIgnoreCase(delRecordFields[2].trim()) &&
                        _ContactNumber.trim().equalsIgnoreCase(delRecordFields[3].trim()) &&
                        _Email.trim().equalsIgnoreCase(delRecordFields[4].trim()) &&
                        _Charges.trim().equalsIgnoreCase(delRecordFields[5].trim())) 
                    {
                            nReturnValue = FOUND_RECORD_TO_DELETE;  
                            it.remove();
                            break;

                    }

                    else {
                        nReturnValue = NO_DELETE_RECORD_ABSENT;
                    }  //else
                }  //else
            } //if
        }  //for


        if (nReturnValue == FOUND_RECORD_TO_DELETE)	{
            try {
                out = new BufferedWriter(new FileWriter(reservationFile));
                for (it = theRecords.iterator(); it.hasNext(); ) {
                strLine = (String) it.next();
                strLine = strLine.trim();
                out.write(strLine);
                out.newLine();
                }
            out.close();
            nReturnValue = SUCCESSFUL_OPERATION;

            } //try

            catch (IOException ee) {
                System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
                ee.printStackTrace();
            } //catch

        }  //if

        return nReturnValue;
    }

    //method to search for guest entry given either last name or guest ID
    //GuestInfo class is passed in containing info on desired guest
    //String containing all guest information is passed back out
    public String searchDB(GuestInfo OldGuest) {
        //Variables
        nameOfFile = nameOfFile + "\\guestDatabaseFile.txt";
        String strLine;
        String[] fields;
        ArrayList theRecords = new ArrayList();
        //opening and reading database file for comparison purposes
        try {
        //Get all the file records in the Array
            theRecords = DatabaseReader.DBreadFile(nameOfFile);
        } //try

        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
        } //catch

        int iCount = 1;
        int nRecCount = theRecords.size();
        Iterator itr = theRecords.iterator();
        itr.next();     //skips the first line of file, which contains database name
        while (itr.hasNext()) {
            if (iCount < nRecCount + 1) {
            strLine = (String)theRecords.get(iCount);
            strLine = strLine.trim();
            System.out.println(strLine);
            fields = strLine.split(";");    //delimiter is ;

            _GuestID = fields[0].trim();
            _LastName = fields[2].trim();

            if (OldGuest.getGuestID().equals(_GuestID)) {
                return strLine;
            } //if
            else if (_LastName.toLowerCase().contains(OldGuest.getLastName().toLowerCase())) {
                return strLine;
            }
        } //if
        iCount++;
        } //while
        return "No matching records found.";
    }
}