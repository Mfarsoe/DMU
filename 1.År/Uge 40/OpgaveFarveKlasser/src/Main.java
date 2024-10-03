public class Main {
    public static void main(String[] args) {
        Farve farve = new Farve();
        farve.set(233,6,0);
        System.out.println(farve.toString());
        Farve farve2 = new Farve(farve);
        System.out.println(farve2.toString());
    }
}