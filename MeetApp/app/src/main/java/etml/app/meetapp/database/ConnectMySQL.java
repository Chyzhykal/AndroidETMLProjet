package etml.app.meetapp.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import etml.app.meetapp.R;
import android.content.res.Resources;

public class ConnectMySQL {
    private static final ConnectMySQL ourInstance = new ConnectMySQL();

    public static ConnectMySQL getInstance() {
        return ourInstance;
    }

    private ConnectMySQL() {
    }

    public Connection getConnection() {

        return connection;
    }

    private Connection connection;

    public Exception connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://10.228.156.173/db_meetapp", "Buris", "root");

            System.out.println("Database connection success");

            String result = "Database Connection Successful\n";

            //   Statement st = connection.createStatement();
            //   ResultSet rs = st.executeQuery("select catName from t_evCategory");
            //   ResultSetMetaData rsmd = rs.getMetaData();
/*
         while (rs.next()) {
             result += rs.getString(1).toString() + "\n";
         }
         res = result;*/
        } catch (Exception e) {
            System.out.println("Database connection Problem");
            e.getMessage();
            e.printStackTrace();
            /* res = e.toString();*/
            return e;
        }
        return null;
    }
}
