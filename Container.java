package Project_5;

public abstract class Container {

    private double wallThickness;
    private double wallDensity;

    public Container(double wallThickness, double wallDensity){
        this.wallThickness = wallThickness;
        this.wallDensity = wallDensity;
    }

    public double getWallDensity() {
        return wallDensity;
    }

    public double getWallThickness() {
        return wallThickness;
    }

    abstract double getInteriorVolume();

    abstract double getExteriorVolume();

    public double getWallWeight() {
        double vol = getExteriorVolume() - getInteriorVolume();
        return wallDensity * vol;
    }

    public String toString() {
        return "wall thickness: " + wallThickness + "\nwall density: " + wallDensity;
    }

}
