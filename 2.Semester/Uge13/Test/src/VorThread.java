public class VorThread extends Thread {
    private int id;

    public VorThread( int id ) {
        this.id = id;
    }

    public void run() {
        System.out.println( "Hello I'm thread no.: " + id );
    }
}