/***************** Planification ******************/

Link to the Trello :
https://trello.com/b/FNjp216n/meetapp




/***************** DATABASE INSTALLATION **************/

For the local virtual server with MySQL:

	1. Download UwAmp : https://www.uwamp.com/file/UwAmp.zip
	2. Unzip downloaded archive
	3. Launch UwAmp
	4. Access phpMyAdmin
	5. Enter login and password (by default it's "root" and "root")
	6. Go to "Import"
	7. Select file "MeetApp_Database_TestData.sql" in "Rendu" folder
	8. Press Execute
	9. Normally (were tested) you must have a new db_meetapp database now. 
		
		If an error occured, then there must be a problem with sql file version. Go to git repository 
		and download the file again from "rendu folder".


For another server :
	1. No support provided for other possibilities, only UwAmp was tested.



/***************** DATABASE CONFIGURATION**************/

Default database ip addres is 192.168.56.1

BUT, there might be problems related to the host address. The only way to test the database access is to run a virtual device for app testing.
 							  (Because database itself is on the virtual server)
Depending on the computer you're using the atributed virtual server IP address may be different to default one. 
In this case device won't be able to connect to the database. 

HOW TO SOLVE: 

In "Rendu\MeetApp\app\src\main\java\etml\app\meetapp\database\ConnectMySQL.java" file find the line number 59. On this line you can find default IP address for the database.
Change it to valid IP address in case if this doesn't work.

How to check IP address - open cmd.exe, run "ipconfig", find your IP address.



/***************** DATABASE INFORMATION **************/

Database requirements :

MYSQL

User: root
Password: root
Host: See DATABASE CONFIGURATION block, default is 192.168.56.1
Name: db_meetapp

// Given SQL scripts were tested only with UwAmp and phpMyAdmin, any problems while testing on other servers
// are not the responsibility of developers.

// Data stored in test_data SQL file is not the valid information, it's used ONLY to test the functionalities of the app.

// Last time when was tested (08.01.2020) database did not have any issues, means that it is fully functional.



/***************** PROJECT SOURCE CODE INFORMATION **************/

// Project itself is not finished, developers know that project must be finished at max. 22.12.2019 00:00,
// but both collaborators had a lot of issues with code and debugging during the whole development period, more precisely with :
	1. MySQL database connection : 
		a. MySQL IS NOT the best technology to use with android devices, due to the lack of tutorials and up-to-date manuals.
		b. Java itself is very different to C# when talking about databases. Developers did not expect to discover a whole
		   new methods of connection to the database.
		c. Enabling internet use. Developers couldn't figure out the problem till they found out that Android Java apps must include
		   configuration which allows it to use the internet. 
	
	2. Activities : the techonology is completely is different to what developers used before with other programming languages.
	   It was difficult to understand the syntax and techniques which are used in Java language.
	
	3. A lot of other projects during the week : in total per week developers are working on 5 different projects using different programming languages
	   and frameworks. It is not easy to switch between each language and project specifications, especially considering the time (4 periods) given
	   for every project per week. 
	
	4. Amount of time given to learn the language : developers did not expect Java to be so different from C#. We did not calculate the time and planification correctly.

/********************** NOTE ***********************/
Both developers do not like the Java language, more precisely Android Studio
Everything seems not being intuitive and being more difficult than it should be.