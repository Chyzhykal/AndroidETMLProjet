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

import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.Enums.UserCodes;
import etml.app.meetapp.database.ConnectMySQL;

/**
 * Repository for the User object
 */
public class UserRepository {

    // Connection instance
    Connection connection;

    /**
     * Constructor of the class
     */
    public UserRepository(){
        ConnectMySQL.getInstance().connect();
        connection = ConnectMySQL.getInstance().getConnection();
    }

    /**
     * Adds a user to the database
     * @param user
     * @return
     */
    public UserEntity add(UserEntity user) {
        System.out.println("Im in REpo");
        UserEntity userEntity = new UserEntity();

        // Attmpts to add teh user
        try {
            PreparedStatement st = connection.prepareStatement("SELECT idUser FROM t_user WHERE useName=?");
            st.setString(1, user.getName());
            ResultSet rs = st.executeQuery();
            System.out.println(rs.toString());

            // If the user already exists, return with an exists user code
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
            // If there is a result, return with a created user code
            if(result){
                userEntity.setUserCode(UserCodes.CREATED);
                System.out.println("NotCreated");
                return userEntity ;
            }

            // else, return with a not created user code
            userEntity.setUserCode(UserCodes.NOT_CREATED);
            System.out.println("Created");
            return userEntity ;

            // If an error occurred, return with an sql error user code
        } catch (SQLException e) {
            System.out.println("Im in Catch");
            e.printStackTrace();
            userEntity.setUserCode(UserCodes.SQL_ERROR);
            return userEntity ;
        }
    }

    /**
     * Gets a user by its id
     * @param id
     * @return
     */
    public UserEntity getById(int id) {

        // User to return
        UserEntity userEntity = new UserEntity();

        // Attempts to retrieve the user from the database
        try {
            PreparedStatement st = connection.prepareStatement("SELECT * FROM t_user WHERE idUser=?");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            System.out.println(rs.toString());

            // If there is a result, return the user's info with an exists user code
            if(rs.next()){
                userEntity.setId(id);
                userEntity.setBirthDate(rs.getDate("useBirthDate"));
                userEntity.setJoinDate(rs.getDate("useJoinDate"));
                userEntity.setKudos(rs.getInt("useKudos"));
                userEntity.setName(rs.getString("useName"));
                userEntity.setPhoneNumber(rs.getString("usePhoneNumber"));
                userEntity.setPhoto(rs.getNString("usePhoto"));
                userEntity.setUserCode(UserCodes.EXISTS);
                return userEntity ;
            }
            // If there isn't a result, return an empty UserEntity with a not found user code
            userEntity.setUserCode(UserCodes.NOT_FOUND);
            return userEntity;

            // If an error occurred, return an empty user entity with an sql error user code
        } catch (SQLException e) {
            System.out.println("Im in Catch");
            e.printStackTrace();
            userEntity.setUserCode(UserCodes.SQL_ERROR);
            return userEntity ;
        }
    }

    /**
     * Checks wether a login exists
     * @param login
     * @param pwd
     * @return
     */
    public UserEntity loginAttempt(String login, String pwd) {

        // User to return
        UserEntity userEntity = new UserEntity();

        // Checks the login
        try {
            System.out.println("Connecting");
            PreparedStatement st = connection.prepareStatement("SELECT idUser, usePwd FROM t_user WHERE useName=?");
            st.setString(1, login);
            ResultSet result = st.executeQuery();

            // While there is a result...
            while(result.next()){

                // Display various information for debugging
                System.out.println("line 106");
                System.out.println(result.getString("usePwd"));
                System.out.println(pwd);

                // If the given password corresponds to the password in the database...
                if(pwd.equals(result.getString("usePwd")))
                {
                    // Return the user entity with a connected user code
                    userEntity.setId(result.getInt("idUser"));
                    userEntity.setUserCode(UserCodes.CONNECTED);
                    System.out.println("line 112");
                    return userEntity ;
                }
                // If the two password don't correspond with one another, return with a wrong password user code
                else{
                    System.out.println("line 114");
                    userEntity.setUserCode(UserCodes.WRONG_PWD);
                    System.out.println(userEntity.getUserCode());
                    return userEntity;
                }
            }
            // if no results, return with a not found user code
            userEntity.setUserCode(UserCodes.NOT_FOUND);
            System.out.println("line 118");
            return  userEntity;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("line 122");
            return null;
        }
    }
}
