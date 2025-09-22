public class Punkt {
    private int x;
    private int y;

    public Punkt(int x, int y) {
        set(x, y);
    }
    public Punkt(Punkt punkt){
        set(punkt.x, punkt.y);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    private void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
