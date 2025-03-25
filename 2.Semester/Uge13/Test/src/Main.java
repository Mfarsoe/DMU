public class Main {

    public static void main( String[] argv ) {

        for ( int i=0; i<5; i++ ) {
            VorThread tråd = new VorThread( i );
            tråd.start();
        }
    }
}