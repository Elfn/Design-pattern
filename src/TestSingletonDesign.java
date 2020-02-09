import singleton.DBSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Elimane on Jan, 2020, at 00:42
 */
public class TestSingletonDesign {
    public static void main(String[] args) throws SQLException {
        DBSingleton instance = DBSingleton.getInstance();
        Statement stm;
        long timeBefore = 0;
        long timeAfter = 0;


        timeBefore = System.currentTimeMillis();
        Connection conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println("TIME SPENT => "+(timeAfter - timeBefore));


        stm = conn.createStatement();

        int count  =  stm.executeUpdate("CREATE TABLE Adress (ID INT, StreetName VARCHAR(20), City VARCHAR(20))");
        System.out.println("Table created");
        stm.close();

        timeBefore = System.currentTimeMillis();
        conn = instance.getConnection();
        timeAfter = System.currentTimeMillis();

        System.out.println("TIME SPENT => "+(timeAfter - timeBefore));


//        DBSingleton instance2 = DBSingleton.getInstance();
//
//        System.out.println(instance);
//        System.out.println(instance2);
//
//        String result = (instance2 == instance) ? "They are the same instances" : "Not the same";
//
//        System.out.println(result);



    }
}
