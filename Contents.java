package Project_5;

public class Contents {

    private String name;
    private double density;
    private double value;

    public Contents(String name, double density, double value) {
        this.name = name;
        this.density = density;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public double getDensity() {
        return density;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        value = value;
    }

    public String toString() {
        return "name: " + name + "\ndensity: "+ density + "\nvalue: " + value;
    }
}