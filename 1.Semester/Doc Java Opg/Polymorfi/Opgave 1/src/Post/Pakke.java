package Post;

public class Pakke extends Forsendelse{

    public Pakke(double vægt) {
        super(vægt);
    }
    public double Porto() {
        if (vægt <= 1000) {
            return 30.25;
        } else if (vægt <= 5000) {
            return 32.25;
        } else if (vægt <= 10000) {
            return 41.00;
        } else if (vægt <= 15000) {
            return 61.00;
        } else if (vægt <= 20000) {
            return 67.00;
        } else
            return -1;
    }

    public String toString() {
        return "[Post.Pakke: " + vægt + " gram]";
    }
}
