public class Main {

    public static void main( String[] argv ) {

        for ( int i=Thread.MIN_PRIORITY; i<=Thread.MAX_PRIORITY; i++ ) {
            Thread thread = new PrioThread();
            thread.setPriority( i );
            thread.start();
        }
    }
}