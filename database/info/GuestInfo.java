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
    public void setAddress(String d){
        Address = d;
    }
    public void setContactNum(String e){
        ContactNum = e;
    }
    public void setEmail(String f){
        Email = f;
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
