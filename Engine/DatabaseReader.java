/*
 * This class is primariy for the use of the 
 * DBreadFile static method, which is essential
 * for all classes handling data files
 */
package engine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DatabaseReader {
    
     //DBreadFile is important to all database handling, as it reads the entire
    //database file into an Arraylist in which each index refers to a line in the file
    //The file path is passed in through a String, and an Arraylist containing the entire data file
    //is returned out.
    //THIS METHOD IS NEEDED FOR EVERY DATABASE MANAGER CLASS
    public static ArrayList DBreadFile(String reservationFile){
        System.out.println(reservationFile);
        ArrayList records = new ArrayList();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(reservationFile));
            String line;
            //MAKE SURE reader.readLine() is set to line, as this conditional
            //will not work otherwise, even when manually casting as a (String)
            //Unclear as to why
            while ((line = reader.readLine()) != null) {
                //line = reader.readLine();   //readline method works off of \n character as line designator 
                line = line.trim(); //cleaning up
                if (!line.equals(" ")) {
                    records.add(line);  //if line is not empty, add it to next spot in Arraylist records
                }
            }        
            reader.close();
            return records;     //Arraylist with data file is returned to calling method
        }
        catch (Exception e) { 
            System.out.println("Exception occurred trying to read.");
            e.printStackTrace();
            return null;
        }
    }
}
