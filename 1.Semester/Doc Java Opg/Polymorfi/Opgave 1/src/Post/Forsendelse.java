package Post;

public abstract class Forsendelse {
    protected double vægt;


    public Forsendelse(double vægt) {
        this.vægt = vægt;
    }
    public abstract double Porto();
}
