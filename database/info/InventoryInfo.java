/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database.info;

/**
 *
 * @author Colin
 */
public class InventoryInfo {
    //guest variables
    String ItemName;
    String ItemQuantity;
    String ItemPrice;
    String ItemID;
    
    //InputManager handles input error checking
    //engine.InputManager verify = new engine.InputManager();
    
    //setters
    public void setItemName(String b){
        ItemName = b;
    }
    public void setItemID(String d){
        ItemID = d;
    }
    public void setItemQuantity(String c){
        ItemQuantity = c;
    }
    public void setItemPrice(String a){
        ItemPrice = a;
    }
    
    //getters
    public String getItemPrice(){
        return ItemPrice;
    }
    public String getItemName(){
        return ItemName;
    }
    public String getItemQuantity(){
        return ItemQuantity;
    }
    
    public String getItemID(){
        return ItemID;
    }
    
    //toString
    public String toString(){
        return ItemID + ";" + ItemName + ";" + ItemQuantity + ";" + ItemPrice; 
    }
}
