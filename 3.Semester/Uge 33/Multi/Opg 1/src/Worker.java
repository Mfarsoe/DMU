import java.net.Socket;

public class Worker extends Thread {
    private Socket conn;
    private Manager manager;


    public Worker(Manager manager, Socket conn) {
        this.conn = conn;
        this.manager = manager;
    }

    @Override
    public void run() {
        
    }
}
