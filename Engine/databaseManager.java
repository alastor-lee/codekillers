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
    //variables here
    String guestID;
    String firstName;
    String lastName;
    String phoneNum;
    String address;
    String email;
    
    //constructors
    public databaseManager(String ID, String fName, String lName, String phone, String addr, String mail) {
        guestID = ID;
        firstName = fName;
        lastName = lName;
        phoneNum = phone;
        address = addr;
        email = mail;
    }
    


   //method for creating new guest(passed from NewGuestCreate class)
    public void addGuest(database.GuestInfo a) {
        database.GuestDB GuestAdder = new database.GuestDB();
        //sending guest information to GuestDB handler
        System.out.println(GuestAdder.addGuest(a));
    }
    
    public String findGuest(database.GuestInfo a) {
        database.GuestDB GuestSearcher = new database.GuestDB();
        return GuestSearcher.searchDB(a);
    }
    

}
