/*package etml.app.meetapp.database;

import android.os.AsyncTask;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import etml.app.meetapp.R;


class MySQLConnect extends AsyncTask<String, Void, String>{
    private static final MySQLConnect ourInstance = new MySQLConnect();

    static MySQLConnect getInstance() {
        return ourInstance;
    }

    private MySQLConnect() {

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Toast.makeText(MainActivity.this, "Please wait...", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... params) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(Integer.toString(R.string.mysql_ip), Integer.toString(R.string.mysql_login), Integer.toString(R.string.mysql_pwd));
            System.out.println("Databaseection success");

            String result = "Database Connection Successful\n";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select distinct Country from tblCountries");
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
    protected void onPostExecute(String result) {
        txtData.setText(result);
    }
}*/
