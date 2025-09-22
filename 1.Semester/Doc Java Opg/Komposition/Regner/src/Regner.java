public class Regner {
    private double k;

    public Regner(double k) {
        this.k = k;
    }
    public double f(double x) {
        return k*x*x+3;
    }
}
