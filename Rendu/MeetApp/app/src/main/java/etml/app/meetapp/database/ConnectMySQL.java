/**
 * ETML
 * Author : Chyzhyk Aleh
 * Date : 20.11.2019
 * Description : Class used to connect to the database
 */

package etml.app.meetapp.database;

import android.os.AsyncTask;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Singleton connects to MySQL database using sql.Connection Library
 */
public class ConnectMySQL {

    // Constant Instance of a class
    private static final ConnectMySQL ourInstance = new ConnectMySQL();
    // Connection object
    private Connection connection;

    /**
     * Singleton part
     * @return instance of this class
     */
    public static ConnectMySQL getInstance() {
        return ourInstance;
    }

    /**
     * Private class constructor
     */
    private ConnectMySQL() {
    }

    /**
     * Connection getter
     * @return Connection instance
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * Makes an attempt to connect to the database
     * @return Exception if occured, if not then returns null
     */
    public Exception connect() {
        // Attempts conenction
        try {
            // If connection doesn't exist yet, create one
            if(connection==null){
                Class.forName("com.mysql.jdbc.Driver");



                connection = DriverManager.getConnection("jdbc:mysql://" +
                        //HERE : Modify this IP address to your database server address
                        "192.168.56.1" +
                        ":3306" +
                        "/db_meetapp", "Buris", "root");

                System.out.println("Database connection success");

                String result = "Database Connection Successful\n";
            }
            return null;

            // If an error occurred in the attempt, display message to the console
        } catch (Exception e) {
            System.out.println("Database connection Problem");
            e.getMessage();
            e.printStackTrace();
            return e;
        }
    }
}
