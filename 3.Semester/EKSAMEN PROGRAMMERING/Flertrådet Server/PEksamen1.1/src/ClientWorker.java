/*
 * ClientWorker håndterer kommunikationen med én klient
 * Klassen kører i sin egen tråd
 */
import java.net.*;
import java.io.*;

class ClientWorker extends Thread {
    private final ClientManager manager; // Reference til server-manageren
    private final Socket socket; // Socket-forbindelse til klienten

    // Holder styr på om klienten tidligere har sendt
    // et lige eller ulige tal
    private boolean firstEven = true;
    private boolean firstOdd = true;

    /*
     * Constructor
     * @param manager reference til ClientManager
     * @param socket klientens socket-forbindelse
     */
    public ClientWorker(ClientManager manager, Socket socket) {
        this.manager = manager;
        this.socket = socket;
    }

    //Hovedloop for klientkommunikation
    public void run() {

        //Try-with-resources som altid lukker ressourcerne

        //Try-with-resources er best practice, fordi det sikrer at alle streams
        // og sockets altid bliver lukket korrekt – også hvis der opstår exceptions.
        // Det forhindrer resource leaks, reducerer mængden af kode og gør
        // programmet mere robust og vedligeholdelsesvenligt.
        //Alternativ er en try-catch-finally, men det er mere kode
        try (
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {


            String line;
            // Læser linjer fra klienten indtil forbindelsen lukkes
            while ((line = in.readLine()) != null) {
                System.out.println("[Server] received line: " + line);
                sendLine(out, calculateEvenOdd(line));
            }

            System.out.println("[Server] closed");

        }catch (IOException e){
            System.out.println("[Server] I/O Error: " + e);
        }
    }

    private String calculateEvenOdd(String s){
        try{
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
        } catch (NumberFormatException e){
            return "[Server] Fejl: Ikke et gyldigt tal";
        }
    }

    //Send besked til client.
    private void sendLine(BufferedWriter out, String line) throws IOException {
        System.out.println("[Server] sending line: " + line);
        out.write(line);
        out.newLine();
        out.flush();
    }
}

