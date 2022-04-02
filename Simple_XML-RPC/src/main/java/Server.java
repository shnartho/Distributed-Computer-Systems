import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.server.PropertyHandlerMapping;
import org.apache.xmlrpc.webserver.WebServer;

import java.io.IOException;


public class Server {
    public static void main(String[] args) throws XmlRpcException, IOException {
        WebServer ws = new WebServer(8741);

        PropertyHandlerMapping mapping = new PropertyHandlerMapping();
        mapping.addHandler("shnartho", Server.class);

        ws.getXmlRpcServer().setHandlerMapping(mapping);
        ws.start();
    }

    public String echo(String s){
        System.out.println(s);
        return "Shnartho Server Respond: " + s;
    }
}
