/*
 * This class handles all reading and writing to the Guest Database
 * Checks for duplicate entries
 */
package engine;

import database.info.*;
import static engine.InputManager.isInteger;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//start of class
public class InventoryDBManager {

//variables
public static String _ItemName;
public static String _ItemQuantity;
public static String _ItemPrice;

//gets path to flat files
String nameOfFile = new File("").getAbsolutePath()+"\\database_files";

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

static final int INVALID_RESERVATION_FIELD_POSITION	= 17;
static final int INVALID_RESERVATION_NEW_VALUE	=	18;

static final int NEW_RECORD = 21;
static final int FAILED_ADDED_RECORD = 23;
static final int FAILED_RECORD_AREADY_EXISTS = 25;

static final int FOUND_RECORD_TO_DELETE = 31;
static final int FAILED_DELETED_RECORD = 33;
static final int NO_DELETE_RECORD_ABSENT = 35;

static final int FOUND_RECORD_TO_MODIFY = 41;
static final int FAILED_MODIFIED_RECORD = 43;
static final int NO_MODIFY_RECORD_ABSENT = 45;


//method to check for duplicate entries and add guests to database
public int addItem(InventoryInfo NewItem){
     nameOfFile = nameOfFile + "\\inventoryDatabaseFile.txt";
     System.out.println("File path is:" + nameOfFile);
     String newRecord; 
     newRecord = NewItem.getItemName()+";"+NewItem.getItemQuantity()+";"+NewItem.getItemPrice();
    //Variables
    int nReturnValue = 0;
    int iCount = 0;
    int nRecCount = 0;
    String strLine = null;
    String[] fields = null;
    String[] newRecordFields = null;
    ArrayList theRecords = new ArrayList();
    File file = new File(nameOfFile);
    FileWriter writer;

    try {
        //theRecords will hold everything in the data file if this is successful
        theRecords = DatabaseReader.DBreadFile(nameOfFile);
    } //try

    catch (Exception ee) {
        System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString());
    }  //catch
       
    newRecordFields = newRecord.split(";");
    //TEST
    System.out.println(newRecord);
    
    iCount = 1;
    nRecCount = theRecords.size();
    Iterator itr = theRecords.iterator();
    itr.next();     //skips the first line of file, which contains database name
    while (itr.hasNext()) {
        if (iCount < nRecCount + 1) {
            itr.next();
            strLine = (String)theRecords.get(iCount);   //strLine holds the entry line
            fields = strLine.split(";");    //fields uses comma delimiter to split into array
            //pretty sure the following is just to test that strLine is getting placead into fields[] correctly
            System.out.println("...\n");
            System.out.println(strLine);
            for (int i=0; i < fields.length; i++)  {
                System.out.println(fields[i].trim() );
            }
            //setting variables to values of preesxisting entry
            _ItemName = fields[0].trim();
            _ItemQuantity = fields[1].trim();
            _ItemPrice = fields[2].trim();
            
            //comparing current entry at given iterator count to the new entry
            //only ItemName need to be checked for duplicate records
            if (_ItemName.trim().equalsIgnoreCase(newRecordFields[0].trim())){
                System.out.println("Duplicate Record");
                //returns int value 13, which is understood as a write fail due to duplicates
                nReturnValue = FAILED_DUPLICATE_RECORD ;
                return nReturnValue;
            }

            else{
                System.out.println("NOT A DUP");
                nReturnValue = NEW_RECORD;

            }  //if

            iCount++;

        } //if

    }  //while
    //once the iterator has hit the end of file this makes sure nReturnValue is
    //set so that the method creates a new entry in the database
    if(itr.hasNext() != true) {
        nReturnValue = NEW_RECORD;
    }

    if (NEW_RECORD == nReturnValue){

        try {
            writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(writer);
            printer.append("\n");
            printer.append(newRecord);
            printer.close();
            System.out.println("SUCCESSFUL WRITE");
            nReturnValue = SUCCESSFUL_OPERATION;

        } //try

        catch (IOException ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
            ee.printStackTrace();

        } //catch

    }  //if
    return nReturnValue;

    } //method


//method to search for items
public String searchDB(InventoryInfo Inventory) {
    //Variables
    nameOfFile = nameOfFile + "\\inventoryDatabaseFile.txt";
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
                strLine = (String) theRecords.get(iCount);
                strLine = strLine.trim();
                System.out.println(strLine);
                fields = strLine.split(";");    //delimiter is ;

                _ItemName = fields[0].trim();

                if (_ItemName.toLowerCase().contains(Inventory.getItemName().toLowerCase())) {
                    return strLine;
                }
            } //if
            iCount++;
        } //while
        return "Error: no matching item found in inventoryDatabaseFile.txt.";

    }
   
//method to print all items in db
public ArrayList<String> printAllRecords(InventoryInfo Inventory) {
        //Variables
        nameOfFile = nameOfFile + "\\inventoryDatabaseFile.txt";
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
        int iCount = 1;
        int nRecCount = theRecords.size();
        Iterator itr = theRecords.iterator();
        itr.next();     //skips the first line of file, which contains database name
        while (itr.hasNext() && isSearching == true) {
            if (iCount < nRecCount + 1) {
                try {
                    strLine = (String) theRecords.get(iCount);
                    strLine = strLine.trim();
                    finalOutput.add(strLine);
                } catch (IndexOutOfBoundsException e) {
                    //reached end of file
                    isSearching = false;
                }
            } //if
            iCount++;
        } //while
        return finalOutput;

    }

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBremoveRecord(String fullPathFileName, String deleteRecord)
//------------------------------------------------------------------------------------------------------------
public int DBremoveRecord(String delRecord) {

        String reservationFile = nameOfFile + "\\inventoryDatabaseFile.txt";

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
            theRecords = DatabaseReader.DBreadFile(reservationFile);
        } //try
        catch (Exception ee) {
            System.err.println("Error: " + ee.getMessage() + "..stack: " + ee.getStackTrace().toString());
        }  //catch

        delRecordFields = delRecord.split(";");

        iCount = 0;

        nRecCount = theRecords.size();

        it = theRecords.iterator();
        it.next();

        while (it.hasNext()) {
            if (iCount < nRecCount + 1) { //HAS ISSUES DELETING WHEN ONLY 2 ITEMS REMAIN
                try {
                    if (it.hasNext()) {
                        strLine = (String) it.next();
                    }
                } catch (NoSuchElementException e) {
                    //error
                }
                strLine = strLine.trim();

                if (strLine.equals("") || strLine.equals(" ")) {
                    //if a blank record is in the file ..then skip it
                    iCount++;
                } else {
                    fields = strLine.split(";");
                    _ItemName = fields[0].trim();
                    _ItemQuantity = fields[1].trim();
                    _ItemPrice = fields[2].trim();
            //
                    //If all of the fields in the newRecord are equal to theRecords 
                    //Record theres an error
                    //

                    iCount++;

                    if (_ItemName.trim().equalsIgnoreCase(delRecordFields[0].trim())
                            && _ItemQuantity.trim().equalsIgnoreCase(delRecordFields[1].trim())
                            && _ItemPrice.trim().equalsIgnoreCase(delRecordFields[2].trim())) {
                        nReturnValue = FOUND_RECORD_TO_DELETE;
                        it.remove();
                        break;

                    } else {
                        nReturnValue = NO_DELETE_RECORD_ABSENT;
                    }  //else
                }  //else
            } //if
        }  //for

        if (nReturnValue == FOUND_RECORD_TO_DELETE) {
            try {
                out = new BufferedWriter(new FileWriter(reservationFile));
                for (it = theRecords.iterator(); it.hasNext();) {
                    strLine = (String) it.next();
                    strLine = strLine.trim();
                    out.write(strLine);
                    out.newLine();
                }
                out.close();
                nReturnValue = SUCCESSFUL_OPERATION;

            } //try
            catch (IOException ee) {
                System.err.println("Error: " + ee.getMessage() + "..stack: " + ee.getStackTrace().toString());
                ee.printStackTrace();
            } //catch

        }  //if

        return nReturnValue;
    }  //method
}