import database_connection.CRUD;
import database_connection.DBconnection;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        CRUD crud = new CRUD();
        DBconnection conn = new DBconnection();
        try {

            crud.create();
            crud.insert();
            crud.select();
            crud.update();
            crud.select();
            crud.delete();
            crud.select();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
