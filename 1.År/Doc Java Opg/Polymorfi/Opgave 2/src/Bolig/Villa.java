package Bolig;

public class Villa extends Bolig{
    private double pris, grund;
    private boolean iBy;

    public Villa(double areal, double pris, double grund, boolean iBy) {
        super(areal);
        this.grund = grund;
        this.pris = pris;
        this.iBy = iBy;
    }

    public Villa(Villa villa) {
        super(villa);
        this.pris = villa.pris;
        this.iBy = villa.iBy;
        this.grund = villa.grund;
    }

    public String toString() {
        return "[Villa: " + super.toString() + ", pris: " + pris + ", iBy: " + iBy + "]";
    }

    @Override
    public double årligHusleje() {
        double leje = pris * 0.1;
        if (iBy) {
            return leje * 1.2;
        } else return leje;

    }
}
