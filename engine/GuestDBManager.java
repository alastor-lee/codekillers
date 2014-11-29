/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author Collin
 */
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
public class GuestDBManager {

//variables
public static String _GuestID;
public static String _FirstName;
public static String _LastName;
public static String _Address;
public static String _ContactNumber;
public static String _Email;
public static String _Charges;

String nameOfFile = new File("").getAbsolutePath();

public GuestDBManager() {
    //basic constructor
}
//constructor called on by the databaseManager to add a new guest to the database
public GuestDBManager(String ID, String fName, String lName, String phoneNum, String address, String email) {
    _GuestID = ID;
    _FirstName = fName;
    _LastName = lName;
    _ContactNumber = phoneNum;  
    _Address = address;
    _Email = email;
    System.out.println(_GuestID + " " + _FirstName + " "+ _LastName + " " + _ContactNumber + " " + _Address + " " + _Email);
}

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


public int addGuest(GuestInfo NewGuest){
     nameOfFile = nameOfFile + "\\guestDatabaseFile.txt";
     System.out.println("File path is:" + nameOfFile);
     String newRecord; 
     newRecord = NewGuest.getGuestID()+";"+NewGuest.getFirstName()+";"+NewGuest.getLastName()+";"+NewGuest.getAddress()+";"+NewGuest.getContactNum()+";"+NewGuest.getEmail();
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

    //Code
    
    if (DBisValidRecord(newRecord) != true) {
        //the Record was not valid; so do not process it
        //System.out.println("FAILED RECORD CHECK");
        return FAILED_INVALID_RECORD;
        }
    try {
        //theRecords will hold everything in the data file if this is successful
        theRecords = DBreadFile(nameOfFile);
    } //try

    catch (Exception ee) {
        System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString());
    }  //catch
       
    newRecordFields = newRecord.split(";");
    //TEST
    System.out.println(newRecord);
    
    iCount =0;
    nRecCount = theRecords.size();
    Iterator itr = theRecords.iterator();
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
            _GuestID = fields[0].trim();
            _FirstName = fields[1].trim();
            _LastName = fields[2].trim();
            _Address = fields[3].trim();
            _ContactNumber = fields[4].trim();
            _Email = fields[5].trim();
            //_Charges = fields[6].trim();      //no handling this yet
            
            //comparing current entry at given iterator count to the new entry
            //only guestID and email need to be checked for duplicate records
            if (_GuestID.trim().equalsIgnoreCase(newRecordFields[0].trim()) || 
                _Email.trim().equalsIgnoreCase(newRecordFields[5].trim())
            )
            {
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

public String searchDB(GuestInfo OldGuest) {
    //Variables
    nameOfFile = nameOfFile + "\\guestDatabaseFile.txt";
    String strLine;
    String[] fields;
    ArrayList theRecords = new ArrayList();
    //opening and reading database file for comparison purposes
    try {
    //Get all the file records in the Array
        theRecords = DBreadFile(nameOfFile);
    } //try

    catch (Exception ee) {
        System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
    } //catch
    
    //searching for matching records for GuestID and LastName 
    for (Iterator it = theRecords.iterator(); it.hasNext(); ) {
        strLine = (String)it.next();
        strLine = strLine.trim();
        fields = strLine.split(";");    //delimiter is ;
        /*
        for(int i=0; i<fields.getLength(); i++){
            System.out.println(fields);
        }
        */
        _GuestID = fields[0].trim();
        _LastName = fields[2].trim();

        if (OldGuest.getGuestID().equals(_GuestID)) {
            return strLine;
        } //if
        else if (OldGuest.getLastName().equals(_LastName)) {
            return strLine;
        }
    } //for
    return "No matching guests in database";
}  //method

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Methods: DBmodifyCustomerRecord(String reservationFile,String CustomerName, String checkInDate, int fieldPosition, String newValue)
//------------------------------------------------------------------------------------------------------------

public static int  DBmodifyCustomerRecord(String reservationFile, String GuestID, String CustomerName, int fieldPosition, String newValue){
//Variables

int nReturnValue = 0;
int iCount = 0;
int nRecCount = 0;
String strLine = null;
String[] fields = null;
String[] newRecordFields = null;
Iterator it = null;
ArrayList theRecords = new ArrayList();

//Code
//the KEY Values are GuestID && CustomerName

/*
if (fieldPosition >= 1 && fieldPosition < 8) {
   
}
else {
    return INVALID_RESERVATION_FIELD_POSITION;
}
*/
newValue = newValue.trim();

if (0 == newValue.length()  || newValue.equals(" ")) {
    return INVALID_RESERVATION_NEW_VALUE;
}

try {
    theRecords = DBreadFile(reservationFile);
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

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBfindOneCustomer(String reservationFile,String CustomerName)
//param 2	: CustomerName String	the Key	"Collin Partee"  or "Alan Jones"
//returns  : ArrayList of Strings
//------------------------------------------------------------------------------------------------------------

public static ArrayList DBOneCustomer(String reservationFile,String CustomerName) {
//Variables
String strLine = null;
String[] fields = null;
ArrayList theRecords = new ArrayList();

try {
//Get all the file records in the Array
    
    theRecords = DBreadFile(reservationFile);
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
*/


    if (!CustomerName.equals(_LastName)) {
        it.remove();

    } //if

} //for

return theRecords;

}  //method



//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: getAllReservationRecords()
//------------------------------------------------------------------------------------------------------------
public static ArrayList getAllReservationRecords()

{

// Variables

String DBfileName = null;
ArrayList records = new ArrayList();

DBfileName = DBgetReservationFileName();

records = DBreadFile(DBfileName); 

return records;


}

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBreadFile(String filename)
//------------------------------------------------------------------------------------------------------------
public static ArrayList DBreadFile(String reservationFile){
    ArrayList records = new ArrayList();
    
    try {
        BufferedReader reader = new BufferedReader(new FileReader(reservationFile));
        
        String line;
        
        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.length() < 10  ||  line.equals(" ")) {
            // this is a blank line ...so skip it
            }

            else {
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
//Method: DBappendToEndOfFile(String fullPathFileName, String newRecord)
//------------------------------------------------------------------------------------------------------------
public static int DBappendToEndOfFile(String reservationFile, String newRecord) {

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
        */

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


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBremoveRecord(String fullPathFileName, String deleteRecord)
//------------------------------------------------------------------------------------------------------------
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

//Code
if (DBisValidRecord(delRecord) != true) {
    //the Record was not valid; so do not process it
    return FAILED_INVALID_RECORD;
}


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
}  //method



//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBisValidRecord(String dbRecord)
//------------------------------------------------------------------------------------------------------------


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
}//method


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBwriteArrayToFile(String reservationFile, ArrayList theRecords, boolean bWriteNewFile)
//------------------------------------------------------------------------------------------------------------
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

while(i < theRecords.size()) {

      System.out.println(theRecords.get(i));

      i++;

}  //while



//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Test the DBreadFile method
//--------------------------------------------------------------------------------------


/*
ArrayList theRecords = new ArrayList();

theRecords = DBreadFile(reservationFile);



int i = 0;

while(i < theRecords.size()) {

      System.out.println(theRecords.get(i));

      i++;

}  //while

*/


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Test: DBfindOneCustomer(String fileName,String CustomerName)
//-------------------------------------------------------------------------------


/*
ArrayList theRecords = new ArrayList();

theRecords = DBfindOneCustomer(reservationFile, "Collin Partee");



int i = 0;

while(i < theRecords.size()) {

      System.out.println(theRecords.get(i));

      i++;

}  //while

*/


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Test:	DBappendToEndOfFile(String fullPathFileName, String newRecord)
//-------------------------------------------------------------------------------

/*
//Variables
int nReturnValue = 0;

//Code
nReturnValue = DBappendToEndOfFile(reservationFile, "10,Bruce Bruce, 14 Whitehall Place, 9999999999, blah@blah.com, apples");
if (nReturnValue == SUCCESSFUL_OPERATION) {
    System.out.println("\n New record has been added successfully.");
}  //if

if (nReturnValue == 2) {
    System.out.println("\n Error in adding new record");
}  //if

if (nReturnValue == FAILED_DUPLICATE_RECORD ) {
    System.out.println("\n Unable to add record because this record is a duplicate.");
}   //if

*/


//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Test:	DBmodifyCustomerRecord(String reservationFile,String CustomerName, String checkInDate,  int fieldPosition, String newValue)
//--------------------------------------------------------------------------------------

/*
//Variables
int nReturnValue = 0;
String GuestID = null; 
String CustomerName = null;
int fieldPosition = 0; 
String newValue	= null;

//Code
GuestID = "9";
CustomerName = "Bruce Smith";
fieldPosition = 2;
newValue = "Colin Portee";

System.out.println("\n Modify invoked");

nReturnValue = DBmodifyCustomerRecord(reservationFile,GuestID, CustomerName,  fieldPosition, newValue);

if (SUCCESSFUL_OPERATION == nReturnValue) {
    System.out.println("\n Successfullyy Modified ...");
}

if (FOUND_RECORD_TO_MODIFY  == nReturnValue) {
    System.out.println("\n this useful when testing ....");
}

if (FAILED_MODIFIED_RECORD  == nReturnValue) {
    System.out.println("\n Failed to modify the record");
}

if (NO_MODIFY_RECORD_ABSENT  == nReturnValue) {
    System.out.println("\n Modification failed...no record found");
}

if (INVALID_RESERVATION_FIELD_POSITION == nReturnValue) {
    System.out.println("\n Modification failed...invalid field position");
}

if (INVALID_RESERVATION_NEW_VALUE  == nReturnValue) {
    System.out.println("\n Modification failed...invalid new value ");
}

*/

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Test: DBremoveRecord(String fullPathFileName, String recordToBeDeleted)
//--------------------------------------------------------------------------------------
/*
//Variables
int nReturnValue = 0;

//Code
nReturnValue = DBremoveRecord(reservationFile, "1,Collin Portee, 14 Whitehall Place, 9999999999, blah@blah.com, apples");

if (nReturnValue == SUCCESSFUL_OPERATION) {
    System.out.println("\n New record has been deleted successfully.");
}  //if

if (nReturnValue == FAILED_DELETED_RECORD) {
    System.out.println("\n Error in deleting record");
}  //if

if (nReturnValue == NO_DELETE_RECORD_ABSENT) {
    System.out.println("\n Unable to delete record because this record was not present.");
}   //if

*/



} //main

} //class



/* ======================================================

* File: Hotel_reservation.txt Sample

* 

* ------------------------------------------------------

1,Collin Partee, 14 Whitehall Place, 9999999999, blah@blah.com, apples
2,Shelly Wilson, 14 Whitehall Place, 9999999999, blah@blah.com, apples
3,Lisa Wool, 14 Whitehall Place, 9999999999, blah@blah.com, apples
4,Frank Jones, 14 Whitehall Place, 9999999999, blah@blah.com, apples
5,Collin Partee, 14 Whitehall Place, 9999999999, blah@blah.com, apples
6,Zeta Jones, 14 Whitehall Place, 9999999999, blah@blah.com, apples
7,Pete Marks, 14 Whitehall Place, 9999999999, blah@blah.com, apples
8,Mark Sewald, 14 Whitehall Place, 9999999999, blah@blah.com, apples
9,Bruce Smith, 14 Whitehall Place,9999999999,blah@blah.com, apples




*/





///STOP