import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.time.LocalDate;

public class JavaNIOReaderWriter {

    public Student readStudent(FileChannel fileChannel) {

        try {

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

            String[] array = stringBuilder.toString().split(", ");
            String[] birthDate = array[2].split("-");
            Student student = new Student(array[0], array[1], LocalDate.of(Integer.parseInt(birthDate[0]), Integer.parseInt(birthDate[1]), Integer.parseInt(birthDate[2])));
            return student;
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public void writeStudent(FileChannel fileChannel, Student student) {
        try {
            String string = "\n" + student.toString();
            ByteBuffer byteBuffer = ByteBuffer.wrap(string.getBytes());
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}
