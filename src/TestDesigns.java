import singleton.DBSingleton;

/**
 * Created by Elimane on Jan, 2020, at 00:42
 */
public class TestDesigns {
    public static void main(String[] args)
    {
        DBSingleton instance = DBSingleton.getInstance();
        DBSingleton instance2 = DBSingleton.getInstance();

        System.out.println(instance);
        System.out.println(instance2);

        String result = (instance2 == instance) ? "They are the same instances" : "Not the same";

        System.out.println(result);
    }
}
