
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyData {

    static void info() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        System.out.println("Md Shahadat Hossen Nayem 268921");
        String windowsUser = System.getProperty("user.name");
        System.out.println(windowsUser);
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("java.runtime.version"));

        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("IP address : " + ip);

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }
    }
}