package database_connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by kraluk01 on 7/26/2016.
 */
public class CRUD {

    public boolean create() throws SQLException {

        DBconnection connection = new DBconnection();
        Connection conn = connection.connect();

        Statement stmt = null;

        boolean result = false;
        try {

            if(result == false) {
                String drop = "DROP TABLE Person";

                String createTable = "CREATE TABLE Person("
                        + "PersonID int,"
                        + "LastName varchar(255),"
                        + "FirstName varchar(255),"
                        + "Address varchar(255),"
                        + "City varchar(255)" +
                        ")";

                stmt = conn.createStatement();

                stmt.executeQuery(drop);

                stmt.executeQuery(createTable);

                System.out.println("Table was created Successfully! ");
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            if(stmt!=null)
            {
                stmt.close();

                result = true;

            }

        }

    return result;
    }

    public boolean insert() throws SQLException {
        DBconnection connection = new DBconnection();
        Connection conn = connection.connect();
        Statement stmt = null;

        boolean result = false;

        try {
            if(result == false) {

                String insert = "INSERT INTO Person"
                        + "(PersonID, LASTNAME, FIRSTNAME, ADDRESS, CITY) " + "VALUES"
                        + "(1,'Kramer','Luke', 'Kuilsriver','CapeTown')";

                stmt = conn.createStatement();
                stmt.execute(insert);
                System.out.println("Record was Inserted Successfully! ");
                result = true;

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            if(stmt!=null)
            {
                stmt.close();
                result =true;
            }

        }

        return result;


    }

    public boolean update() throws SQLException {
        DBconnection connection = new DBconnection();
        Connection conn = connection.connect();
        Statement stmt = null;

        boolean result = false;

        try {

            if(result == false) {
                String update = "UPDATE Person"
                        + " SET LASTNAME = 'Skywalker', CITY = 'Gotham'"
                        + " WHERE PERSONID = 1";

                stmt = conn.createStatement();
                stmt.execute(update);
                System.out.println("Record was Updated Successfully! ");
                result = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {

            if(stmt!=null)
            {
                stmt.close();
            }

        }

        return result;
    }

    public boolean delete() throws SQLException {
        DBconnection connection = new DBconnection();
        Connection conn = connection.connect();
        Statement stmt = null;
        boolean result = false;
         try{
             if(result == false) {
                 String delete = "DELETE FROM Person " + "WHERE PERSONID = 1";

                 stmt = conn.createStatement();
                 stmt.execute(delete);
                 System.out.println("Record was Deleted Successfully! ");
                 result = true;
             }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally {

             if (stmt != null) {
                 stmt.close();
             }
         }
        return result;
    }

    public boolean select() throws SQLException {
        DBconnection connection = new DBconnection();
        Connection conn = connection.connect();
        Statement stmt = null;
        boolean result = false;
        try{

            if (result ==  false) {

                String select = "select * from Person ";

                stmt = conn.createStatement();

                ResultSet rs = stmt.executeQuery(select);

                while (rs.next()) {
                    String personid = rs.getInt("PERSONID") + "";
                    String last = rs.getString("LASTNAME");
                    String first = rs.getString("FIRSTNAME");
                    String address = rs.getString("ADDRESS");
                    String city = rs.getString("CITY");

                    System.out.println("Record :" + personid + " " + last + " " + first + " " + address + " " + city);
                }
                    result = true;
            }
    }
    catch(Exception e)
    {
        System.out.println("Exception: "+e);
    }
    finally {
        if (stmt!=null){

            stmt.close();
        }
    }

        return result;

    }

}


