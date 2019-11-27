package etml.app.meetapp.Repositories;

import android.database.Cursor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import etml.app.meetapp.Entities.CategoryEntitiy;
import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.Entities.UserEntity;
import etml.app.meetapp.database.*;

public class EventRepository {

    Connection connection;

    public EventRepository(){
        connection = ConnectMySQL.getInstance().getConnection();
    }

    public boolean add(EventEntity event) {
        try {
            PreparedStatement st = connection.prepareStatement("INSERT INTO t_event (eveName, eveDescription, evePicture, eveStartDateTime,"
            + "eveEndDatetime, eveLocation, evePromoted, evePrivate, eveMaxUsers, fkUser, fkCategory) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            st.setString(1, event.getName());
            st.setString(2, event.getDescription());
            st.setString(3, event.getPicture());
            st.setDate(4, event.getStartDateTime());
            st.setDate(5, event.getEndDateTime());
            st.setString(6, event.getLocation());
            st.setBoolean(7, event.getPromoted());
            st.setBoolean(8, event.getIsPrivate());
            st.setInt(9, event.getMaxUsers());
            st.setInt(10, event.getFkUserCreator());
            st.setInt(11, event.getCategory());

            boolean result = st.execute();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(EventEntity event) {
        try {
            PreparedStatement st = connection.prepareStatement("UPDATE t_event SET  eveName=?, eveDescription=?, evePicture=?, eveStartDateTime=?,"
                    + "eveEndDatetime=?, eveLocation=?, evePromoted=?, evePrivate=?, eveMaxUsers=?, fkUser=?, fkCategory=?");
            st.setString(1, event.getName());
            st.setString(2, event.getDescription());
            st.setString(3, event.getPicture());
            st.setDate(4, event.getStartDateTime());
            st.setDate(5, event.getEndDateTime());
            st.setString(6, event.getLocation());
            st.setBoolean(7, event.getPromoted());
            st.setBoolean(8, event.getIsPrivate());
            st.setInt(9, event.getMaxUsers());
            st.setInt(10, event.getFkUserCreator());
            st.setInt(11, event.getCategory());

            boolean result = st.execute();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean remove(EventEntity event) {

        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM t_event WHERE idEvent=?");
            st.setInt(1, event.getCategory());
            boolean result = st.execute();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    public Object getById() {
        return null;
    }


    public List getNewest() {
        return null;
    }


    public List<EventEntity> getAll() {
        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT idEvent, eveName, eveDescription, evePicture, eveStartDateTime,"
                    + "eveEndDatetime, eveLocation, evePromoted, evePrivate, eveMaxUsers, fkUser, fkCategory FROM t_event");
            String resultStr = "";
            List<EventEntity> eventEntities = new LinkedList<>();
            while (result.next()) {
                EventEntity entity = new EventEntity("");
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
                entity.setFkUserCreator(result.getInt(11));
                entity.setCategory(result.getInt(12));
                eventEntities.add(entity);
            }
            return eventEntities;
        } catch (SQLException e) {
            System.out.println("DBProblem");
            e.printStackTrace();
            return null;
        }
    }


    public List getByCategory(CategoryEntitiy category) {
        return null;
    }

    public List getByUser(UserEntity user) {
        return null;
    }

    public List getNewerThan(Date date) {
        return null;
    }
}
