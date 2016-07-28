import database_connection.CRUD;
import database_connection.DBconnection;


import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by kraluk01 on 7/27/2016.
 */
public class CRUDTest {


    boolean result;
    CRUD crud = new CRUD();


    @Test
    public void establish_connection_to_database() throws Exception {

        DBconnection connection = new DBconnection();
        Connection con = connection.connect();
        Assert.assertNotNull(con);

    }

    @Test
    public void create_table_into_database() throws Exception {

        result = crud.create();
        Assert.assertTrue(result);

    }


    @Test
    public void insert_record_into_table() throws Exception {

        result = crud.insert();
        Assert.assertTrue(result);

    }

    @Test
    public void select_record_from_table() throws Exception {

        result = crud.select();
        Assert.assertTrue(result);

    }

    @Test
    public void update_record_into_table() throws Exception {

        result = crud.update();
        Assert.assertTrue(result);


    }

    @Test
    public void delete_records_from_table() throws Exception {

        result = crud.delete();
        Assert.assertTrue(result);

    }
}
