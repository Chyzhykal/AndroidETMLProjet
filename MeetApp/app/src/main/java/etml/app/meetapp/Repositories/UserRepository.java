/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Repository for the User object
 */
package etml.app.meetapp.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import etml.app.meetapp.Entities.CategoryEntitiy;
import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Enums.UserCodes;
import etml.app.meetapp.database.ConnectMySQL;

/**
 * Class for interracting with user information in the database
 *
 */
public class UserRepository {

    Connection connection;

    /**
     * Constructor of the cldass
     */
    public UserRepository(){
        connection = ConnectMySQL.getInstance().getConnection();
    }

    public UserEntity add(UserEntity user) {
        System.out.println("Im in REpo");
        UserEntity userEntity = new UserEntity();
        try {
            PreparedStatement st = connection.prepareStatement("SELECT idUser FROM t_user WHERE useName=?");
            st.setString(1, user.getName());
            ResultSet rs = st.executeQuery();
            System.out.println(rs.toString());

            if(rs.next()){
                userEntity.setUserCode(UserCodes.EXISTS);
                System.out.println("Exists");
                return userEntity ;
            }

            st = connection.prepareStatement("INSERT INTO t_user (useName, usePhoneNumber, usePwd, usePhoto,"
                    + "useBirthDate, useJoinDate, useKudos) VALUES (?,?,?,?,?,?,?)");
            st.setString(1, user.getName());
            st.setString(2, user.getPhoneNumber());
            st.setString(3, user.getPwd());
            st.setString(4, user.getPhoto());
            st.setDate(5, user.getBirthDate());
            st.setDate(6, user.getJoinDate());
            st.setInt(7, user.getKudos());

            boolean result = st.execute();
            if(result){
                userEntity.setUserCode(UserCodes.CREATED);
                System.out.println("NotCreated");
                return userEntity ;
            }

            userEntity.setUserCode(UserCodes.NOT_CREATED);
            System.out.println("Created");
            return userEntity ;
        } catch (SQLException e) {
            System.out.println("Im in Catch");
            e.printStackTrace();
            userEntity.setUserCode(UserCodes.SQL_ERROR);
            return userEntity ;
        }
    }

    public void update(Object entity) {

    }

    public void remove(Object entity) {

    }

    public Object getById() {
        return null;
    }


    public UserEntity loginAttempt(String login, String pwd) {
        UserEntity userEntity = new UserEntity();
        try {
            System.out.println("Connecting");
            PreparedStatement st = connection.prepareStatement("SELECT idUser, usePwd FROM t_user WHERE useName=?");
            st.setString(1, login);
            ResultSet result = st.executeQuery();
            if(!result.next()){
                userEntity.setUserCode(UserCodes.NOT_FOUND);
                return userEntity ;
            }
            while (result.next()) {
                if(pwd==result.getString("usePwd")){
                    userEntity.setId(result.getInt("idUser"));
                    userEntity.setUserCode(UserCodes.CONNECTED);
                    return userEntity ;
                }
                else{
                    userEntity.setUserCode(UserCodes.WRONG_PWD);
                    return userEntity ;
                }
            }
            st = connection.prepareStatement("SELECT useName, usePhoneNumber, usePwd, usePhoto," +
                    "useBirthDate, useJoinDate, useKudos FROM t_user WHERE idUser=?");

            EventEntity entity = new EventEntity("");

            while (result.next()) {
                entity.setId(result.getInt(1));
                entity.setName(result.getString(2));
                entity.setDescription(result.getString(3));
                entity.setPicture(result.getString(4));
                entity.setStartDateTime(result.getDate(5));
                entity.setEndDateTime(result.getDate(6));
                entity.setLocation(result.getString(7));
                entity.setPromoted(result.getBoolean(8));
                entity.setIsPrivate(result.getBoolean(9));
                entity.setMaxUsers(result.getInt(10));
                entity.setCreatorID(result.getInt(11));
                entity.setCategory(result.getInt(12));
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public List getNewest() {
        return null;
    }


    public List getAll() {
        return null;
    }


    public List getByCategory(CategoryEntitiy category) {
        return null;
    }


    public List getNewerThan(Date date) {
        return null;
    }
}
