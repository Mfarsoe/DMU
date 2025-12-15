import java.net.*;
import java.io.*;

public class Client extends Thread {

    @Override
    public void run() {
        try{
            //åbner forbindelse til server på localhost og port 8888
            Socket connection = new Socket("127.0.0.1", 8888);
            System.out.println("[Client] Connection Established");

            //opret input og output
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));


            //test af funktionalitet

            sendLine(out, "82");
            System.out.println("[Client] recieved line: " + in.readLine());
            sendLine(out, "19");
            System.out.println("[Client] recieved line: " + in.readLine());
            sendLine(out, "43");
            System.out.println("[Client] recieved line: " + in.readLine());
            sendLine(out, "2");
            System.out.println("[Client] recieved line: " + in.readLine());
            sendLine(out, "61");
            System.out.println("[Client] recieved line: " + in.readLine());

            //Lukker forbindelsen
            sendLine(out, "<end>");

            //Lukker buffered reader og write som automatisk lukker connection.
            in.close();
            out.close();
            System.out.println("[Client] Connection closed");

        } catch (IOException e){
            System.out.println("[Client] I/O Error: ");
        }
    }

    //Send besked til server
    private void sendLine(BufferedWriter out, String line) throws IOException {
        System.out.println("[Client] sending line: " + line);
        out.write(line);
        out.newLine();
        out.flush();
    }




}
