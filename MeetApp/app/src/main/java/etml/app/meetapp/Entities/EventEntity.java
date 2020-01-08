/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the Event object
 */

package etml.app.meetapp.Entities;

import android.media.Image;
import java.sql.Date;

/**
 * Entity for the Event object
 */
public class EventEntity {

    int fkUserCreator;      // Creator's user's id
    int idEvent;            // Event ID
    String name;            // Event Name
    String description;     // Event Description
    String picture;         // Event picture location data
    Image pictureObject;    // Event picture
    Date startDateTime;     // Event start date
    Date endDateTime;       // Event end date
    String location;        // Event Google maps location
    boolean promoted;       // Event is promoted/false
    boolean isPrivate;      // Event is private/False
    int maxUsers;           //Event Max user amount
    int creatorID;          //User creator foreign key
    int fkcategory;         //Category foreign key

    /**
     * Constructor of a class
     * @param name Used for testing only
     */
    public EventEntity(String name){
        this.name=name;
    }

    /*Getters/Setters zone*/

    /**
     * Sets the id
     * @param newId
     */
    public void setId(int newId){
        this.idEvent = newId;
    }

    /**
     * Gets the id
     * @return
     */
    public int getId(){
        return idEvent;
    }

    /**
     * Sets the name
     * @param newName
     */
    public void setName(String newName){
        this.name = newName;
    }

    /**
     * Gets the name
     * @return
     */
    public String getName(){
        return name;
    }

    /**
     * Sets the description
     * @param newDescription
     */
    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    /**
     * Gets the description
     * @return
     */
    public String getDescription(){
        return description;
    }

    /**
     * Sets the picture
     * @param newPicture
     */
    public void setPicture(String newPicture){
        this.picture = newPicture;
    }

    /**
     * Gets the picture
     * @return
     */
    public String getPicture(){
        return picture;
    }

    /**
     * Sets the start date time
     * @param newStartDateTime
     */
    public void setStartDateTime(Date newStartDateTime){
        this.startDateTime = newStartDateTime;
    }

    /**
     * Gets the start date time
     * @return
     */
    public Date getStartDateTime(){
        return startDateTime;
    }

    /**
     * Sets the end date time
     * @param newEndDateTime
     */
    public void setEndDateTime(Date newEndDateTime){
        this.endDateTime = newEndDateTime;
    }

    /**
     * Gets the end date time
     * @return
     */
    public Date getEndDateTime(){
        return endDateTime;
    }

    /**
     * Sets the event location
     * @param newLocation
     */
    public void setLocation(String newLocation){
        this.location = newLocation;
    }

    /**
     * Gets the event location
     * @return
     */
    public String getLocation(){
        return location;
    }

    /**
     * Sets wether the event is promoted
     * @param newPromoted
     */
    public void setPromoted(boolean newPromoted){
        this.promoted = newPromoted;
    }

    /**
     * Gets wether the event is promoted
     * @return
     */
    public boolean getPromoted(){
        return promoted;
    }

    /**
     * Sets wether the event is private
     * @param newIsPrivate
     */
    public void setIsPrivate(boolean newIsPrivate){
        this.isPrivate = newIsPrivate;
    }

    /**
     * Gets wether the event is private
     * @return
     */
    public boolean getIsPrivate(){
        return isPrivate;
    }

    /**
     * Sets the maximum amount of participants
     * @param newMaxUsers
     */
    public void setMaxUsers(int newMaxUsers){
        this.maxUsers = newMaxUsers;
    }

    /**
     * Gets the maximum amount of participants
     * @return
     */
    public int getMaxUsers(){
        return maxUsers;
    }

    /**
     * Sets the creator's user's id
     * @param newCreatorID
     */
    public void setCreatorID(int newCreatorID){
        this.creatorID = newCreatorID;
    }

    /**
     * Gets the creator's user's id
     * @return
     */
    public int getCreatorID(){
        return creatorID;
    }

    /**
     * Sets the event category
     * @param fkcategory
     */
    public void setCategory(int fkcategory){
        this.fkcategory = fkcategory;
    }

    /**
     * Gets the event category
     * @return
     */
    public int getCategory(){
        return fkcategory;
    }

    /**
     * Sets the picture object
     * @param pictureObject
     */
    public void setPictureObject(Image pictureObject){
        this.pictureObject = pictureObject;
    }

    /**
     * Gets the picture object
     * @return
     */
    public Image getPictureObject(){
        return pictureObject;
    }

    /**
     * Gets the current amount of participants
     * @return
     */
    public int getParticipantCount(){
        return 0;
    }
}
