public class Main {
    public static void main(String[] args) {
        Punkt p1 = new Punkt(3,0);
        Punkt p2 = new Punkt(0,4);
        Linie l1 = new Linie(p1,p2);
        System.out.println(l1.length());
    }
}
