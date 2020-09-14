package Builder;

public class Builder {
}

class Vehicle {
    //required parameter
    private String engine;
    private int wheel;

    //optional parameter
    private int airbags;

    public String getEngine() {
        return engine;
    }

    public int getWheel() {
        return wheel;
    }

    public int getAirbags() {
        return airbags;
    }

    public Vehicle(VehicleBuilder vehicleBuilder) {
        this.engine = vehicleBuilder.engine;
        this.wheel = vehicleBuilder.wheel;
        this.airbags = vehicleBuilder.airbags;
    }

    public static class VehicleBuilder {
        //required parameter
        private String engine;
        private int wheel;

        //optional parameter
        private int airbags;

        public VehicleBuilder(String engine, int wheel) {
            this.engine = engine;
            this.wheel = wheel;
        }

        public VehicleBuilder setAirbags(int airbags) {
            this.airbags = airbags;
            return this;
        }

        public Vehicle build(){
            return new Vehicle(this);
        }
    }


}
