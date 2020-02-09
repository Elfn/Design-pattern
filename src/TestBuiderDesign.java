import Builder.LunshOrderBean;
import Builder.LunshOrderBeanTelescoping;
import Builder.LunshOrderBuilder;
import singleton.DBSingleton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Elimane on Jan, 2020, at 00:42
 */
public class TestBuiderDesign {
    public static void main(String[] args) throws SQLException {
        //1- Expose Setters (Bean method)
        LunshOrderBean lunshOrderBean = new LunshOrderBean();

        lunshOrderBean.setBread("Wheat");
        lunshOrderBean.setCondiments("Lettuce");
        lunshOrderBean.setDressing("Mustard");
        lunshOrderBean.setMeat("Ham");

        System.out.println(lunshOrderBean.getBread());
        System.out.println(lunshOrderBean.getCondiments());
        System.out.println(lunshOrderBean.getDressing());
        System.out.println(lunshOrderBean.getMeat());


        //2- Use Telescopic constructors (Telescopic method) which means a constructors with parameters variation

        LunshOrderBeanTelescoping lunshOrderBeanTele = new LunshOrderBeanTelescoping("Wheat", "Lettuce", "Mustard", "Ham");

        System.out.println(lunshOrderBeanTele.getBread());
        System.out.println(lunshOrderBeanTele.getCondiments());
        System.out.println(lunshOrderBeanTele.getDressing());
        System.out.println(lunshOrderBeanTele.getMeat());

        //3- Builder Pattern Test
        LunshOrderBuilder.Builder builder = new LunshOrderBuilder.Builder();

        builder.bread("Wheat").condiments("Lettuce").dressing("Mayo").meat("Turkey");

        LunshOrderBuilder orderBuilder = builder.build();

        System.out.println(orderBuilder.getBread());
        System.out.println(orderBuilder.getCondiments());
        System.out.println(orderBuilder.getDressing());
        System.out.println(orderBuilder.getMeat());

    }
}
