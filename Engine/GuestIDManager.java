/*
 * THIS CLASS WILL CREATE A UNIQUE ID FOR GUESTS BEING ADDED TO SYSTEM
 * HAS ACCESS TO THE GUEST DB
 */
package engine;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class GuestIDManager {
    public static String createGuestID(String a){
        //IMPORTANT: gets path to database files 
        String nameOfFile = new File("").getAbsolutePath()+"\\database_files\\guestDatabaseFile";
        String strLine;
        String[] fields;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nameOfFile));
        }
        catch(Exception e) {
            System.out.println("Exception occured trying to read file");
            e.printStackTrace();
            return null;
        }
            return "hue";
    }
}
