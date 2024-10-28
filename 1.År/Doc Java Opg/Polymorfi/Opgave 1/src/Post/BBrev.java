package Post;

public class BBrev extends Brev{



    public BBrev(double vægt) {
        super(vægt);
    }
    public double Porto() {
        if (vægt <= 20) {
            return 3.75;
        } else if (vægt <= 100) {
            return 5.00;
        } else if (vægt <= 250) {
            return 8.75;
        } else if (vægt <= 500) {
            return 15.00;
        } else if (vægt <= 1000) {
            return 19.00;
        } else if (vægt <= 2000) {
            return 27.00;
        } else
            return -1;
    }

    public String toString() {
        return "[Post.BBrev: " + vægt + " gram]";
    }
}
