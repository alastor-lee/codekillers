/*
 * THIS CLASS IS MEANT TO VERIFY ALL USER INPUT
 */
package engine;

import mainframe.gui.LoginFrame;
import java.util.*;

public class InputManager {
    
    //ADDRESS ERRROR CHECKING
    //returns 2 for error, 0 otherwise
    public int checkAddress(String a) {
        //needs slight modification, allow "." in street name
        if(!a.matches("([0-9]+ ){1}([A-Z]*?[a-z]*? )+([A-Z]*?[a-z]*?, ){1}[A-Z]{2} ([0-9]+){1}")){
            return 2;
        }
        return 0;
    }
    //phone number error checking
    //NEED TO CHANGE THIS TO REGEX
    public int checkPhoneNum(String phone) {
        //anything other than a dash is considered error
        phone = phone.replaceAll("-", "");
        //checking length
        if(phone.length() > 10 || phone.length() < 10){
            return 3;
        }
        //checking that the string is all numbers
        char num;
        int asciiVal;
        for(int i=0; i<phone.length(); i++) {
            num = phone.charAt(i);
            asciiVal = (int)num;
            if(asciiVal < 48 || asciiVal > 57){
                return 3;
            }
        }
        return 0;
    }
    //email address error checking
    //need to modfiy to allow the many chars allowed in email addresses
    public int checkEmail(String e){
        if(!e.matches("(.+@{1}){1}([a-zA-Z]+[\\.]{1})+[a-zA-Z]+")){
            return 4; 
        }
        return 0;
    }
    
    public static int validateUser(String userName, char[] password){
        int userlevel = 0; //Should be initially set to 0. It is set to 1 here so that you can log-in without username or password.
        // Need to query UserDB here to check if username and password combo exists.
        // If it does, set userlevel = int.
        // 1 = Front Desk
        // 2 = Restaurant Host
        // 3 = Kitchen Employee
        // 4 = Manager
        database.info.UserInfo UserSearch = new database.info.UserInfo();
        UserSearch.setUserName(LoginFrame.LoginField.getText());
        UserSearch.setPassword(LoginFrame.PasswordField.getPassword());
        //System.out.println("TESTING USER INPUT: "+LoginFrame.LoginField.getText() + " " + LoginFrame.PasswordField.getPassword());
        //System.out.println("TESTING VARS SET IN GUESTINFO: "+UserSearch.getUserName() + " " + UserSearch.getPassword());
        
        //TEST GuestInfoText.setText(IDField.getText()+"\n"+LastNameField.getText());        
        engine.UserDBManager manager = new engine.UserDBManager();
        int searchReturn = manager.searchDB(UserSearch);
        System.out.println("Is valid user? "+searchReturn);
        userlevel = searchReturn;
        return userlevel;
    }
    
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false; //is not an integer
        }
        return true; //is an integer
    }
    
    public static boolean isPositiveInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false; //is not an integer
        }
        if(Integer.parseInt(s) > 0){
            return true; //is an integer
        } else {
            return false;
        }
    }
    
    //following is for reservation input validation
    //checks for existence of guest in DB when attempting to create a reservation
    //searches for existence of given guestID
    public int checkIfExist(String id, String fileName){
        String[] allFields; //used for holding each line in DB at a time
        String currID;  //to hold ID of guest at that line
        int IDcheck = 2;    //starts w/ error value
        ArrayList guestDB = new ArrayList();
        guestDB = DatabaseReader.DBreadFile(fileName);  //reading from DB
        Iterator itr = guestDB.iterator();
        itr.next(); //skips first line, which is the name of file
        while(itr.hasNext()){
            allFields = itr.next().toString().split(";");   //pulling line from file
            currID = allFields[0];  //currID set to ID of given line
            //System.out.println("field value: "+allFields[0]+" searching for: "+id);
            if(currID.equals(id)){
                //System.out.println("there is an ID match");
                IDcheck = 0;    //there is a match, and tf no error
                return IDcheck; //ends loop
            }
        }
        return IDcheck;
    }
    
    //checking that the room number requested matches predefined rules
    public int verifyRoomNum(int RoomNum, int type, int prefs){
        System.out.println("type: "+type+" prefs: "+prefs);
        if((RoomNum >= 100 && RoomNum <= 120)||(RoomNum >= 200 && RoomNum <= 220)||(RoomNum >= 300 && RoomNum <= 320)){
            //checking for type rule following
            switch(type) {
            //0 - Two Double Beds, 1 - One King Bed, 2 - Suite
            case 0: System.out.println("case 0 type");
                    if(RoomNum > 110||RoomNum > 210||RoomNum > 310){
                        System.out.println("Need two double bed");
                        break;
                    } else return 7;
            case 1: System.out.println("case 1 type");
                    if(!((RoomNum >= 103 && RoomNum <= 110)||(RoomNum >= 203 && RoomNum <= 210)||(RoomNum <= 303 && RoomNum <= 310))){
                        System.out.println("Need one king bed");
                        return 7;
                    } else break;
            case 2: System.out.println("case 2 type");
                    if(!(RoomNum <= 102||RoomNum <= 202||RoomNum <= 302)){
                        System.out.println("Need suite");
                        return 7;
                    } else break;
            default: System.out.println("Something is very wrong");
            }
            //checking for special preference rule following
            switch(prefs) {
            //0 - Beach View, 1 - Land View, 2 - Near Smoking Area
            case 0: System.out.println("case 0 prefs");
                    if(!(RoomNum <= 105||RoomNum <= 205||RoomNum <= 305)){
                        System.out.println("Need beach view");
                        return 7;
                    } else break;
            case 1: System.out.println("case 1 prefs");
                    if(!(RoomNum > 105||RoomNum > 205||RoomNum > 305)){
                        System.out.println("Need land view");
                        return 7;
                    } else break;
            case 2: System.out.println("case 2 prefs");
                    if(!(RoomNum <= 110||RoomNum <= 210||RoomNum <= 310)){
                        System.out.println("Need smoking area");
                        return 7;
                    } else break;
            default: System.out.println("Something is very wrong");
            }
            return 0;
        } else return 7; //RoomNum is not within valid boundaries
    }
}
