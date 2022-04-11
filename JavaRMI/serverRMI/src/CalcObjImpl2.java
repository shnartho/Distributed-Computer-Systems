import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObjImpl2 extends UnicastRemoteObject implements CalcObject2 {
    public CalcObjImpl2() throws RemoteException {
        super();
    }

    @Override
    public ResultType calculate(InputType inputParam) throws RemoteException {
        double zm1, zm2;
        ResultType res = new ResultType();

        zm1 = inputParam.getX1();
        zm2 = inputParam.getX2();

        res.result_description = "Operation " + inputParam.operation;

        switch (inputParam.operation) {
            case "add":
                res.result = zm1 + zm2;
                break;
            case "sub":
                res.result = zm1 - zm2;
                break;
            default:
                res.result = 0;
                res.result_description = "An invalid operation was specified!";
                return res;
        }

        return res;
    }
}
