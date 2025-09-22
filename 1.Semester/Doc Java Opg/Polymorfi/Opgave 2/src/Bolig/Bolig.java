package Bolig;

public abstract class Bolig {
    private double areal;

    public Bolig (double areal) {
        this.areal = areal;
    }

    public Bolig (Bolig bolig) {
        this.areal = bolig.areal;
    }

    public String toString() {
        return "[areal = " + areal + "]";
    }

    public abstract double årligHusleje();
}
