import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;


public class TextFil {

    public static TextFil instance;
    private boolean isClosed = false;


    public static TextFil getInstance() {
        if (instance == null) {
            instance = new TextFil();
        }
        return instance;
    }
    public void register(String tekst){
        if (!isClosed){
            try {
                //Time date som laves til en string
                LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                String formattedDate = now.format(formatter);


                FileWriter fileWriter = new FileWriter("log.txt", true);
                fileWriter.write(formattedDate + " " + tekst + System.lineSeparator());
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void close(){
        isClosed = true;
    }
}
