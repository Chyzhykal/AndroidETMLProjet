/**
 * ETML
 * Author :Aleh Chyzhk
 * Date : 11.12.2019
 * Description : Enums for the program, codes for the different transitions between classes and activities
 */

package etml.app.meetapp.Enums;

//User Login/Register codes

/**
 * Allows to store various results when manipulating users in the database
 */
public enum UserCodes {
    CONNECTED, NOT_CONNECTED, CREATED, EXISTS, NOT_FOUND, NOT_CREATED, SQL_ERROR, WRONG_PWD
}
