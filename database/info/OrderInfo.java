/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.info;

import java.util.ArrayList;

public class OrderInfo {
    //guest variables
    String OrderID;
    String GuestID;
    String FirstName;
    String LastName;
    String RoomNumber;
    String OrderContents;
    String SpecialRequests;
    String TotalCost;
    String ReadyForPickup;
    String TimeStamp;
    
    //setters
    public String setOrderID(){
        engine.OrderIDManager idCreate = new engine.OrderIDManager();
        OrderID = idCreate.createGuestID();
        return OrderID;
    }
    //method overloading for search
    public void setOrderID(String a){
        OrderID = a;
    }
    public void setGuestID(String g){
        GuestID = g;
    }
    public void setFirstName(String b){
        FirstName = b;
    }
    public void setLastName(String c){
        LastName = c;
    }
    public void setRoomNumber(String d){
        RoomNumber = d;
    }
    public void setOrderContents(ArrayList e){
        String listString = arrayListToString(e);
        OrderContents = listString;
    }
    public void setSpecialRequests(String h){
        SpecialRequests = h;
    }
    public void setTotalCost(String f){
        TotalCost = f;
    }
    public void setReadyForPickup(String i){
        ReadyForPickup = i;
    }
    public void setTimeStamp(String k){
        TimeStamp = k;
    }
    //getters
    public String getOrderID(){
        return OrderID;
    }
    public String getGuestID(){
        return GuestID;
    }
    public String getFirstName(){
        return FirstName;
    }
    public String getLastName(){
        return LastName;
    }
    public String getRoomNumber(){
        return RoomNumber;
    }
    public String getOrderContents(){
        return OrderContents;
    }
    public String getSpecialRequests(){
        return SpecialRequests;
    }
    public String getTotalCost(){
        return TotalCost;
    }
    
    public String getReadyForPickup(){
        return ReadyForPickup;
    }
    public String getTimeStamp(){
        return TimeStamp;
    }
    //toString
    public String toString(){
        return OrderID + ";" + GuestID + ";" + FirstName + ";" + LastName + ";" + RoomNumber + ";" + OrderContents + ";" + SpecialRequests + ";" + TotalCost + ";" + ReadyForPickup + ";" + TimeStamp; 
    }
    
    public String arrayListToString(ArrayList<String> list) {
        String listString = "";

        for (String s : list) {
            listString += s + ",";
        }
        return listString;
    }
}
