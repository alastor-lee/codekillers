/*
 * THIS CLASS WILL CREATE A UNIQUE ID FOR GUESTS BEING ADDED TO SYSTEM
 * HAS ACCESS TO THE GUEST DB
 */
package engine;

import java.io.*;
import java.util.*;

public class GuestIDManager {
    //IMPORTANT: gets path to database files 
    int intGuestCount;
    String nameOfFile = new File("").getAbsolutePath()+"\\database_files\\guestDatabaseFile.txt";
    String strLine, strGlobalCount;
    String[] fields;
    ArrayList dataFile = new ArrayList();
    File file = new File(nameOfFile);
    FileWriter writer;
    
    public String createGuestID() {
        try {
            dataFile = DatabaseReader.DBreadFile(nameOfFile);        
            strLine = (String)dataFile.get(0);
            fields = strLine.split(":");
            strGlobalCount = fields[1];
            intGuestCount = Integer.parseInt(strGlobalCount);
            globalIDUpdate(intGuestCount, dataFile);
            return strGlobalCount;
        }
        catch(Exception ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString());
            return null;
        }
    }
        
    public void globalIDUpdate(int count, ArrayList oldFile){
        String newCount;
        count++;    //increments global ID count
        newCount = "DB1 Guest DB:"+Integer.toString(count);
        oldFile.set(0, newCount);  //should set new String w/ updatead count
        try {
            writer = new FileWriter(file, true);
            PrintWriter printer = new PrintWriter(writer);
            Iterator itr = oldFile.iterator();
            while(itr.hasNext()){
                printer.write(itr.toString());
                itr.next();
            }
        }
        catch(IOException ee) {
            System.err.println("Error: " + ee.getMessage() +"..stack: " + ee.getStackTrace().toString() );
            ee.printStackTrace();
        }
    }
}
