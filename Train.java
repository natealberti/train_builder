package Project_5;

import java.util.ArrayList;

public class Train {

    private String engineer;
    private Engine engine;
    private ArrayList<Car> cars = new ArrayList<>();

    public Train(String engineer, Engine engine) {
        this.engineer = engineer;
        this.engine = engine;
    }

    public String getEngineer() {
        return engineer;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getNumOfCars() {
        try {
            return cars.size();
        } catch(Exception e) {
            return 0;
        }
    }

    //return total weight of the train
    public double getTotalWeight() {
        double weight = engine.getWeight();
        for(int i = 0; i < cars.size(); i++) {
            weight += cars.get(i).getWeight();
        }
        return weight;
    }

    //return total value of the train
    public double getTotalValue() {
        double value = 0;
        for(int i = 0; i < cars.size(); i++) {
            value += cars.get(i).getValue();
        }
        return value;
    }

    //add a car to the train
    public void addCar(Car car) {
        cars.add(car);
    }

    //delete a car from the train
    public void deleteCar(int ID) {
        for(int i = 1; i < cars.size(); i++) {
            if(cars.get(i).getID() == ID)
                cars.remove(i);
        }
    }

    //change the load factor on a particular car
    public void changeLoadFactor(int ID, double loadFactor) {
        for(int i = 1; i < cars.size(); i++) {
            if(cars.get(i).getID() == ID)
                cars.get(i).setLoadFactor(loadFactor);
        }
    }

    //returns a list of cars in the train with their respective ID, weight, and value
    public String displayCarsSummary() {
        String str = "";
        for(int i = 0; i < cars.size(); i++) {
            str += "ID " + cars.get(i).getID() + ":\n\tweight: " + cars.get(i).getWeight() + "lbs"
                    + "\n\tvalue: $" + cars.get(i).getValue() + "\n";
        }
        return str;
    }

    //returns full list of info on train, engine, and all the cars
    public String displayFullSummary() {
        String trainInfo = "\nTrain information: " + "\n\tengineer: " + getEngineer() + "\n\tnumber of cars: "
                + getNumOfCars() + "\n";

        String engineInfo = "Engine information:" + "\n\towner: " + engine.getOwner() + "\n\tpulling capacity: "
                + engine.getPullingCapacity() + "lbs\n";

        String str = trainInfo + engineInfo;
        return str;
    }

    //returns total weight and value of the train, as well as number of cars
    public String displayBriefSummary() {
        String str = "\nTotal train weight: " + getTotalWeight() + "lbs\nTotal train value: $" + getTotalValue()
                + "\nNumber of cars: " + getNumOfCars();
        return str;
    }

}
