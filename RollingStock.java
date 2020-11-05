package Project_5;

public abstract class RollingStock {

    private String owner;
    private int ID;
    private double weight;

    public RollingStock(String owner, int ID, double weight){
        this.owner = owner;
        this.ID = ID;
        this.weight = weight;
    }

    public String getOwner() {
        return owner;
    }

    public int getID() {
        return ID;
    }

    public double getWeight() {
        return weight;
    }

    public String toString() {
        return "owner: " + owner + "\nID: " + ID + "\nweight: " + weight;
    }

}
