package database.info;

/**
 *
 * @author Colin
 */
public class UserInfo {
    //guest variables
    int UserID;
    String UserName;
    char[] Password;
    
    //InputManager handles input error checking
    //engine.InputManager verify = new engine.InputManager();
    
    //setters
    public void setUserID(int a){
        UserID = a;
    }
    public void setUserName(String b){
        UserName = b;
    }
    public void setPassword(char[] c){
        Password = c;
    }
    
    //getters
    public int getUserID(){
        return UserID;
    }
    public String getUserName(){
        return UserName;
    }
    public char[] getPassword(){
        return Password;
    }
    
    //toString
    public String toString(){
        return UserID + ";" + UserName + ";" + Password; 
    }
}
