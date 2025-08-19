/*
 * ClientManager is the server core
 * Listens to given port, and creates new ClientWorker thread.
 * It also stores messages and retrieves them
 */
import java.net.*;
import java.io.*;
import java.util.ArrayList;

class ClientManager extends Thread {
    private ArrayList<ClientWorker> workers;
    private ArrayList<Message> messages;
    private int port;
    private boolean stop;

    /*
     * Constructor for ClientManager with following parameters:
     * port  = port the ClientManager will listen to
     */
    public ClientManager(int port) {
        this.port = port;
        this.stop = false;
        workers = new ArrayList<>();
        messages = new ArrayList<>();
    }

    /*
     * Main Server Loop. Listens for new connections and starts new ClientWorkers
     */
    public void run() {
        try {
            ServerSocket server = new ServerSocket(port, 100);
            server.setSoTimeout(100);
            System.out.println("[ClientManager] Server online");

            while (!stop) {
                try {
                    Socket connection = server.accept();
                    ClientWorker worker = new ClientWorker(this, connection);
                    workers.add(worker);
                    worker.start();
                } catch (SocketTimeoutException e) {
                    // ignore timeout, loop again
                }
            }

            server.close();
            System.out.println("[ClientManager] Server offline");
        } catch (IOException e) {
            System.out.println("[ClientManager] I/O error");
        }
    }

    //Stops server loop
    public void shutdown() {
        stop = true;
    }

    //Stores messages in array
    public synchronized void storeMessage(String to, String from, String message) {
        messages.add(new Message(to, from, message));
    }

    //Retrives and removes message from list for given user
    public synchronized String getMessage(String userName) {
        for (Message message : messages) {
            if (message.isTo(userName)) {
                messages.remove(message);
                return message.getMessage();
            }
        }
        return null; //If no messages return null
    }
}
