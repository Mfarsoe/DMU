

import Post.*;

class Main {
    public static void main( String[] argv ) {

        ABrev a = new ABrev( 140 );
        System.out.println( a + " porto=" + a.Porto() );

        BBrev b = new BBrev( 140 );
        System.out.println( b + " porto=" + b.Porto() );

        Pakke p = new Pakke( 1400 );
        System.out.println( p + " porto=" + p.Porto() );
    }
}