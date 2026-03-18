import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HentMenu {
    public static void main(String[] args) {
        try {
            // Hent HTML fra siden
            Document doc = Jsoup.connect("http://docjava.dk/").get();

            // Find menuen – typisk i en <ul> med class eller id, her antager vi "menu"
            Elements menuItems = doc.select("ul.menu li a"); // ændr selector efter behov

            System.out.println("Menu punkter:");
            for (Element item : menuItems) {
                System.out.println(item.text() + " -> " + item.attr("href"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}