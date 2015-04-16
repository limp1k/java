import java.util.Date;


class LogFileRecord {
    String host;
    Date timestamp;
    String method; //enum
    String path;
    String protocol; //enum
    String reply;
    String bytes;
}
