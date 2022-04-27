
import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class RcpClient {

    public static void main(String[] args){
        MyData.info();
        try {
            XmlRpcClient srv = new XmlRpcClient("http://127.0.0.1:10014");
            Vector<Integer> params = new Vector<Integer>();
            params.addElement(101);
            params.addElement(202);
            Object result = srv.execute("MyService.compute", params);
            System.out.println("result = " + result);

            AC cb = new AC();
            Vector<Integer> params2 = new Vector<Integer>();
            params2.addElement(8088);
            srv.executeAsync("MyService.asyProc", params2, cb);
            System.out.println("Called asynchronously");

        } catch (Exception exception) {
            System.err.println("XML-RPC Client: " + exception);

        }
    }
}