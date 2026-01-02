/*
 * ClientManager er serverens kerne
 * Den lytter på en port og opretter nye ClientWorkers
 * for hver klient der forbinder
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

class ClientManager extends Thread {
    private ArrayList<ClientWorker> workers; // Liste over alle aktive klient-arbejdere
    private int port; // Portnummer som serveren lytter på
    private boolean stop; // Bruges til at stoppe server-loopet


    /*
     * Constructor
     * @param port portnummer som serveren skal lytte på
     */
    public ClientManager(int port) {
        this.port = port;
        this.stop = false;
        workers = new ArrayList<>();

    }

    /*
     * Main Server Loop.
     * Lytter efter nye klientforbindelser
     */
    public void run() {
        try {
            // Opretter server-socket med backlog på 100 forbindelser
            ServerSocket server = new ServerSocket(port, 100); //max 100 forbindelser

            // Timeout så accept() ikke blokerer uendeligt
            server.setSoTimeout(100);


            System.out.println("[ClientManager] Server online");

            // Server-loop: kører indtil stop bliver true
            while (!stop) {
                try {
                    // Venter på at en klient forbinder
                    Socket connection = server.accept();

                    // Opretter ny ClientWorker til klienten
                    ClientWorker worker = new ClientWorker(this, connection);

                    // Gemmer worker i listen
                    workers.add(worker);

                    // Starter worker-tråden
                    worker.start();

                    System.out.println("[ClientManager] Worker connected");
                } catch (SocketTimeoutException e) {
                    // ignore timeout, loop again
                }
            }


            // Lukker serveren når loopet stopper
            server.close();
            System.out.println("[ClientManager] Server offline");

        } catch (IOException e) {
            System.out.println("[ClientManager] I/O error");
        }
    }

    //Stopper server loop
    public void shutdown() {
        stop = true;
    }


}
