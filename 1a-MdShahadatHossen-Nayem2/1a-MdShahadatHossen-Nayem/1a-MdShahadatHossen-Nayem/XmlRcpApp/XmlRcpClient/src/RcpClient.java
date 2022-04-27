import org.apache.xmlrpc.XmlRpcClient;

import java.util.Vector;

public class RcpClient {

    public static void main(String[] args){
        MyData.info();
        try {
        XmlRpcClient srv = new XmlRpcClient("http://localhost:10013");
        Vector<Integer> params = new Vector<Integer>();
        params.addElement(2002);
        params.addElement(3003);
        Object result = srv.execute("MyService.compute", params);
        System.out.println("result = " + result);

            AC cb = new AC();
            Vector<Integer> params2 = new Vector<Integer>();
            params2.addElement(10013);
            srv.executeAsync("MyService.asyProc", params2, cb);
            System.out.println("Called asynchronously");

    } catch (Exception exception) {
        System.err.println("XML-RPC Client: " + exception);

    }
}
}