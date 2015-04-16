import java.io.IOException;
import java.lang.String;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class LogLineParser {

    public static LogFileRecord parseLine(String line) throws IOException, ParseException {
        LogFileRecord note = new LogFileRecord();

        String[] buffer1 = line.split(" - - ");
        note.host = buffer1[0];

        String[] buffer2 = buffer1[1].split(" \"");

        SimpleDateFormat format = new SimpleDateFormat("[dd/MMM/y:HH:mm:ss Z]",Locale.US);
        note.timestamp = format.parse(buffer2[0]);

        String[] buffer3 = buffer2[1].split("\" ");
        String[] buffer4 = buffer3[0].split(" ");
        note.method = buffer4[0];
        note.path = buffer4[1];
        note.protocol = buffer4[2];

        String[] buffer5 = buffer3[1].split(" ");
        note.reply = buffer5[0];
        note.bytes = buffer5[1];

        return note;
    }
}
