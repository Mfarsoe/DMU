package Bolig;

public class Lejlighed extends Bolig{
    private double husleje;

    public Lejlighed(double areal, double husleje) {
        super(areal);
        this.husleje = husleje;
    }

    public Lejlighed(Lejlighed lejlighed) {
        super(lejlighed);
        this.husleje = lejlighed.husleje;
    }

    public String toString() {
        return "[Lejlighed: " + super.toString() + ", husleje=" + husleje + "]";
    }


    @Override
    public double årligHusleje() {
        return husleje * 12;
    }
}
