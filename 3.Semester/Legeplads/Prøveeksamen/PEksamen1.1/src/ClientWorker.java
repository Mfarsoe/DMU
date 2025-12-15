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
    private BufferedWriter out;
    private boolean firstEven = true;
    private boolean firstOdd = true;

    public ClientWorker(ClientManager manager, Socket socket) {
        this.manager = manager;
        this.socket = socket;
    }

    //Main loop for handling client commands
    public void run() {
        try {
            in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            String line="";
            while ( line != null) {
                line = in.readLine();
                System.out.println("[Server] recieved line: " + line);
                if (line != null) {
                    sendLine(out, calculateEvenOdd(line));
                }
            }

            //Lukker for indput og output så snart vores loop er afsluttet. Dette lukker også for vores connection automatisk
            in.close();
            out.close();
            System.out.println("[Server] closed");

        }catch (IOException e){
            System.out.println("[Server] I/O Error: " + e);
        }
    }

    private String calculateEvenOdd(String s){
        int num = Integer.parseInt(s);
        if(num % 2 == 0){
            if (firstEven){
                firstEven = false;
                return "Lige";
            }
            return "igen lige";
        }
        else {
            if (firstOdd){
                firstOdd = false;
                return "Ulige";
            }
            return "igen ulige";
        }
    }

    //Send besked til clienten.
    private void sendLine(BufferedWriter out, String line) throws IOException {
        System.out.println("[Server] sending line: " + line);
        out.write(line);
        out.newLine();
        out.flush();
    }
}

