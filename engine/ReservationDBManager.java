
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


import java.lang.reflect.*;





public class ReservationDBManager {

public static String _GuestID;
public static String _RoomNumber;
public static String _CheckIn;
public static String _CheckOut;
public static String _Occupancy;
public static String _Preference;
public static String _Comments;
public static String _RoomType;



static final int recPosition_RoomNumber = 1;
static final int recPosition_CheckIn_Date	= 2;
static final int recPosition_CheckOut_Date = 3;
static final int recPosition_Occupancy = 4;
static final int recPosition_Preference = 5;
static final int recPosition_Comments = 6;
static final int recPosition_RoomType = 7;

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


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: DBmodifyCustomerRecord(String reservationFile,String CustomerName, int fieldPosition, String newValue)
//------------------------------------------------------------------------------------------------------------
public static int  DBmodifyRoomRecord(String reservationFile, String GuestID, String RoomNumber, int fieldPosition, String newValue){
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
//the KEY Values are GuestID && RoomNumber

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
        _RoomNumber = fields[1].trim();
        _CheckIn = fields[2].trim();
        _CheckOut = fields[3].trim();
        _Occupancy = fields[4].trim();
        _Preference = fields[5].trim();
        _Comments = fields[6].trim();
        _RoomType = fields[7].trim();



//If all fields in the newRecord are the same as all the fields in theRecords then FAILED MODIFIED RECORD

if (_GuestID.trim().equalsIgnoreCase(GuestID.trim()) && _RoomNumber.trim().equalsIgnoreCase(_RoomNumber.trim()) )  {   
    
    System.out.println("\n Checkpoint 2  \n");
    
    System.out.println(_RoomNumber);
    
    switch (fieldPosition) {
        case 1:  _GuestID = newValue;
        break;
        
        case 2:  _RoomNumber  = newValue;
        break;

        case 3:  _CheckIn = newValue;
        break;

        case 4:	_CheckOut = newValue;
        break;

        case 5:	_Occupancy = newValue;
        break;

        case 6:	_Preference = newValue;
        break;
            
        case 7:	_Comments = newValue;
        break;

        case 8:	_RoomType = newValue;
        break;
        default: nReturnValue = FAILED_MODIFIED_RECORD;
        break;    
    }  //switch
    
    
    System.out.println("\n Checkpoint 3");
    theRecords.remove(iCount);
    
    strLine = _GuestID + "," + _RoomNumber + ","  + _CheckIn   + ","  + _CheckOut + "," + _Occupancy   + "," + _Preference + "," + _Comments + "," + _RoomType;    
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
//Method: DBfindOneRoom(String reservationFile,String RoomNumber)
//param 2 : RoomNumber String the Key "1103"  or "2105"
//returns  : ArrayList of Strings
//------------------------------------------------------------------------------------------------------------

public static ArrayList DBfindOneRoom(String reservationFile,String RoomNumber)

{


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
    _RoomNumber = fields[1].trim();
   /* 
    _GuestID = fields[0].trim();
    _CustomerName = fields[1].trim();
    _Address = fields[2].trim();
    _ContactNumber = fields[3].trim();
    _Email = fields[4].trim();
    _Charges = fields[5].trim();
*/


    if (!RoomNumber.equals(_RoomNumber)) {
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

DBfileName = DBgetReseravtionFileName();

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
public static int DBappendToEndOfFile(String reservationFile, String newRecord)

{

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
        _RoomNumber = fields[1].trim();
        _CheckIn = fields[2].trim();
        _CheckOut = fields[3].trim();
        _Occupancy = fields[4].trim();
        _Preference = fields[5].trim();
        _Comments = fields[6].trim();
        _RoomType = fields[7].trim();


        if (_GuestID.trim().equalsIgnoreCase(newRecordFields[0].trim()) && 
            _RoomNumber.trim().equalsIgnoreCase(newRecordFields[1].trim()) &&
            _CheckIn.trim().equalsIgnoreCase(newRecordFields[2].trim()) &&
            _CheckOut.trim().equalsIgnoreCase(newRecordFields[3].trim()) &&
            _Occupancy.trim().equalsIgnoreCase(newRecordFields[4].trim()) &&
            _Preference.trim().equalsIgnoreCase(newRecordFields[5].trim()) &&
            _Comments.trim().equalsIgnoreCase(newRecordFields[6].trim()) &&
            _RoomType.trim().equalsIgnoreCase(newRecordFields[7].trim())) 
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
            _RoomNumber = fields[1].trim();
            _CheckIn = fields[2].trim();
            _CheckOut = fields[3].trim();
            _Occupancy = fields[4].trim();
            _Preference = fields[5].trim();
            _Comments = fields[6].trim();
            _RoomType = fields[7].trim();

            //
            //If all of the fields in the newRecord are equal to theRecords 
            //Record theres an error
            //

            iCount++;
            
            if (_GuestID.trim().equalsIgnoreCase(delRecordFields[0].trim()) &&
                _RoomNumber.trim().equalsIgnoreCase(delRecordFields[1].trim()) &&
                _CheckIn.trim().equalsIgnoreCase(delRecordFields[2].trim()) &&
                _CheckOut.trim().equalsIgnoreCase(delRecordFields[3].trim()) &&
                _Occupancy.trim().equalsIgnoreCase(delRecordFields[4].trim()) &&
                _Preference.trim().equalsIgnoreCase(delRecordFields[5].trim()) &&
                _Comments.trim().equalsIgnoreCase(delRecordFields[6].trim()) &&
                _RoomType.trim().equalsIgnoreCase(delRecordFields[7].trim())) 
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
boolean bReturnValue	= false;

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
//Method: DBgetReseravtionFileName()
//------------------------------------------------------------------------------------------------------------
public static String DBgetReseravtionFileName() {
//
//return the String name
//
return "/Users/collinpartee/Desktop/TESTroomDB.txt ";

} //


//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//Method: main(String[] args)
//------------------------------------------------------------------------------------------------------------

public static void main(String[] args) {



String reservationFile = "/Users/collinpartee/Desktop/TESTroomDB.txt";
/*
ArrayList theRecords = new ArrayList();

theRecords = getAllReservationRecords();


int i = 0;

while(i < theRecords.size()) {

      System.out.println(theRecords.get(i));

      i++;

}  //while
*/


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
//Test: DBfindOneRoom(String fileName,String RoomNumber)
//-------------------------------------------------------------------------------


/*
ArrayList theRecords = new ArrayList();

theRecords = DBfindOneRoom(reservationFile, "1101");



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
nReturnValue = DBappendToEndOfFile(reservationFile, "9,2201, 18 April 2014, 19 April 2014, 3, No View, no comments, Twin");
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
//Test:	DBmodifyRoomRecord(String reservationFile,String CustomerName, String RoomNumber,  int fieldPosition, String newValue)
//--------------------------------------------------------------------------------------

/*
//Variables
int nReturnValue = 0;
String GuestID = null; 
String RoomNumber = null;
int fieldPosition = 0; 
String newValue	= null;

//Code
GuestID = "8";
RoomNumber = "2201";
fieldPosition = recPosition_CheckIn_Date;
newValue = "19 April 2014";

System.out.println("\n Modify invoked");

nReturnValue = DBmodifyRoomRecord(reservationFile,GuestID, RoomNumber,  fieldPosition, newValue);

if (SUCCESSFUL_OPERATION == nReturnValue) {
    System.out.println("\n Successfully Modified ...");
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
nReturnValue = DBremoveRecord(reservationFile, "9,2201, 18 April 2014, 19 April 2014, 3, No View, no comments, Twin");

if (nReturnValue == SUCCESSFUL_OPERATION) {
    System.out.println("\n Record has been deleted successfully.");
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

* File: TESTroom_reservationDB.txt Sample

* 

* ------------------------------------------------------

1,1101, 12 Nov 2014, 14 Nov 2014, 3, Beach View, smoking room, Suite
2,2101, 12 Dec 2014, 14 Dec 2014, 1, Road View, no comments, Suite
3,1103, 14 Nov 2014, 15 Nov 2014, 4, No Preference, need an extra bed, Twin
4,1105, 12 Jan 2014, 16 Jan 2014, 3, No Preference, smoking room, Twin
5,1107, 1 Dec 2014, 4 Dec 2014, 3, Beach View, no comments, Deluxe
6,1102, 22 Nov 2014, 24 Nov 2014, 2, Beach View, no comments, Suite
7,4101, 1 Nov 2014, 10 Nov 2014, 2, Road View, no comments, Queen
8,3101, 18 Nov 2014, 19 Nov 2014, 3, Road View, no comments, Twin





*/





///STOP