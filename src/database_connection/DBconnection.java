package database_connection;

import java.sql.*;

/**
 * Created by kraluk01 on 7/26/2016.
 */
public class DBconnection {

    public Connection connect() throws SQLException {

        Statement stmt =null;

        Connection conn = null;
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            System.setProperty("oracle.net.tns_admin","C:/oracle/product/11.2.0/client_1/network/admin");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@tst1124","hr6","hr6");
            System.out.println("Successful connection\n\n");

            String name ="select ename from emp where empno = 7369";

            stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(name);


            while(rs.next())
            {
                String ename = rs.getString("Ename");
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


        return conn;
    }



}
