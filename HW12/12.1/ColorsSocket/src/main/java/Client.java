import java.awt.*;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting client...");
        Socket s = null;
        OutputStream out = null;
        try {
            s = new Socket("localhost", 7779);
            out = s.getOutputStream();
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
            System.out.println("Enter R, G, B: ");
            int r = scanner.nextInt();
            int g = scanner.nextInt();
            int b = scanner.nextInt();
            if ( r < 0 || r > 255 || g<0 || g > 255 || b<0 || b > 255){
                System.out.println("Invalid values ​​for color detection!");
            } else {
                Color c = new Color(r, g, b);
                ByteBuffer buf = ByteBuffer.allocate(12);
                buf.putInt(r).putInt(g).putInt(b);
                System.out.println(">> " + c);
                System.out.println(Arrays.toString(buf.array()));
                try {
                    out.write(buf.array());
                    out.flush();
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }
    }

}
