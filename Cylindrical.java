package Project_5;

public class Cylindrical extends Container {

    private double radius;
    private double height;

    public Cylindrical(double wallThickness, double wallDensity, double radius, double height) {
        super(wallThickness, wallDensity);
        this.radius = radius;
        this.height = height;
    }

    @Override
    double getInteriorVolume() {
        double inside = radius - super.getWallThickness();
        return Math.PI*Math.pow(inside, 2)*(height - 2*super.getWallThickness());
    }

    @Override
    double getExteriorVolume() {
        return Math.PI*Math.pow(radius, 2)*height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return super.toString() + "\nradius: " + radius + "\nheight: " + height;
    }

}
