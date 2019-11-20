 package etml.app.meetapp.database;

import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import etml.app.meetapp.MainActivity;
import etml.app.meetapp.R;


class MySQLConnect extends AsyncTask<String, Void, String> {
    String res = "";
    private  final String url = "jdbc:mysql://10.228.156.173:3306/db_meetapp";
    private  final String user = "Buris";
    private  final String pass = "root";
    private Connection connection;


    @Override
    public void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    public String doInBackground(String... params) {
     try {
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection(url, user, pass);
         System.out.println("Database connection success");

         String result = "Database Connection Successful\n";
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery("select catName from t_evCategory");
         ResultSetMetaData rsmd = rs.getMetaData();

         while (rs.next()) {
             result += rs.getString(1).toString() + "\n";
         }
         res = result;
     } catch (Exception e) {
         e.printStackTrace();
         res = e.toString();
     }
     return res;
    }

    @Override
    public void onPostExecute(String result) {

    }
}
