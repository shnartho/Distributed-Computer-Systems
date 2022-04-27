import org.apache.xmlrpc.WebServer;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args){
        System.out.println(MyService.compute(101,202));
        MyData.info();
        try {
            System.out.println("Starting XML-RPC server...");
            int port = 10013;
            WebServer server = new WebServer(port);
            //Bellow server object with name MyService is created and run:
            server.addHandler("MyService", new MyService());
            server.start();
            System.out.println("Server started successfully.");
            System.out.println("Listening on port: " + port);
            System.out.println("Press <ENTER> to stop the server.");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            server.shutdown();

        } catch (Exception exception) {
            System.err.println("XML-RPC Server: " + exception);
        }
    }
}
