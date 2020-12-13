import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class JavaNIOReaderWriter {

    public static void main(String[] args) {

        try {

            RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/myFile.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);

            StringBuilder stringBuilder = new StringBuilder();
            while (fileChannel.read(byteBuffer) > 0) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    byte b = byteBuffer.get();
                    stringBuilder.append((char) b);
                }
                byteBuffer.clear();
            }
            System.out.println(stringBuilder);
            String string = stringBuilder.toString();
            stringBuilder.setLength(0);
            stringBuilder.append("\n" + "Hello, " + string + "! Welcome to my JavaNIOReaderWriter");
            System.out.println(stringBuilder);

            byteBuffer = ByteBuffer.wrap(stringBuilder.toString().getBytes());
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
            fileChannel.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

}
