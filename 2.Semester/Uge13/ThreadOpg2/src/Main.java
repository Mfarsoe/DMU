public class Main {

    public static void main( String[] argv ) {
        CascadeThread next = null;

        for ( int i=0; i<5; i++ ) {
            next = new CascadeThread( "Thread " + i, next );
            next.start();
        }

        next.isMyTurn();
    }
}