public class Main {
    public static void main(String[] args) {
        Observer obsA, obsB;
        ConSubject sub;

        sub = new ConSubject( 1 );

        obsA = new AlarmObserver(3,sub);
        obsB = new PrintObserver(sub);

        for ( int i=2; i<5; i++ )
            sub.changeState( i );
    }
}
