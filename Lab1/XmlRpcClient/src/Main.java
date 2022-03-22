import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        try {
            XmlRpcClient srv = new XmlRpcClient("http://156.17.235.81:10015");
            Vector<Integer> params = new Vector<>();
            params.addElement(13);
            params.addElement(21);
            Object result = srv.execute("MyServer.echo", params);

            int wynik = (Integer) result;
            System.out.println("Wynik: " + wynik);

            AC cb = new AC();
            Vector<Integer> params2 = new Vector<>();
            params2.addElement(3000);
            srv.executeAsync("MyServer.execAsy", params2, cb);
            System.out.println("Call asynchronously");
        } catch (Exception exception) {
            System.err.println("Client XML-RPC: " + exception);
        }
    }
}
