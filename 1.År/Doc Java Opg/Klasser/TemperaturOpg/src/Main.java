public class Main {
    public static void main(String[] args) {
        Temperatur t1 = new Temperatur();
        t1.setCelcius(100);
        System.out.println(t1);
        t1.setFahrenheit(0);
        System.out.println(t1);


        Temperatur t2 = new Temperatur(t1);

        System.out.println("t1 og t2 er ens: " + t1.equals(t2));

        t1.setCelcius(0);
        System.out.println(t1);

        System.out.println("t1 compare to t2: " + t1.compareTo(t2));
    }
}
