/*
 * Represents a chat client that connects to server
 * Has send and receive methods to interact with server
 */

import java.io.*;
import java.net.Socket;

public class EOClient extends Thread {
    private String name;
    private int[] numbers;

    public EOClient(String name, int[] numbers) {
        this.name = name;
        this.numbers = numbers;
    }
    public void run() {
        try {

            Socket connection = new Socket( "127.0.0.1", 12345 );
            System.out.println( "[Client] Connection open" );

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

            //Loop igennem numrene og udskriv svaret fra serveren
            for (int i = 0; i < numbers.length; i++) {
                sendLine(out, String.valueOf(numbers[i]));
                System.out.println("[Client:"+ name +"] recieved line: " + in.readLine());
            }

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