package Project_5;

public class Engine extends RollingStock {

    private double pullingCap;

    public Engine(String owner, int ID, double weight, double pullingCapacity) {
        super(owner, ID, weight);
        this.pullingCap = pullingCapacity;
    }

    public double getPullingCapacity() {
        return pullingCap;
    }

    public String toString() {
        return super.toString() + "\npulling capacity: " + pullingCap;
    }

}
