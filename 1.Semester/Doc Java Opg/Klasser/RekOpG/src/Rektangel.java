public class Rektangel {
    private int yMin, yMax, xMin, xMax;

    //Constructors
    public Rektangel(int yMin, int yMax, int xMin, int xMax) {
        set(yMin, yMax, xMin, xMax);
    }
    public Rektangel(Rektangel r) {
        this(r.yMin, r.yMax, r.xMin, r.xMax);
    }
    //Set Method
    public void set(int yMin, int yMax, int xMin, int xMax) {
        this.yMin = yMin;
        this.yMax = yMax;
        this.xMin = xMin;
        this.xMax = xMax;
    }

    //toString Method
    public String toString() {
        return "[" + yMin + ", " + yMax + ", " + xMin + ", " + xMax + "]";
    }

}
