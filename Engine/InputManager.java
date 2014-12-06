/*
 * THIS CLASS IS MEANT TO VERIFY ALL USER INPUT
 */
package engine;

import mainframe.gui.LoginFrame;

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
}
