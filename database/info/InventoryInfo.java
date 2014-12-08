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
