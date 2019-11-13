package etml.app.meetapp.Objects;

public class Event {
    int id;
    String name;
    String description;
    String picture;
    String startDateTime;
    String endDateTime;
    String location;
    boolean promoted;
    boolean isPrivate;
    int maxUsers;
    int creatorID;
    String category;

    public Event(){
    }

    public void setId(int newId){
        this.id = newId;
    }

    public int getId(){
        return id;
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

    public void setStartDateTime(String newStartDateTime){
        this.startDateTime = newStartDateTime;
    }

    public String getStartDateTime(){
        return startDateTime;
    }

    public void setEndDateTime(String newEndDateTime){
        this.endDateTime = newEndDateTime;
    }

    public String getEndDateTime(){
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

    public void setCategory(String newCategory){
        this.category = newCategory;
    }

    public String getCategory(){
        return category;
    }
}
