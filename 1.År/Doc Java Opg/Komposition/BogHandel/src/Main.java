public class Main {
    public static void main(String[] args) {
        bogTest();
        bogHandelTest();
    }
    public static void bogTest() {
        Bog b1 = new Bog("Java: how to program", "Deitel & Deitel", 8, 497);
        Bog b2 = new Bog("Beginning Java 2", "Ivor Horton", 3, 495);

        System.out.println(b1.toString());
        System.out.println(b2.toString());

        b1.subAntal(2);
        b2.setBogPris(395);
        b2.addAntal(3);

        System.out.println(b1.toString());
        System.out.println(b2.toString());
    }
    public static void bogHandelTest() {
        Bog b1 = new Bog("Java: how to program", "Deitel & Deitel", 8, 497);
        Bog b2 = new Bog("Beginning Java 2", "Ivor Horton", 3, 495);
        BogHandel bH = new BogHandel(b2);
        bH.addAntal(8);
        System.out.println(bH.toString());
        bH.setObject(b1);
        bH.setPris(299);
        System.out.println(bH.toString());
    }
}
