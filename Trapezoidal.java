package Project_5;

public class Trapezoidal extends Container {

    private double upLength;
    private double lowLength;
    private double width;
    private double height;

    public Trapezoidal(double wallThickness, double wallDensity, double upLength,
                       double lowLength, double width, double height) {
        super(wallThickness, wallDensity);
        this.upLength = upLength;
        this.lowLength = lowLength;
        this.width = width;
        this.height = height;
    }

    @Override
    double getInteriorVolume() {
        return 0.5*(upLength-2*super.getWallThickness()+lowLength-2*super.getWallThickness())
                *(width-2*super.getWallThickness())*(height-super.getWallThickness());
    }

    @Override
    double getExteriorVolume() {
        return 0.5*(upLength+lowLength)*width*height;
    }

    public double getUpLength() {
        return upLength;
    }

    public double getLowLength() {
        return lowLength;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public String toString() {
        return super.toString() + "\nupper length: " + upLength + "\nlower length: "
                + lowLength + "\nwidth: " + width + "\nheight: " + height;
    }
}
