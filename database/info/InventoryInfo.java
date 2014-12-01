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
    String ItemID;
    String ItemName;
    String ItemQuantity;
    
    //InputManager handles input error checking
    //engine.InputManager verify = new engine.InputManager();
    
    //setters
    public void setItemID(String a){
        ItemID = a;
    }
    public void setItemName(String b){
        ItemName = b;
    }
    public void setItemQuantity(String c){
        ItemQuantity = c;
    }
    
    //getters
    public String getItemID(){
        return ItemID;
    }
    public String getItemName(){
        return ItemName;
    }
    public String getItemQuantity(){
        return ItemQuantity;
    }
    
    //toString
    public String toString(){
        return ItemID + ";" + ItemName + ";" + ItemQuantity; 
    }
}
