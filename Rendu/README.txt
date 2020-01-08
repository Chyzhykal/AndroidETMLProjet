/***************** Modifications ******************/

En-tête classe ou méthode : Every class and method now has a header

Commentaires - nombre : More comments added in most files

Commentaires - qualité : Comment quality has been improved

Fonc - DB : Database now works fine and installation manual added

Fonc - activité intro : Login and account creation no longer crashes the app

Fonc - activité suivante : The activity after the login works fine

/***************** Planification ******************/

Link to the Trello :
https://trello.com/b/FNjp216n/meetapp


/***************** DATABASE INFORMATION **************/

Database requirements :

User: root
Password: root
Host: 127.0.0.1
Name: db_meetapp

// Given SQL scripts were tested only with UwAmp and phpMyAdmin, any problems while testing on other servers
// are not the responsibility of developers.

// Data stored in test_data SQL file is not the valid information, it's used ONLY to test the functionalities of the app.

// Last time when was tested (22.12.2019) database did not have any issues, means that it is fully functional.

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