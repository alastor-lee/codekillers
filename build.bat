@echo off
:CHECKS FOR A BIN FOLDER TO PLACE THE BUILD INTO
IF NOT EXIST %HOMEPATH%\bin (
	MKDIR %HOMEPATH%\bin
	ECHO created new directory
)

:COMPILES TO THE USER BIN FOLDER
javac -d %HOMEPATH%\bin -cp  .\floorlayoutgui\*.java .\engine\*.java .\maingui\*.java .\database\*java^
 .\kitchengui\*.java  

ECHO compiled code

:TYPE y AS COMMAND LINE ARGUMENT TO RUN BUILD
IF "%1"=="y" (
	ECHO running program
	java -cp %HOMEPATH%\bin engine.HotelManagementSystem
)