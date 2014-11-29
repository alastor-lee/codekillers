/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.info;

/**
 *
 * @author alastor
 */
public class GuestInfo {
    //guest variables
    String GuestID;
    String FirstName;
    String LastName;
    String Address;
    String ContactNum;
    String Email;
    //InputManager handles input error checking
    engine.InputManager verify = new engine.InputManager();
    //setters
    public void setGuestID(String a){
        GuestID = a;
    }
    public void setFirstName(String b){
        FirstName = b;
    }
    public void setLastName(String c){
        LastName = c;
    }
    public int setAddress(String d){
        Address = d;
        //if return value is 1, there is an error
        return verify.checkAddress(Address);
    }
    public int setContactNum(String e){
        ContactNum = e;
        //if returned value is 2, there is an error
        return verify.checkPhoneNum(ContactNum);
    }
    public int setEmail(String f){
        Email = f;
        //if returned value is 3, there is an error
        return verify.checkEmail(Email);
    }
    //getters
    public String getGuestID(){
        return GuestID;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getAddress(){
        return Address;
    }
    public String getContactNum(){
        return ContactNum;
    }
    public String getEmail(){
        return Email;
    }
    //toString
    public String toString(){
        return GuestID + ";" + FirstName + ";" + LastName + ";" + Address + ";" + ContactNum + ";" + Email; 
    }
}
