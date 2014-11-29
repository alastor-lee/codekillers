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
public class GuestDBWriter {
    
    public GuestDBWriter() {
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
    public GuestDBWriter(String ID, String fName, String lName, String phone, String addr, String mail) {
        guestID = ID;
        firstName = fName;
        lastName = lName;
        phoneNum = phone;
        address = addr;
        email = mail;
    }
    


   //method for creating new guest(passed from NewGuestCreate class)
    public void addGuest(database.info.GuestInfo a) {
        database.info.GuestDB GuestAdder = new database.info.GuestDB();
        //sending guest information to GuestDB handler
        System.out.println(GuestAdder.addGuest(a));
    }
    
    public String findGuest(database.info.GuestInfo a) {
        database.info.GuestDB GuestSearcher = new database.info.GuestDB();
        return GuestSearcher.searchDB(a);
    }
    

}
