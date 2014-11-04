@echo off
:CHECKS FOR A BIN FOLDER TO PLACE THE BUILD INTO
IF NOT EXIST %HOMEPATH%\bin (
	MKDIR %HOMEPATH%\bin
	ECHO created new directory
)

:COMPILES TO THE USER BIN FOLDER
javac -d %HOMEPATH%\bin -cp .\FrontDeskGUI\*.java .\MainGUI\*.java^
 .\RestaurantHostGUI\*.java .\Engine\*.java
ECHO compiled code

:TYPE y AS COMMAND LINE ARGUMENT TO RUN BUILD
IF "%1"=="y" (
	ECHO running program
	java -cp %HOMEPATH%\bin Engine.HotelManagementSystem
)