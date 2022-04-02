import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.apache.xmlrpc.client.XmlRpcClientException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collections;

public class Client {
    public static void main(String[] args) throws XmlRpcException, MalformedURLException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://192.168.0.161:8741"));

        XmlRpcClient rc = new XmlRpcClient();
        rc.setConfig(config);

        String res = (String) rc.execute("shnartho.echo", Collections.singletonList("A simple XML-RPC Client Server Application"));
        System.out.println(res);

    }
}
