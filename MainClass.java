import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainClass {
    public static void main(String[] args) throws IOException {
        try {
            if ((Integer.parseInt(args[1]) > 0) && (Integer.parseInt(args[2]) > 0)){
                String fileName = args[0];
                int numberOfLines = Integer.parseInt(args[1]);
                int amountOfRows = Integer.parseInt(args[2]);

                List<LogFileRecord> list = new ArrayList<LogFileRecord>(LogFileReader.readFile(fileName, numberOfLines, amountOfRows));
                List<String> files = new ArrayList<String>();

                for (LogFileRecord note: list) {

                    String str = "Host: " + note.host + ", TimeStamp: " + note.timestamp + ", Method: " + note.method + ", Way: " + note.path + ", Protocol: " + note.protocol + ", Reply: " + note.reply + ", Bytes: " + note.bytes;
                    files.add(str);
                    System.out.println(str);
                }

                System.out.println();
            }
        }
        catch (IOException e) {
            System.out.println("Input ERROR");
        }
    }
}
