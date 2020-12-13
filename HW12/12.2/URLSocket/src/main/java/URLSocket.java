import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

public class URLSocket {

    public static void main(String[] args) {
        System.out.println("Starting...");
        String s = "https://music.youtube.com/";
        URL url = null;
        try {
            url = new URL(s);
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }
        Socket client;
        BufferedReader fromWebsite;
        PrintWriter toWebsite;
        try {
            System.out.println(url.getHost());
            System.out.println(url.getDefaultPort());

            client = new Socket(url.getHost(), url.getDefaultPort());
            fromWebsite = new BufferedReader(new InputStreamReader(client.getInputStream()));
            toWebsite = new PrintWriter(client.getOutputStream(), true);

            System.out.println(url.getPath());
            toWebsite.println("GET " + url.getPath() + " HTTP/1.1");
            toWebsite.println("Connection: close");

            fromWebsite.readLine();
            while (fromWebsite != null) {
                System.out.println(fromWebsite);
                fromWebsite.readLine();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

}
