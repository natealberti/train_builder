package Project_5;

public class Car extends RollingStock {

    private Contents contents;
    private Container container;
    private double loadFactor;

    public Car(String owner, int ID, double weight, Contents contents, Container container, double loadFactor) {
        super(owner, ID, weight);
        this.contents = contents;
        this.container = container;
        this.loadFactor = loadFactor;
    }

    public double getLoadFactor() {
        return loadFactor;
    }

    public double getValue() {
        return contents.getValue()*contents.getDensity()*container.getInteriorVolume()*loadFactor;
    }

    public void setLoadFactor(double loadFactor) {
        this.loadFactor = loadFactor;
    }

    public Contents getContents() {
        return contents;
    }

    public Container getContainer() {
        return container;
    }

    public String toString() {
        return super.toString() + "contents: " + contents.getName() + "\nload factor: " + loadFactor;
    }
}
