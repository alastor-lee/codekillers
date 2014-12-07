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

public class OrderDBManager {

    //IMPORTANT: gets path to database files 
    String nameOfFile = new File("").getAbsolutePath()+"\\database_files";

    //variables for comparison and setting
    public static String _OrderID;
    public static String _GuestID;
    public static String _FirstName;
    public static String _LastName;
    public static String _RoomNumber;
    public static String _OrderContents;
    public static String _SpecialRequests;
    public static String _TotalCost;
    public static String _ReadyForPickup;
    public static String _TimeStamp;

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
    public int addOrder(OrderInfo NewOrder){
        nameOfFile = nameOfFile + "\\orderDatabaseFile.txt";   //provides full path to file
        //piecing together the new line to be added to data file
        String newRecord = NewOrder.getOrderID()+";"+NewOrder.getGuestID()+";"+NewOrder.getFirstName()+";"+NewOrder.getLastName()+";"+NewOrder.getRoomNumber()+";"+NewOrder.getOrderContents()+";"+NewOrder.getSpecialRequests()+";"+NewOrder.getTotalCost()+";"+NewOrder.getReadyForPickup()+";"+NewOrder.getTimeStamp();

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
        while(itr.hasNext()){
        itr.next(); //skips first line in data file, as it contains only the name of the file
        }
        //while loop makes sure there is a next line in the file
        while (itr.hasNext()) {
            strLine = itr.next().toString();
            fields = strLine.split(";");
            //setting variables to values of preexisting entry, for comparison
            _OrderID = fields[0].trim();
            _FirstName = fields[1].trim();
            _LastName = fields[2].trim();
            _RoomNumber = fields[3].trim();
            _OrderContents = fields[4].trim();
            _SpecialRequests = fields[5].trim();
            _TotalCost = fields[6].trim();
            _ReadyForPickup = fields[7].trim();
            _TimeStamp = fields[8].trim();
           
            //comparing current entry at given iterator count to the new entry
            //only guestID and email need to be checked for duplicate records
            if (_OrderID.equalsIgnoreCase(newRecordFields[0]))
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
                printer.append("\n"); //most other Managers will need this
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
    
    public ArrayList<String> printAllRecords(OrderInfo Orders) {
        //Variables
        nameOfFile = nameOfFile + "\\orderDatabaseFile.txt";
        String strLine = "";
        String[] fields;
        ArrayList theRecords = new ArrayList();
        boolean isSearching = true;
        ArrayList<String> finalOutput = new ArrayList<String>();
        //opening and reading database file for comparison purposes
        try {
            //Get all the file records in the Array
            theRecords = DatabaseReader.DBreadFile(nameOfFile);
        } //try
        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() + "..stack: " + ee.getStackTrace().toString());
        } //catch
        int iCount = 0;
        int nRecCount = theRecords.size();
        Iterator itr = theRecords.iterator();
        itr.next();     //skips the first line of file, which contains database name
        while (isSearching == true) {
            if (iCount < nRecCount + 1) {
                try {
                    strLine = (String) theRecords.get(iCount);
                    strLine = strLine.trim();
                    finalOutput.add(strLine);
                } catch (IndexOutOfBoundsException e) {
                    // End of file
                    isSearching = false;
                }
            } //if
            iCount++;
        } //while
        return finalOutput;

    }
    
    public String searchDB(OrderInfo OrderSearch) {
        //Variables
        nameOfFile = nameOfFile + "\\orderDatabaseFile.txt";
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
            fields = strLine.split(";");    //delimiter is ;

            _OrderID = fields[0].trim();

            if (OrderSearch.getOrderID().equals(_OrderID)) {
                return strLine;
            }
        } //if
        iCount++;
        } //while
        return "No matching records found.";
    }

    /*
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

    //something like this may be needed, will probably modify greatly for our purposes
    public int  DBmodifyCustomerRecord(String reservationFile, String GuestID, String CustomerName, int fieldPosition, String newValue){

        int nReturnValue = 0;
        int iCount = 0;
        int nRecCount = 0;
        String strLine = null;
        String[] fields = null;
        String[] newRecordFields = null;
        Iterator it = null;
        ArrayList theRecords = new ArrayList();

        //the KEY Values are GuestID && CustomerName

        /*
        if (fieldPosition >= 1 && fieldPosition < 8) {

        }
        else {
            return INVALID_RESERVATION_FIELD_POSITION;
        }
        *//*
        newValue = newValue.trim();

        if (0 == newValue.length()  || newValue.equals(" ")) {
            return INVALID_RESERVATION_NEW_VALUE;
        }

        try {
            theRecords = DatabaseReader.DBreadFile(nameOfFile);
        } //try

        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
        }  //catch

        System.out.println("\n Checkpoint 1");

        iCount =0;

        nRecCount = theRecords.size();
        System.out.print(nRecCount);

        for (it = theRecords.iterator(); it.hasNext(); ) {

            if (iCount < nRecCount ) {
                it.next();
                strLine = (String) theRecords.get(iCount);
                strLine = strLine.trim();

                fields = strLine.split(",");
                _GuestID = fields[0].trim();
                _LastName = fields[1].trim();
                _Address = fields[2].trim();
                _ContactNumber = fields[3].trim();
                _Email = fields[4].trim();
                _Charges = fields[5].trim();


        //If all fields in the newRecord are the same as all the fields in theRecords then FAILED MODIFIED RECORD

        if (_GuestID.trim().equalsIgnoreCase(GuestID.trim()) && _LastName.trim().equalsIgnoreCase(_LastName.trim()) )  {   

            System.out.println("\n Checkpoint 2  \n");

            System.out.println(_LastName);

            switch (fieldPosition) {
                case 1:  _GuestID = newValue;
                break;

                case 2:  _LastName  = newValue;
                break;

                case 3:  _Address = newValue;
                break;

                case 4:	_ContactNumber = newValue;
                break;

                case 5:	_Email = newValue;
                break;

                case 6:	_Charges = newValue;
                break;

                default: nReturnValue = FAILED_MODIFIED_RECORD;
                break;    
            }  //switch


            System.out.println("\n Checkpoint 3");
            theRecords.remove(iCount);

            strLine = _GuestID + "," + _LastName + ","  + _Address   + ","  + _ContactNumber + "," + _Email   + "," + _Charges;    
            strLine.trim();

            theRecords.add(strLine);

            nReturnValue = FOUND_RECORD_TO_MODIFY;  

            break; //leave the for loop

        } //if

        else {
            nReturnValue = NO_MODIFY_RECORD_ABSENT;
        }  //if

        iCount++;

        }  //if

        }  //for



        if (FOUND_RECORD_TO_MODIFY == nReturnValue){
            boolean bWriteNewFile = true;
            nReturnValue = DBwriteArrayToFile(reservationFile, theRecords, bWriteNewFile);

        if (nReturnValue != SUCCESSFUL_OPERATION) {
            //
            // if not SUCCESSFUL_OPERATION then there is a problem...write code
            //

        }



        }  //if

        return nReturnValue;
    }

    //all input validation should be handlded elsewhere, planning on deleting
    public static boolean DBisValidRecord(String dbRecord){
    //Variables
    boolean bReturnValue = false;

    //Code
    if (dbRecord.equals("") || dbRecord.equals(" ")) {
        bReturnValue = false;
    }

    else {
        bReturnValue = true;
    }  //if

    return bReturnValue;
    }
    //!!!HERE ENDS ALL RELEVANT CODE!!!


    //commenting out, planning deleting
    //not clear on use of this, may not need
    public ArrayList DBOneCustomer(String reservationFile,String CustomerName) {
    //Variables
    String strLine = null;
    String[] fields = null;
    ArrayList theRecords = new ArrayList();

    try {
    //Get all the file records in the Array

        theRecords = DatabaseReader.DBreadFile(nameOfFile);
    } //try

    catch (Exception ee) {
        System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
    } //catch


    //Find the Customer by CustomerName 

    for (Iterator it = theRecords.iterator(); it.hasNext(); ) {
        strLine = (String) it.next();
        strLine = strLine.trim();
        fields = strLine.split(",");
        _LastName = fields[1].trim();
       /* 
        _GuestID = fields[0].trim();
        _LastName = fields[1].trim();
        _Address = fields[2].trim();
        _ContactNumber = fields[3].trim();
        _Email = fields[4].trim();
        _Charges = fields[5].trim();
    *//*


        if (!CustomerName.equals(_LastName)) {
            it.remove();

        } //if

    } //for

    return theRecords;

    }  //method

    //this does the the work of DBfileRead, planning on deleting
    public ArrayList getAllReservationRecords() {

    // Variables
    String DBfileName = null;
    ArrayList records = new ArrayList();

    //DBfileName = DBgetReservationFileName();
    records = DatabaseReader.DBreadFile(nameOfFile);
    return records;
    }

    //planning on deleting
    public int DBappendToEndOfFile(String reservationFile, String newRecord) {

    //Variables
    int nReturnValue = 0;
    int iCount = 0;
    int nRecCount = 0;
    String strLine = null;
    String[] fields = null;
    String[] newRecordFields = null;
    ArrayList theRecords = new ArrayList();
    File file = new File(reservationFile);
    FileWriter writer;

    //Code
    if (DBisValidRecord(newRecord) != true) {
        //the Record was not valid; so do not process it
        return FAILED_INVALID_RECORD;
        }

    try {
        theRecords = DatabaseReader.DBreadFile(nameOfFile);
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
            *//*

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

    //planning on deleting
    public static int DBwriteArrayToFile(String reservationFile, ArrayList theRecords, boolean bWriteNewFile){

    //Variables
    int nReturnValue = 0;
    int k = 0;
    int nRecCount = 0;
    String strLine = null;

    //Code
    nReturnValue = 0;
    Iterator it = theRecords.iterator();

    if (true == bWriteNewFile) {

        try {
            FileWriter outFile = new FileWriter(reservationFile);
            PrintWriter out = new PrintWriter(outFile);
            k = 0;

            nRecCount = theRecords.size();

            while (it.hasNext()) {
                if (k < nRecCount) {
                    it.next();
                    strLine = (String) theRecords.get(k);
                    out.println(strLine);
                    k++;
                }  //if
            } //while

            out.close();

            nReturnValue = SUCCESSFUL_OPERATION;
        }//try 

        catch (IOException e) {
            e.printStackTrace();
        } //catch

    } //if

    else {

    //
    //you should append to the end of the file
    //


    } //if

    return nReturnValue;
    }//method
*/
}   //CLASS END