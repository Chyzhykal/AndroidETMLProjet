/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Repository for the entity object
 */
package etml.app.meetapp.Repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import etml.app.meetapp.Entities.EventEntity;
import etml.app.meetapp.database.*;

/**
 * Repository for the entity object
 */
public class EventRepository {

    // Connection object
    Connection connection;

    /**
     * Constructor
     */
    public EventRepository(){
        ConnectMySQL.getInstance().connect();
        connection = ConnectMySQL.getInstance().getConnection();
    }

    /**
     * Adds an event to the database
     * @param event
     * @return
     */
    public boolean add(EventEntity event) {

        // Attempts to add the event entity
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
            st.setInt(10, event.getCreatorID());
            st.setInt(11, event.getCategory());

            boolean result = st.execute();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Updates an event in the database
     * @param event
     * @return
     */
    public boolean update(EventEntity event) {

        // Attempts to update the event
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
            st.setInt(10, event.getCreatorID());
            st.setInt(11, event.getCategory());

            boolean result = st.execute();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Removes an event from the database
     * @param event
     * @return
     */
    public boolean remove(EventEntity event) {

        // Attempts to remove the event
        try {
            PreparedStatement st = connection.prepareStatement("DELETE FROM t_event WHERE idEvent=?");
            st.setInt(1, event.getId());
            boolean result = st.execute();
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Gets an event object from its id
     * @param eventId
     * @return
     */
    public EventEntity getById(int eventId) {

        // Attempts to retrieve the event from the database
        try {

            PreparedStatement st = connection.prepareStatement("SELECT eveName, eveDescription, evePicture, eveStartDateTime," +
            "eveEndDatetime, eveLocation, evePromoted, evePrivate, eveMaxUsers, fkUser, fkCategory FROM t_event WHERE idEvent=?");
            st.setInt(1, eventId);

            ResultSet result = st.executeQuery();
            EventEntity entity = new EventEntity("");

            // Goes through the row and gets the info
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
            return entity;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Gets all events from the database
     * @return
     */
    public List<EventEntity> getAll() {

        // Attempts to retrieve the events
        try {
            Statement st = connection.createStatement();
            ResultSet result = st.executeQuery("SELECT idEvent, eveName, eveDescription, evePicture, eveStartDateTime,"
                    + "eveEndDatetime, eveLocation, evePromoted, evePrivate, eveMaxUsers, fkUser, fkCategory FROM t_event");
            String resultStr = "";
            List<EventEntity> eventEntities = new LinkedList<>();

            // Goes through each row and stored the event info to a list
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
                entity.setCreatorID(result.getInt(11));
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
}
