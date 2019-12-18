package etml.app.meetapp;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Class allowing to store global variables throughout the code
 */
public class Session {
    private static Session instance = null;             // Instance of the singleton
    private Dictionary sessionValues = new Hashtable(); // Values stored in session

    /**
     * Gets the singleton instance
     * @return Session
     */
    public static Session getInstance() {
        if (instance == null){
            instance = new Session();
        }
        return instance;
    }

    /**
     * Private class constructor
     */
    private Session() {}

    /**
     * Adds a value to the session
     * @param key
     * @param value
     */
    public void addPair(String key, Object value){
        sessionValues.put(key, value);
    }

    /**
     * Gets a value from the session
     * @param key
     * @return
     */
    public Object getValue(String key){
        return sessionValues.get(key);
    }
}