import java.net.*;
import java.io.*;
import java.util.LinkedList;

public class Manager extends Thread {
    private LinkedList workers;
    private int port;
    private boolean running;


    public Manager(int port) {
        this.port = port;
        this.running = true;
        workers = new LinkedList();
    }

    @Override
    public void run(){
        ServerSocket server;
        Socket conn;

        try {
            server = new ServerSocket(port, 100);
            server.setSoTimeout(100);
            System.out.println("[Manager] Server started");

            while(running) {
                try {
                    conn = server.accept();

                    Worker w = new Worker (this, conn);
                    workers.add(w);
                    w.start();
                } catch (SocketTimeoutException e){
                    System.out.println("[Manager] Socket timed out");
                }
            }
            System.out.println("[Manager] Server stopped");
        } catch (IOException e){
            System.out.println("[Manager] I/O Error: " + e.getMessage());
        }
    }
}
