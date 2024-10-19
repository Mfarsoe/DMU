public class Punkt {
    private double x;
    private double y;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Punkt(Punkt other) {
        this(other.x, other.y);
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
