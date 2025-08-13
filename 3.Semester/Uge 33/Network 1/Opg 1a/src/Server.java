import java.io.*;
import java.net.*;


public class Server extends Thread {
    private DatagramSocket socket;

    @Override
    public void run() {
        try{
            socket = new DatagramSocket();
            byte[] buffer = new byte[1024];

            DatagramSocket server = new DatagramSocket(8888);
            System.out.println("[Server] Online");

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            String line="";
            while(!line.equals("<end>")){
                server.receive(packet);
                System.out.println("[Server] Received: " + packet.getLength() + " bytes");
                line = getLine(packet);
                if(!line.equals("<end>")){
                    sendLine(packet.getAddress(), line.toUpperCase());
                }
            }
            //er måske redundant
            server.close();
            System.out.println("[Server] Offline");

        } catch (IOException e){
            System.out.println("[Server] I/O Error: " +e.getMessage());
        }
    }

    private String getLine(DatagramPacket packet){
        String s = new String(packet.getData(), 0 , packet.getLength());
        System.out.println("[Server] received line: " + s);
        return s;
    }

    private void sendLine(InetAddress ip, String line) throws IOException {
        byte[] buffer = line.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ip, 8889);

        System.out.println("[Server] sending line: " + line);
        socket.send(packet);
    }
}
