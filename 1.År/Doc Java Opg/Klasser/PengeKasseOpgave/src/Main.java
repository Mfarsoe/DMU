public class Main {
    public static void main(String[] args) {
        PengeKasse p1 = new PengeKasse();

        p1.set(20, 1);
        p1.set(10, 2);
        p1.set(5, 0);
        p1.set(2, 1);
        p1.set(1, 0);

        System.out.print("20:" + p1.get(20) + ", ");
        System.out.print("10:" + p1.get(10) + ", ");
        System.out.print("5:" + p1.get(5) + ", ");
        System.out.print("2:" + p1.get(2) + ", ");
        System.out.print("1:" + p1.get(1));
        System.out.println();


        System.out.println("[p1] indhold: " + p1);

        System.out.println("[p1] sum: " + p1.sum());

        PengeKasse p2 = new PengeKasse(p1);
        System.out.println("[p1] lig med [p2]: " + p1.equals(p2));

        p1.add(p2);
        System.out.println("[p1] indhold: " + p1);
        System.out.println("[p2] indhold: " + p2);


        PengeKasse tilbage = p1.givTilbage(14);
        System.out.println("[tilbage] indhold: " + tilbage);


        //PengeKasse tilbage2 = p1.givTilbage2(14);
        //System.out.println("[tilbage2] indhold: " + tilbage2);


    }
}