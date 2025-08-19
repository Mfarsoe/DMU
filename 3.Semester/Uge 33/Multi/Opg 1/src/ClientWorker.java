/*
 * Handles communication with a single connected client.
 * Runs in its own thread and interprets commands: LOGIN, MESSAGE, GET, LOGOUT
 */
import java.net.*;
import java.io.*;

class ClientWorker extends Thread {
    private ClientManager manager;
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;
    private String userId;

    public ClientWorker(ClientManager manager, Socket socket) {
        this.manager = manager;
        this.socket = socket;
    }

    //Main loop for handling client commands
    public void run() {
        try {
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            String line;
            while ((line = in.readLine()) != null) {
                //Split input at spaces, limited to 3
                String[] parts = line.split(" ", 3);
                String cmd = parts[0].toUpperCase();

                switch (cmd) {
                    case "LOGIN":
                        handleLogin(parts);
                        break;

                    case "MESSAGE":
                        handleMessage(parts);
                        break;

                    case "GET":
                        handleGet();
                        break;

                    case "LOGOUT":
                        handleLogout();
                        return; //stop thread

                    default:
                        out.println("ERROR: Unknown command");
                }
            }
        } catch (IOException e) {
            System.out.println("[ClientWorker] I/O error: " + e.getMessage());
        }
    }

    //Handles LOGIN <userid>.
    private void handleLogin(String[] parts) {
        if (parts.length >= 2) {
            userId = parts[1];
            out.println("OK: Logged in as " + userId);
        } else {
            out.println("ERROR: Missing userId");
        }
    }

    //Handles MESSAGE <userid> <test>. Calls ServerManager to store message
    private void handleMessage(String[] parts) {
        if (userId == null) {
            out.println("ERROR: You must LOGIN first");
        } else if (parts.length >= 3) {
            String to = parts[1];
            String msg = parts[2];
            manager.storeMessage(to, userId, msg);
            out.println("OK: Message stored for " + to);
        } else {
            out.println("ERROR: Usage MESSAGE <to> <msg>");
        }
    }

    //Handles GET. Calls ServerManager to retrieve message
    private void handleGet() {
        if (userId == null) {
            out.println("ERROR: You must LOGIN first");
        } else {
            String msg = manager.getMessage(userId);
            if (msg == null) {
                out.println("no messages");
            } else {
                out.println(msg);
            }
        }
    }

    //Handles LOGOUT
    private void handleLogout() {
        out.println("Goodbye");
    }
}
