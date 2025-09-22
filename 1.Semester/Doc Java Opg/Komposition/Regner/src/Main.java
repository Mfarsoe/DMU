public class Main {
    public static void main(String[] args) {
        Regner regner = new Regner(3.0);
        RegnerHandle R = new RegnerHandle(regner);

        System.out.println(R.f(4.0));

        Regner regner2 = new Regner(5.0);
        R.setR(regner2);

        System.out.println(R.f(4.0));
    }
}
