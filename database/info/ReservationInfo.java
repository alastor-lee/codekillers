
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
    String pathToReservDB = new File("").getAbsolutePath()+"\\database_files\\reservationDatabaseFile.txt";
    boolean test;
    int yearInt, monthIntIn,monthIntOut, dayInt;
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
        //Format: WEEKDAY, MONTH, DAY, TIME, ZONE, YEAR
        String[] dateFields;
        String year, month, day, INorOUT = "IN";
        dateFields = CheckIn.split(" "); //need fields 1, 2 and 5
        year = dateFields[5];
        month = dateFields[1];
        day = dateFields[2];
        //getting integer month from String version
        System.out.println("year: "+year+" month: "+month+" day: "+day); //TEST
        switch(month){
            case "Dec": monthIntIn = 12;
                break;
            case "Nov": monthIntIn = 11;
                break;
            case "Oct": monthIntIn = 10;
                break;
            case "Sep": monthIntIn = 9;
                break;
            case "Aug": monthIntIn = 8;
                break;
            case "Jul": monthIntIn = 7;
                break;
            case "Jun": monthIntIn = 6;
                break;
            case "May": monthIntIn = 5;
                break;
            case "Apr": monthIntIn = 4;
                break;
            case "Mar": monthIntIn = 3;
                break;
            case "Feb": monthIntIn = 2;
                break;
            case "Jan": monthIntIn = 1;
                break;
            default: System.out.println("Invalid Month"); 
                return 5;
        }
        yearInt = Integer.parseInt(year);
        dayInt = Integer.parseInt(day);
        CheckIn = Integer.toString(yearInt)+" "+Integer.toString(monthIntIn)+" "+Integer.toString(dayInt);
        System.out.println(CheckIn);    //TEST
        return verify.verifyDate(yearInt, monthIntIn, dayInt, pathToReservDB, RoomNum, INorOUT);
    }
    //inputManager handles time clashes within preexisting reservations
    public int setCheckOut(String timeOut){
        //Format: WEEKDAY, MONTH, DAY, TIME, ZONE, YEAR
        CheckOut = timeOut;
        String[] dateFields;
        String year, month, day, INorOUT = "OUT";
        dateFields = CheckOut.split(" "); //need fields 1, 2 and 5
        year = dateFields[5];
        month = dateFields[1];
        day = dateFields[2];
        //getting integer month from String version
        System.out.println("year: "+year+" month: "+month+" day: "+day); //TEST
        switch(month){
            case "Dec": monthIntOut = 12;
                break;
            case "Nov": monthIntOut = 11;
                break;
            case "Oct": monthIntOut = 10;
                break;
            case "Sep": monthIntOut = 9;
                break;
            case "Aug": monthIntOut = 8;
                break;
            case "Jul": monthIntOut = 7;
                break;
            case "Jun": monthIntOut = 6;
                break;
            case "May": monthIntOut = 5;
                break;
            case "Apr": monthIntOut = 4;
                break;
            case "Mar": monthIntOut = 3;
                break;
            case "Feb": monthIntOut = 2;
                break;
            case "Jan": monthIntOut = 1;
                break;
            default: System.out.println("Invalid Month"); 
                return 6;
        }
        //verifying that check out is after check in
        //check in setting must happen before check out setting for this to work correctly
        if(yearInt < Integer.parseInt(year)){
            //invalid date, check out year before check in year
            System.out.println("check in year is after check out year");
            return 6;
        } else if(yearInt == Integer.parseInt(year) && monthIntIn > monthIntOut){
            //invalid date, check out month before check in month in the same year
            System.out.println("check out month is before check in month of same year");
            return 6;
        } else if(yearInt == Integer.parseInt(year) && monthIntIn == monthIntOut && dayInt >= Integer.parseInt(day)){
            //invalid date, check in and check out are in same month but on
            //the same day or check out is on an earlier day
            System.out.println("check out date is same day or day before check in date of same year and month");
            return 6;
        }
        yearInt = Integer.parseInt(year);
        dayInt = Integer.parseInt(day);
        CheckOut = Integer.toString(yearInt)+" "+Integer.toString(monthIntOut)+" "+Integer.toString(dayInt);
        System.out.println(CheckOut);    //TEST
        return verify.verifyDate(yearInt, monthIntOut, dayInt, pathToReservDB, RoomNum, INorOUT);
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
        test = verify.isInteger(RoomNum);
        if(test == true){
            //verifyRoomNum checks for correct room # and rule following
            return verify.verifyRoomNum(Integer.parseInt(RoomNum), Integer.parseInt(TypeOfRoom), Integer.parseInt(SpecialPref));
        } else{    //RoomNum is not an Integer, automatic error
            return 7;   //7 = error
        }
    }
    
    public int setComments(String coms){
        //anything goes
        Comments = coms;
        return 0;
    }
    public String getGuestID(){
        return GuestID;
    }
    //for use by databaseManager class primarily
    public String toString(){
        return GuestID+";"+NumOfPersons+";"+TypeOfRoom+";"+CheckIn+";"+CheckOut+";"+RoomNum+";"+SpecialPref+";"+Comments;
    }
}
