package singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Elimane on Jan, 2020, at 00:35
 */
public class DBSingleton {

    //1- Create the only one instance that we want to call
    //VOLATILE ensure that instance will remain a singleton throught many of it change in JVM
    //To protect against instanciation to reflection
    private static volatile DBSingleton instance = null;
    private static volatile Connection conn = null;


    //2 - Create private construction only used by DbSingleton
    private DBSingleton() throws SQLException {

        DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());


        if(conn != null)
        {
            throw new RuntimeException("Use getConnection() to create");
        }

        if(instance != null)
        {
            throw new RuntimeException("Use getInstance() to create");
        }
    }

    //3 Method to call the only one instance

    //IT IS LAZY LOADING (NOT THREAD SAFE)
//    public static DBSingleton getInstance()
//    {
//
//        if(instance == null)
//        {
//            return new DBSingleton();
//        }
//        return instance;
//    }

    //IT IS THREAD SAFE
    public static DBSingleton getInstance() throws SQLException {
        //Here we did a double check in order
        // to avoid simultaneous
        //thread access
        //Thread will access to instanciation one by one
        // each one at a given point of time
        //-------------------------------------------------------------------------
        //A synchronized block in Java is synchronized on some object.
        // All synchronized blocks synchronized on the same object can
        // only have one thread executing inside them at a time. All other
        // threads attempting to enter the synchronized block are blocked until
        // the thread inside the synchronized block exits the block.
        if(instance == null)
        {
            if(instance == null) {
                synchronized (DBSingleton.class) {
                    instance = new DBSingleton();
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException {
        if(conn == null)
        {
            synchronized (DBSingleton.class){
                if(conn == null)
                {
                    String dbUrl = "jdbc:derby:Db;create=true";
                    conn = DriverManager.getConnection(dbUrl);
                }
            }
        }
        return conn;
    }


}
