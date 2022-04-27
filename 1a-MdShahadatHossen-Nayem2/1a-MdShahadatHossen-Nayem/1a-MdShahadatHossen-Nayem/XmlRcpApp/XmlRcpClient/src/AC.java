import org.apache.xmlrpc.AsyncCallback;

import java.net.URL;


public class AC implements AsyncCallback {

    public void handleResult(Object result, URL url, String procName){
        System.out.println(result);

    }
    public void handleError(Exception e, URL url, String procName){
        System.out.println(e);
    }
}
