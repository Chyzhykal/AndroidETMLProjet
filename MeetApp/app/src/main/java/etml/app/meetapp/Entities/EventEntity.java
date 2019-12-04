/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Entity for the Event object
 */

package etml.app.meetapp.Entities;

import android.media.Image;
import java.sql.Date;

public class EventEntity {

    int fkUserCreator;
    //Event ID
    int idEvent;
    //Event Name
    String name;
    //Event Description
    String description;
    //Event picture location data
    String picture;
    //Event picture
    Image pictureObject;
    //Event start date
    Date startDateTime;
    //Event end date
    Date endDateTime;
    //Event Google maps location
    String location;
    //Event is promoted/false
    boolean promoted;
    //Event is private/False
    boolean isPrivate;
    //Event Max user amount
    int maxUsers;
    //User creator foreign key
    int creatorID;
    //Category foreign key
    int fkcategory;

    /**
     * Constructor of a class
     * @param name Used for testing only
     */
    public EventEntity(String name){
        this.name=name;
    }

    /*Getters/Setters zone*/

    public void setId(int newId){
        this.idEvent = newId;
    }
    public int getId(){
        return idEvent;
    }

    public void setName(String newName){
        this.name = newName;
    }
    public String getName(){
        return name;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }
    public String getDescription(){
        return description;
    }

    public void setPicture(String newPicture){
        this.picture = newPicture;
    }
    public String getPicture(){
        return picture;
    }

    public void setStartDateTime(Date newStartDateTime){
        this.startDateTime = newStartDateTime;
    }
    public Date getStartDateTime(){
        return startDateTime;
    }

    public void setEndDateTime(Date newEndDateTime){
        this.endDateTime = newEndDateTime;
    }
    public Date getEndDateTime(){
        return endDateTime;
    }

    public void setLocation(String newLocation){
        this.location = newLocation;
    }
    public String getLocation(){
        return location;
    }

    public void setPromoted(boolean newPromoted){
        this.promoted = newPromoted;
    }
    public boolean getPromoted(){
        return promoted;
    }

    public void setIsPrivate(boolean newIsPrivate){
        this.isPrivate = newIsPrivate;
    }
    public boolean getIsPrivate(){
        return isPrivate;
    }

    public void setMaxUsers(int newMaxUsers){
        this.maxUsers = newMaxUsers;
    }
    public int getMaxUsers(){
        return maxUsers;
    }

    public void setCreatorID(int newCreatorID){
        this.creatorID = newCreatorID;
    }
    public int getCreatorID(){
        return creatorID;
    }

    public void setCategory(int fkcategory){
        this.fkcategory = fkcategory;
    }
    public int getCategory(){
        return fkcategory;
    }

    public void setPictureObject(Image pictureObject){
        this.pictureObject = pictureObject;
    }
    public Image getPictureObject(){
        return pictureObject;
    }

    public int getParticipantCount(){
        return 0;
    }
}
