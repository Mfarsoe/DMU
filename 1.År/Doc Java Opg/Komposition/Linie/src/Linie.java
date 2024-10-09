public class Linie {
    private Punkt a,b;

    public Linie(Punkt a, Punkt b) {
        this.a = a;
        this.b = b;
    }

    public double length() {
        return Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
    }
}
