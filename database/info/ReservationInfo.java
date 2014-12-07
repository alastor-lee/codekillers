/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.info;

import java.io.File;

public class ReservationInfo {
    //class variables 
    String GuestID;
    String NumOfPersons;
    String TypeOfRoom;
    String CheckIn;
    String CheckOut;
    String RoomNum;
    String SpecialPref;
    String Comments;
    String pathToGuestDB = new File("").getAbsolutePath()+"\\database_files\\guestDatabaseFile.txt";
    boolean test;
    engine.InputManager verify = new engine.InputManager();
    //setters
    //going to search to make sure guest curently exists in DB
    
    public int setGuestID(String ID){
        GuestID = ID;
        System.out.println(verify.checkIfExist(GuestID, pathToGuestDB));
        return verify.checkIfExist(GuestID, pathToGuestDB);    //2 = error
    }
    
    public int setNumOfPersons(String numOf){
        NumOfPersons = numOf;
        test = verify.isInteger(NumOfPersons);
        if(test == true){
            //simple input handling. no more than 6 people per any room
            if(Integer.parseInt(NumOfPersons) > 6 || Integer.parseInt(NumOfPersons) < 1){
                return 3;   //3 = error
            }
        } else{    //NumOfPersons is not an Integer, automatic error
            return 3;   //3 = error
        }
        return 0;
    }
    
    public void setTypeOfRoom(String type){
        TypeOfRoom = type;
        //no error handling needed
        //0 - Two Double Beds, 1 - One King Bed, 2 - Suite
    }
    //inputManager handles time clashes within preexisting reservations
    public int setCheckIn(String timeIn){
        CheckIn = timeIn;
        //TODO: handle
        return 0;
    }
    //inputManager handles time clashes within preexisting reservations
    public int setCheckOut(String timeOut){
        CheckOut = timeOut;
        //TODO: handle
        return 0;
    }
    
    public int setSpecialPref(String pref){
        SpecialPref = pref;
        //no error handling needed
        //0 - Beach View, 1 - Land View, 2 - Near Smoking Area
        return 0;
    }
    
    public int setRoomNum(String numOf){
        RoomNum = numOf;
        //SPECIAL PREFERENCE RULES
        //rooms 100-105, 200-205, and 300-305 are beach view
        //rooms 106-120, 206-220, 306-320 are land view
        //rooms 100-110, 200-210, and 300-310 are near smoking areas
        //TYPE OF ROOM RULES
        //rooms 100-102, 200-202, and 300-302 are Suites
        //rooms 103-110, 203-210, and 303-310 are One King Size Bed
        //rooms 111-120, 211-220, and 311-320 are Two Double Bed
        //verify.checkRoomNum(numOf, )
        return 0;
    }
    
    public int setComments(String coms){
        //anything goes
        Comments = coms;
        return 0;
    }
    //for use by databaseManager class
    public String toString(){
        return GuestID+";"+NumOfPersons+";"+TypeOfRoom+";"+CheckIn+";"+CheckOut+";"+RoomNum+";"+SpecialPref+";"+Comments;
    }
}
