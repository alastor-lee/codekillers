/*
 * THIS CLASS IS MEANT TO VERIFY ALL USER INPUT
 */
package engine;

public class InputManager {
    
    //methods
    //ADDRESS ERRROR CHECKING
    public int checkAddress(String a) {
        String[] addr;
        addr = a.split(" ");
        //TESTING
        //testing for all address information
        if (addr.length < 6 || addr.length > 6) {
            //address does not have enough fields
            System.out.println("wrong address length");
            return 2;
        }
        //Printing fields TEST
        /*
        for(int i=0; i<addr.length; i++){
            System.out.println(addr[i]);
        }
        */
        //checking for comma after city
        if(addr[3].charAt(addr[3].length()-1) != ',') {
            System.out.println("No comma, instead: "+addr[3].charAt(addr[3].length()-1));
            return 2;
        }
        //checking that state is in abbreviated form only
        if(addr[4].length() > 2 || addr[4].length() < 2) {
            System.out.println("Improper State input");
            return 2;
        }
        return 0;
    }
    //PHONE NUMBER ERROR CHECKING
    public int checkPhoneNum(String phone) {
        //anything other than a dash is considered error
        phone = phone.replaceAll("-", "");
        //checking length
        if(phone.length() > 10 || phone.length() < 10){
            return 3;
        }
        //checking that the string is all numbers
        char num;
        int asciiVal;
        for(int i=0; i<phone.length(); i++) {
            num = phone.charAt(i);
            asciiVal = (int)num;
            if(asciiVal < 48 || asciiVal > 57){
                return 3;
            }
        }
        return 0;
    }
    //EMAIL ADDRESS ERROR CHECKING
    public int checkEmail(String e){
        //using regex to verify email address format
        if(!e.matches("(.+@{1}){1}([a-zA-Z]+[\\.]{1})+[a-zA-Z]+")){
            return 4; 
        }
        return 0;
    }
}
