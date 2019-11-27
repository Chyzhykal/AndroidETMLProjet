package etml.app.meetapp.Entities;

import android.media.Image;

import java.sql.Date;

public class EventEntity {

    int fkUserCreator;
    int idEvent;
    String name;
    String description;
    String picture;
    Image pictureObject;
    Date startDateTime;
    Date endDateTime;
    String location;
    boolean promoted;
    boolean isPrivate;
    int maxUsers;
    int creatorID;
    int fkcategory;

    public EventEntity(String name){
        this.name=name;
    }
    public int getFkUserCreator() {
        return fkUserCreator;
    }

    public void setFkUserCreator(int fkUserCreator) {
        this.fkUserCreator = fkUserCreator;
    }

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
}
