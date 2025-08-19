/*
 * Represents a chat client that connects to server
 * Has send and receive methods to interact with server
 */

import java.io.*;
import java.net.Socket;

public class ChatClient {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;



    //Connects to the server on given host and port
    public ChatClient(String host, int port) throws IOException {
        socket = new Socket(host, port);
        in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    //Sends command to server
    public void send(String msg) {
        out.println(msg);
    }

    //Receives a response from server
    public String receive() throws IOException {
        return in.readLine();
    }

    //Close connection
    public void close() throws IOException {
        socket.close();
    }
}
