package etml.app.meetapp.database;

class ConnectMySQL {
    private static final ConnectMySQL ourInstance = new ConnectMySQL();

    static ConnectMySQL getInstance() {
        return ourInstance;
    }

    private ConnectMySQL() {
    }
}
