package Prototype;

import java.util.ArrayList;
import java.util.List;

public class Prototype {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.insertData();

        try {
            Vehicle v2 = (Vehicle) v1.clone();
            List<String> list = v2.getVehicleList();
            list.add("v11");

            System.out.println(v1.getVehicleList());
            System.out.println(list);

            v2.getVehicleList().remove("v2");
            System.out.println(list);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}

class Vehicle implements Cloneable {
    private List<String> vehicleList;

    public Vehicle() {
        this.vehicleList = new ArrayList<>();
    }

    public Vehicle(List<String> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public void insertData() {
        vehicleList.add("v1");
        vehicleList.add("v2");
        vehicleList.add("v3");
        vehicleList.add("v4");
        vehicleList.add("v5");
    }

    public List<String> getVehicleList() {
        return vehicleList;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> tempList = new ArrayList<>();
        for (String s : getVehicleList()) {
            tempList.add(s);
        }
        return new Vehicle(tempList);
    }
}
