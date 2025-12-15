/*
 * Represents a chat client that connects to server
 * Has send and receive methods to interact with server
 */

import java.io.*;
import java.net.Socket;

public class EOClient extends Thread {
    private String name;

    public EOClient(String name) {
        this.name = name;
    }
    public void run() {
        try {

            Socket connection = new Socket( "127.0.0.1", 12345 );
            System.out.println( "[Client] Connection open" );

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

            sendLine(out, "82");
            System.out.println("[Client:"+ name +"] recieved line: " + in.readLine());
            sendLine(out, "19");
            System.out.println("[Client:"+ name +"] recieved line: " + in.readLine());
            sendLine(out, "43");
            System.out.println("[Client:"+ name +"] recieved line: " + in.readLine());
            sendLine(out, "2");
            System.out.println("[Client:"+ name +"] recieved line: " + in.readLine());
            sendLine(out, "61");
            System.out.println("[Client:"+ name +"] recieved line: " + in.readLine());

            in.close();
            out.close();
            connection.close();

            System.out.println( "[Client:"+ name +"] Connection closed" );
        }
        catch ( IOException e ) {
            System.out.println( "[Client:"+ name +"] Connection failed" );
        }
    }

    private void sendLine( BufferedWriter writer, String line )
            throws IOException
    {
        System.out.println( "[Client:"+ name +"] sending line: " + line );

        writer.write( line );
        writer.newLine();
        writer.flush();

    }
}