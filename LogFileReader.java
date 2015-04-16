import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LogFileReader {

    public static List<LogFileRecord> readFile(String fileName, int numberOfLines, int amountOfRows) throws  IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        List<LogFileRecord> list = new ArrayList<LogFileRecord>();
        try {
            String line;
            int i = 0;

            while (((line = reader.readLine()) != null) && i <= numberOfLines + amountOfRows ) {
                if (i >= numberOfLines && i < numberOfLines + amountOfRows) {
                    list.add(LogLineParser.parseLine(line));
                }
                i++;
            }
        }
        catch (IOException e) {
            System.out.println("Input ERROR");
        }
        finally {
            reader.close();
            return list;
        }
    }
}