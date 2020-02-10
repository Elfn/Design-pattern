package Builder;

/**
 * Created by Elimane on Feb, 2020, at 22:49
 */
public class LunshOrderBuilder {

    //Ideal when we want to create objects with several parameters
    //And want them immutable


    //Inner static class to handle an object with severals params
    public static class Builder {

        private  String bread;
        private  String condiments;
        private  String dressing;
        private  String meat;

        public Builder() {
        }

        //THAT METHOD ALLOWS US TO CREATE BUILDER AND DISPLAY ALL VARIABLE'S VALUES
        public LunshOrderBuilder build()
        {
            return new LunshOrderBuilder(this);
        }

        //HERE WE RETURN BUILDER AND SET VARIABLES
        //IN ORDER TO MAKE AN OBJECT WITH VARIOUS
        // PARAMETERS
        public Builder bread(String bread)
        {
            this.bread = bread;
            return this;
        }

        public Builder condiments(String condiments)
        {
            this.condiments = condiments;
            return this;
        }

        public Builder dressing(String dressing)
        {
            this.dressing = dressing;
            return this;
        }

        public Builder meat(String meat)
        {
            this.meat = meat;
            return this;
        }
    }

    private final String bread;
    private final String condiments;
    private final String dressing;
    private final String meat;


    //Here we are dealing with outer class  to construct the builder
    private LunshOrderBuilder(Builder builder) {
            this.bread = builder.bread;
            this.condiments = builder.condiments;
            this.dressing = builder.dressing;
            this.meat = builder.meat;
    }


        public String getBread () {
            return bread;

        }


        public String getCondiments () {
            return condiments;

        }


        public String getDressing () {
            return dressing;

        }


        public String getMeat () {
            return meat;

        }



}
