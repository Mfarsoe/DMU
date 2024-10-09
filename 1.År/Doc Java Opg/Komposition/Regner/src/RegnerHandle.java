public class RegnerHandle {
    private Regner R;

    public RegnerHandle(Regner x) {
        setR(x);
    }
    public double f(double x) {
        return R.f(x);
        }
    public void setR(Regner R) {
        this.R = R;
    }
}
