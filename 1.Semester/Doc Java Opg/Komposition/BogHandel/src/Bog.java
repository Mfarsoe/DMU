public class Bog {
    private String BogTitle, Forfatter;
    private int BogAntal;
    private double BogPris;

    public Bog(String BogTitle, String Forfatter, int BogAntal, double BogPris) {
        this.BogTitle = BogTitle;
        this.Forfatter = Forfatter;
        this.BogAntal = BogAntal;
        this.BogPris = BogPris;
    }

    public Bog(Bog other) {
        this.BogTitle = other.BogTitle;
        this.Forfatter = other.Forfatter;
        this.BogAntal = other.BogAntal;
        this.BogPris = other.BogPris;
    }

    public void setBogPris(double x) {
        this.BogPris = x;
    }

    public void addAntal(double x) {
        this.BogAntal += x;
    }

    public void subAntal(double x) {
        if (this.BogAntal-x > 0) {
            this.BogAntal -= x;
        } else
            System.out.println("Invalid Subtraction");
    }

    public String toString() {
        return "Title: " + BogTitle + ",\n" +
               "Forfatter: " + Forfatter + ",\n" +
               "Antal: " + BogAntal + ",\n" +
               "Pris: " + BogPris + ",-\n";
    }
}
