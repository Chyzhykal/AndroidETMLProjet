/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the User object
 */

package etml.app.meetapp.Entities;

import android.media.Image;
import java.sql.Date;
import etml.app.meetapp.Enums.UserCodes;

/**
 * Entity for the User object
 */
public class UserEntity {

    UserCodes userCode; // User's code
    int idUser;         // User's database id
    String name;        // User's name
    String phoneNumber; // User's phone number
    String pwd;         // User's password
    String photo;       // User's profile picture
    Date birthDate;     // User's birth date
    Date joinDate;      // Date in which the user created their account
    int kudos;          // Amount of people he invited to the app
    Image photoObject;  // Object of the profile picture

    /**
     * Gets the user code
     * @return
     */
    public UserCodes getUserCode() {
        return userCode;
    }

    /**
     * Sets the user code
     * @param userCode
     */
    public void setUserCode(UserCodes userCode) {
        this.userCode = userCode;
    }

    /**
     * Gets the user password
     * @return
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the user password
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * Sets the user id
     * @param newId
     */
    public void setId(int newId){
        this.idUser = newId;
    }

    /**
     * Gets the user id
     * @return
     */
    public int getId(){
        return idUser;
    }

    /**
     * Sets the user name
     * @param newName
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Gets the user name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the user's phone number
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    /**
     * Gets the user's phone number
     * @return
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Sets the user's photo
     * @param photo
     */
    public void setPhoto(String photo){
        this.photo = photo;
    }

    /**
     * Gets the user's photo
     * @return
     */
    public String getPhoto(){
        return photo;
    }

    /**
     * Sets the user's birth date
     * @param birthDate
     */
    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    /**
     * Gets the user's birth date
     * @return
     */
    public Date getBirthDate(){
        return birthDate;
    }

    /**
     * Sets the user's join date
     * @param joinDate
     */
    public void setJoinDate(Date joinDate){
        this.joinDate = joinDate;
    }

    /**
     * Gets the user's join date
     * @return
     */
    public Date getJoinDate(){
        return joinDate;
    }

    /**
     * Sets the amount of kudos
     * @param kudos
     */
    public void setKudos(int kudos){
        this.kudos = kudos;
    }

    /**
     * Gets the amount of kudos
     * @return
     */
    public int getKudos(){
        return kudos;
    }

    /**
     * Sets the photo object
     * @param photoObject
     */
    public void setPhotoObject(Image photoObject){
        this.photoObject = photoObject;
    }

    /**
     * Gets the photo object
     * @return
     */
    public Image getPhotoObject(){
        return photoObject;
    }
}
