/*
 * THIS CLASS WILL CREATE A UNIQUE ID FOR GUESTS BEING ADDED TO SYSTEM
 * HAS ACCESS TO THE GUEST DB
 */
package engine;

import java.io.*;
import java.util.*;

public class GuestIDManager {
    int intGuestCount;
    //Getting path to guest database file
    String nameOfFile = new File("").getAbsolutePath()+"\\database_files\\guestDatabaseFile.txt";
    String strLine, strGuestCount;
    String[] fields;
    ArrayList dataFile = new ArrayList();   //will have file contents
    File file = new File(nameOfFile);   //for writing
    FileWriter writer;
    RandomAccessFile clearWrite;
    
    //opens and reads file to find current guest count for ID creation
    public String createGuestID() {
        try {
            dataFile = DatabaseReader.DBreadFile(nameOfFile);
            //if(dataFile.size() >= 1) {  //MAKING SURE FILE IS READ PROPERLY
                strLine = (String)dataFile.get(0);  //getting first line of file
            //} else return "file is not being read properly";
            fields = strLine.split(":");    //splitting up first line to find needed var
            strGuestCount = fields[1];
            System.out.println("curr val from array: "+fields[1]+" from String: "+strGuestCount);  //TEST
            globalIDUpdate();    //calling other class method to update guest count
            return strGuestCount;   //this is not changed by globalIDUpdate
        }
        catch(Exception ee) {
            System.err.println("ID read Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString());
            return null;
        }
    }
    //writes information back into file to update global guest count
    public void globalIDUpdate(){
        String newCount;
        intGuestCount = Integer.parseInt(strGuestCount.trim());   //for incrementing
        intGuestCount++;    //incrementing for future guest add
        System.out.println("new count: "+intGuestCount);    //TEST
        newCount = "DB1 Guest DB:"+Integer.toString(intGuestCount);
        newCount.replace("\n", ""); //clearing all \n chars
        //System.out.println("to be written: "+newCount);   //TEST
        dataFile.set(0, newCount);  //do not put \n here
        System.out.println("new first line: "+dataFile.get(0));
        //clearing and rewriting file
        try {
            writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(file);
            writer.write("");
            Iterator itr = dataFile.iterator();
            while(itr.hasNext()){
                strLine = itr.next().toString();
                printer.write(strLine+"\n");
                System.out.println("written to file: "+strLine);    //TEST
                System.out.println("SUCCESSFUL WRITE");     //TEST
            }
            printer.close();
        }
        catch(IOException ee) {
            System.err.println("Id writer error: " + ee.getMessage() +", stack: " + ee.getStackTrace().toString() );
            ee.printStackTrace();
        }
    }
}
