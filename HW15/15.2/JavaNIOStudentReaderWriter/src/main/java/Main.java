import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        try {
            JavaNIOReaderWriter javaNIOReaderWriter = new JavaNIOReaderWriter();
            Student student = new Student("Ivan Ivanov",
                    "men",
                    LocalDate.of(2003, 05, 15));
            RandomAccessFile randomAccessFile = new RandomAccessFile("src/main/resources/myFile.txt", "rw");
            FileChannel fileChannel = randomAccessFile.getChannel();
            System.out.println(javaNIOReaderWriter.readStudent(fileChannel));
            javaNIOReaderWriter.writeStudent(fileChannel, student);
            fileChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
