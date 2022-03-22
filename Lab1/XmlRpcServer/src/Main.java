import org.apache.xmlrpc.WebServer;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("server starts XML_RPC...");
            int port = 10015;
            WebServer server = new WebServer(port);

            server.addHandler("MyServer", new Main());
            server.start();

            System.out.println("Server listening on port " + port);
        } catch (Exception exception) {
            System.err.println("Serwer XML-RPC: " + exception);
        }
    }

    public int execAsy(int x) {
        System.out.println("... Aces were called - I'm counting down...");
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt();
        }
        System.out.println("... aces - end of the countdown");
        return 123;
    }

    public Integer echo(int x, int y) {
        return x + y;
    }
}
