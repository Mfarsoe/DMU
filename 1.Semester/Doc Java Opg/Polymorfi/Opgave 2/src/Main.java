import Bolig.*;


public class Main {
    public static void main(String[] args) {
        Bolig b1 = new Lejlighed( 70, 3000 );
        System.out.println( b1 + " årlig husleje: " + b1.årligHusleje() );

        Bolig b2 = new Villa( 110, 650000, 800, false );
        System.out.println( b2 + " årlig husleje: " + b2.årligHusleje() );

        Bolig b3 = new Villa( 140, 850000, 400, true );
        System.out.println( b3 + " årlig husleje: " + b3.årligHusleje() );

        Bolig b4 = new Lejlighed( (Lejlighed) b1 );
        System.out.println( b4 + " årlig husleje: " + b4.årligHusleje() );

        Bolig b5 = new Villa( (Villa) b3 );
        System.out.println( b5 + " årlig husleje: " + b5.årligHusleje() );
    }
}
