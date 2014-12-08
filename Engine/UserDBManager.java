/*
 * This class handles all reading and writing to the Guest Database
 * Checks for duplicate entries
 */
package engine;

import database.info.*;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.lang.reflect.*;

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
            theRecords = DBreadFile(nameOfFile);
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

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: getAllReservationRecords()
//------------------------------------------------------------------------------------------------------------
//this class does not handle reservation database, will either remove this or copr
//to a the ReservationDBManager class
    public static ArrayList getAllReservationRecords() {

// Variables
        String DBfileName = null;
        ArrayList records = new ArrayList();

        DBfileName = DBgetReservationFileName();
        records = DBreadFile(DBfileName);
        return records;
    }
try {
    theRecords = DBreadFile(reservationFile);
} //try
catch (Exception ee) {
    System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
}  //catch

newRecordFields = newRecord.split(",");

iCount =0;

nRecCount = theRecords.size();

Iterator itr = theRecords.iterator();

while (itr.hasNext()) {

    if (iCount < nRecCount + 1) {
        itr.next();
        strLine = (String) theRecords.get(iCount);
        fields = strLine.split(",");
        
        /*
        System.out.println("...\n");
        System.out.println(strLine);
        for (int i=0; i < fields.length; i++)  {
            System.out.println(fields[i].trim() );
        }

        _GuestID = fields[0].trim();
        _LastName = fields[1].trim();
        _Address = fields[2].trim();
        _ContactNumber = fields[3].trim();
        _Email = fields[4].trim();
        _Charges = fields[5].trim();

        if (_GuestID.trim().equalsIgnoreCase(newRecordFields[0].trim()) && 
            _LastName.trim().equalsIgnoreCase(newRecordFields[1].trim()) &&
            _Address.trim().equalsIgnoreCase(newRecordFields[2].trim()) &&
            _ContactNumber.trim().equalsIgnoreCase(newRecordFields[3].trim()) &&
            _Email.trim().equalsIgnoreCase(newRecordFields[4].trim()) &&
            _Charges.trim().equalsIgnoreCase(newRecordFields[5].trim())) 
        {
            nReturnValue = FAILED_DUPLICATE_RECORD ;   
            break;
        }

        else{
            nReturnValue = NEW_RECORD ;

        }  //if

        iCount++;

    } //if

}  //while

if (NEW_RECORD == nReturnValue){

    try {
        writer = new FileWriter(file, true);
        PrintWriter printer = new PrintWriter(writer);
        printer.append("\n");
        printer.append(newRecord);
        printer.close();
        
        nReturnValue = SUCCESSFUL_OPERATION;

    } //try

    catch (IOException ee) {
        System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
        ee.printStackTrace();

    } //catch

}  //if
return nReturnValue;

} //method
*/

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBremoveRecord(String fullPathFileName, String deleteRecord)
//------------------------------------------------------------------------------------------------------------
/* COMMENTING OUT, NOT WORKING
public static int DBremoveRecord(String reservationFile, String delRecord){

//Variables
int nReturnValue = 0;
int nRecCount = 0;
int iCount = 0;
String strLine = null;
String[] fields = null;
String[] delRecordFields = null;
ArrayList theRecords = new ArrayList();
BufferedWriter out = null;
Iterator it = null;

try {
    theRecords = DBreadFile(reservationFile);
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
            fields = strLine.split(";");
            _OrderID = fields[0].trim();

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
}  //method
*/

/*
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBreadFile(String filename)
//------------------------------------------------------------------------------------------------------------
    public static ArrayList DBreadFile(String reservationFile) {
        ArrayList records = new ArrayList();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(reservationFile));

            String line;

            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.length() < 10 || line.equals(" ")) {
                    // this is a blank line ...so skip it
                } else {
                    records.add(line);
                }
            } //while

            reader.close();
            return records;

        } //try
        catch (Exception e) {
            System.out.println("Exception occurred trying to read .");
            e.printStackTrace();
            return null;

        }  //catch

    } //method

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBgetReservationFileName()
//------------------------------------------------------------------------------------------------------------
    public static String DBgetReservationFileName() {
//
//return the String name
//
        return "C:\\Users\\Collin\\Desktop\\hotel_res.txt";

    } //

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: main(String[] args)
//------------------------------------------------------------------------------------------------------------
    public static void main(String[] args) {

        String reservationFile = "C:\\Users\\Collin\\Desktop\\hotel_res.txt";

        ArrayList theRecords = new ArrayList();

        theRecords = getAllReservationRecords();

        int i = 0;

        while (i < theRecords.size()) {

            System.out.println(theRecords.get(i));

            i++;

        }  //while
    }
}
