import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Favorite {
    Date date;
    String videoName;
    URL url;

    public Favorite(String name, String address) throws MalformedURLException {
        this.videoName = name;
        this.url = new URL(address);
        this.date = new Date(); 
    }

    public String toString() {
        String s = this.videoName + " " + this.date + "\n";
        return s + url.toString();
    }
}
