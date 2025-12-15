import java.net.*;
import java.io.*;

public class EvenOddServer extends Thread {
    private boolean firstEven = true;
    private boolean firstOdd = true;
    @Override
    public void run() {
        try {
            //Server oprettes
            ServerSocket ss = new ServerSocket(8888);
            System.out.println("[Server] Online");

            //Lytter efter clienter
            Socket connection = ss.accept();

            //Opretter input og output
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));

            //Så længe input ikke er <end> bliver serveren ved med at sende tilbage om det er lige eller ulige og sender det til output.
            String line="";
            while ( !line.equals("<end>")) {
                line = in.readLine();
                System.out.println("[Server] recieved line: " + line);
                if (!line.equals("<end>")) {
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
