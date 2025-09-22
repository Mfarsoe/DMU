public class Cirkel extends Punkt{
    private double radius;


    public Cirkel(Punkt punkt, double radius) {
        super(punkt);
        this.radius = radius;
    }

    public double areal() {
        return Math.PI * radius * radius;
    }

    public double omkreds() {
        return 2 * Math.PI * radius;
    }

    public String toString() {
        return "[" + super.toString() + ", radius=" + radius + "]";
    }
}
