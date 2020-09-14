package Factory;

public class VehicleFactory {
    public static Vehicle getInstance(String type, int wheel) {
        if (type == "car") {
            return new Car(wheel);
        } else if (type == "bike") {
            return new Bike(wheel);
        }
        return null;
    }

}

abstract class Vehicle {
    public abstract int getWheel();

    public String toString() {
        return "Wheel" + this.getWheel();
    }
}

class Car extends Vehicle {

    int wheel;

    public Car(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}

class Bike extends Vehicle {

    int wheel;

    public Bike(int wheel) {
        this.wheel = wheel;
    }

    @Override
    public int getWheel() {
        return this.wheel;
    }
}