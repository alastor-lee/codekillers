/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.info;

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
    engine.InputManager verify = new engine.InputManager();
    //setters
    //going to search to make sure guest curently exists in DB
    public int setGuestID(String ID){
        GuestID = ID;
        //return verify.checkIfExist(GuestID);
        return 0;
    }
    
    public int setNumOfPersons(String numOf){
        NumOfPersons = numOf;
        return 0;
    }
    
    public int setTypeOfRoom(String type){
        TypeOfRoom = type;
        return 0;
    }
    //inputManager handles time clashes within preexisting reservations
    public int setCheckIn(String timeIn){
        
        return 0;
    }
    //inputManager handles time clashes within preexisting reservations
    public int setCheckOut(String timeOut){
        
        return 0;
    }
    
    public int setRoomNum(String numOf){
        
        return 0;
    }
    
    public int setSpecialPref(int pref){
        
        return 0;
    }
    
    public int setComments(String coms){
        
        return 0;
    }
    public String toString(){
        return GuestID+" "+NumOfPersons+" "+TypeOfRoom+" "+CheckIn+" "+CheckOut+" "+RoomNum+" "+SpecialPref+" "+Comments;
    }
}
