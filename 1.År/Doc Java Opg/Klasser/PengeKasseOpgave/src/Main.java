public class Main {
    public static void main(String[] args) {
        PengeKasse p = new PengeKasse();
        System.out.println(p.toString());
        p.set(5, 10);
        System.out.println(p.sum());
    }
}