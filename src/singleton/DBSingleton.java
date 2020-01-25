package singleton;

/**
 * Created by Elimane on Jan, 2020, at 00:35
 */
public class DBSingleton {

    //1- Create the only one instance that we want to call
    //VOLATILE ensure that instance will remain a singleton throught many of it change in JVM
    //To protect against instanciation from reflection
    private static volatile DBSingleton instance = null;

    //2 - Create private construction only used by DbSingleton
    private DBSingleton() {
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
    public static DBSingleton getInstance()
    {

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


}
