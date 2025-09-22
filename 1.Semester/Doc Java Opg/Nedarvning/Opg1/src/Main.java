public class Main {
    public static void main(String[] args) {
        Punkt p = new Punkt(0,0);
        System.out.println(p);

        Cirkel c = new Cirkel(p, 1);
        System.out.println(c);

        System.out.println("Omkreds: " + c.omkreds());
        System.out.println("Areal: " + c.areal());

        Punkt p2 = new Punkt(10,5);
        Rektangel rek = new Rektangel(p2, 5,3);
        System.out.println(rek);

        System.out.println("Arealet af 5*3 er: " + rek.area());
        System.out.println("Omkredsen af 5*3 er: " + rek.perimeter());

        rek.move(-3,3);
        System.out.println(rek);
    }
}
