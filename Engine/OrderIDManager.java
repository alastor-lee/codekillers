/*
 * THIS CLASS WILL CREATE A UNIQUE ID FOR GUESTS BEING ADDED TO SYSTEM
 * HAS ACCESS TO THE GUEST DB
 */
package engine;

import java.io.*;
import java.util.*;

public class OrderIDManager {
    int intOrderCount;
    //Getting path to guest database file
    String nameOfFile = new File("").getAbsolutePath()+"\\database_files\\orderDatabaseFile.txt";
    String strLine, strOrderCount;
    String fields;
    ArrayList dataFile = new ArrayList();   //will have file contents
    File file = new File(nameOfFile);   //for writing
    FileWriter writer;
    RandomAccessFile clearWrite;
    
    //opens and reads file to find current guest count for ID creation
    public String createGuestID() {
        
            dataFile = DatabaseReader.DBreadFile(nameOfFile);
            //if(dataFile.size() >= 1) {  //MAKING SURE FILE IS READ PROPERLY
                strLine = (String)dataFile.get(0);  //getting first line of file
            //} else return "file is not being read properly";
            fields = strLine.substring(21);    //splitting up first line to find needed var
            strOrderCount = fields;
            globalIDUpdate();    //calling other class method to update guest count
            return strOrderCount;   //this is not changed by globalIDUpdate
    }
    //writes information back into file to update global guest count
    public void globalIDUpdate(){
        String newCount;
        intOrderCount = Integer.parseInt(strOrderCount.trim());   //for incrementing
        intOrderCount++;    //incrementing for future guest add
        //System.out.println("new count: "+intGuestCount);    //TEST
        newCount = "DB4 Order History DB:"+Integer.toString(intOrderCount);
        newCount.replace("\n", ""); //clearing all \n chars
        //System.out.println("to be written: "+newCount);   //TEST
        dataFile.set(0, newCount);  //do not put \n here
        //clearing and rewriting file
        try {
            writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(file);
            writer.write("");
            Iterator itr = dataFile.iterator();
            while(itr.hasNext()){
                strLine = itr.next().toString();
                printer.write(strLine+"\n");
                //System.out.println("written to file: "+strLine);    //TEST
                //System.out.println("SUCCESSFUL WRITE");     //TEST
            }
            printer.close();
        }
        catch(IOException ee) {
            System.err.println("Id writer error: " + ee.getMessage() +", stack: " + ee.getStackTrace().toString() );
            ee.printStackTrace();
        }
    }
}
