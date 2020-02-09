package Builder;

/**
 * Created by Elimane on Feb, 2020, at 22:49
 */
public class LunshOrderBeanTelescoping {

    //Here there is no setters exposed

    private String bread;
    private String condiments;
    private String dressing;
    private String meat;

    public LunshOrderBeanTelescoping(String bread) {
        this.bread = bread;
    }

    public LunshOrderBeanTelescoping(String bread, String condiments) {
        this(bread);
        this.bread = bread;
        this.condiments = condiments;
    }

    public LunshOrderBeanTelescoping(String bread, String condiments, String dressing) {
        this(bread, condiments);
        this.bread = bread;
        this.condiments = condiments;
        this.dressing = dressing;
    }

    public LunshOrderBeanTelescoping(String bread, String condiments, String dressing, String meat) {
        this(bread, condiments, dressing);
        this.bread = bread;
        this.condiments = condiments;
        this.dressing = dressing;
        this.meat = meat;
    }

    public String getBread() {
        return bread;
    }

    public String getCondiments() {
        return condiments;
    }

    public String getDressing() {
        return dressing;
    }

    public String getMeat() {
        return meat;
    }
}
