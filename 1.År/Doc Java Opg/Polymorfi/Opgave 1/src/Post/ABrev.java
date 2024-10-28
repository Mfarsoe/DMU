package Post;

public class ABrev extends Brev{


    public ABrev(double vægt){
        super(vægt);
    }


    public double Porto() {
        if (vægt <= 20) {
            return 4.0;
        } else if (vægt <= 100) {
            return 5.25;
        } else if (vægt <= 250) {
            return 9.25;
        } else if (vægt <= 500) {
            return 16.00;
        } else if (vægt <= 1000) {
            return 20.00;
        } else if (vægt <= 2000) {
            return 28.00;
        } else
            return -1;
    }

    public String toString() {
        return "[Post.ABrev: " + vægt + " gram]";
    }
}
