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

public class UserEntity {

    UserCodes userCode;
    int idUser;
    String name;
    String phoneNumber;
    String pwd;
    String photo;
    Date birthDate;
    Date joinDate;
    int kudos;
    Image photoObject;

    public UserCodes getUserCode() {
        return userCode;
    }
    public void setUserCode(UserCodes userCode) {
        this.userCode = userCode;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

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

    public void setKudos(int kudos){
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
