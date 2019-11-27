package etml.app.meetapp.Entities;

import android.media.Image;

import java.sql.Date;

public class UserEntity {

    int idUser;
    String name;
    String phoneNumber;
    String pwd;
    String photo;
    Date birthDate;
    Date joinDate;
    int kudos;
    Image photoObject;

    public void setId(int newId){
        this.idUser = newId;
    }

    public int getId(){
        return idUser;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public String getName(){
        return name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoto(String photo){
        this.photo = photo;
    }

    public String getPhoto(){
        return photo;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public void setJoinDate(Date joinDate){
        this.joinDate = joinDate;
    }

    public Date getJoinDate(){
        return joinDate;
    }

    public void setKudos(int newMaxUsers){
        this.kudos = kudos;
    }

    public int getKudos(){
        return kudos;
    }

    public void setPhotoObject(Image photoObject){
        this.photoObject = photoObject;
    }

    public Image getPhotoObject(){
        return photoObject;
    }
}
