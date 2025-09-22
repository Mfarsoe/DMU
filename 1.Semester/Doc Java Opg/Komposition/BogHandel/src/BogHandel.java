public class BogHandel {
    private Bog a;



    public BogHandel(Bog a) {
        setObject(a);
    }

    public void setObject(Bog a) {
        this.a = a;
    }

    public void setPris(double x) {
        a.setBogPris(x);
    }
    public void subAntal(int x) {
        a.subAntal(x);
    }
    public void addAntal(int x) {
        a.addAntal(x);
    }
    public String toString() {
        return a.toString();
    }
}
