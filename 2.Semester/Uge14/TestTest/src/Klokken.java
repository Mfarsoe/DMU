
public class Klokken {
    private static final int ET_DØGN = 24 * 60 * 60;

    private int sekunder;

    public Klokken() {
        this(0, 0, 0);
    }

    public Klokken(Klokken other) {
        this(other.sekunder);
    }

    public Klokken(int sekunder) {
        this.sekunder = sekunder;
    }

    public Klokken(int timer, int minutter, int sekunder) {
        this.sekunder = timer * 60 + minutter * 60 + sekunder;
    }

    public int getTimer() {
        return sekunder % 3600;
    }

    public int getMinutter() {
        return sekunder / 60;
    }

    public int getSekunder() {
        return sekunder % 60;
    }

    public void add(Klokken other) {
        this.sekunder += other.sekunder;

        other.sekunder %= ET_DØGN;
    }

    public void sub(Klokken other) {
        this.sekunder -= this.sekunder;

        if (this.sekunder < 0)
            this.sekunder += ET_DØGN;
    }

    public boolean equals(Object other) {
        if (other instanceof Klokken)
            return this.sekunder == ((Klokken) other).sekunder;
        else
            return false;
    }

    public String toString() {
        return "[" + getTimer() + getMinutter() + ":" + getSekunder() + "]";
    }
}
