/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

/**
 *
 * @author alastor
 */
public class databaseManager {
    
    public databaseManager() {
        //init here
    }
    
    public databaseManager(String ID, String fName, String lName, String phone, String addr, String mail) {
        guestID = ID;
        firstName = fName;
        lastName = lName;
        phoneNum = phone;
        address = addr;
        email = mail;
    }
    
    //variables here
    String guestID;
    String firstName;
    String lastName;
    String phoneNum;
    String address;
    String email;

   //method for creating new guest(passed from NewGuestCreate class)
    public void addGuest(String ID, String fName, String lName, String phone, String addr, String mail) {
        database.GuestDB NewGuest = new database.GuestDB(ID, fName, lName, phone, addr, mail);
        //System.out.println(_GuestID + " " + _FirstName + " "+ _LastName + " " + _ContactNumber + " " + _Address + " " + _Email);
        System.out.println(NewGuest.addGuest());
    }
    

}
