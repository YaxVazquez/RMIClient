


/**
 *
 * @author Emmanuel Oropeza
 */
import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiCommunicationClient {

    //Operational Classes

    private final Registry _registry;
    private final InterfaceRmiCommunication _interfaceRmiCommunication;
    private final int RMIPort = 123;

    //Constructors
    public RmiCommunicationClient() throws RemoteException, NotBoundException, IOException {
        System.setProperty("java.security.policy", "java.policy");
        System.setSecurityManager(new RMISecurityManager());
        this._registry = LocateRegistry.getRegistry(1234);
        this._interfaceRmiCommunication = (InterfaceRmiCommunication) _registry.lookup("rmiServer");
    }

    public Integer getSuma(int num1, int num2) throws RemoteException {
        return _interfaceRmiCommunication.getSuma(num1, num2);
    }
}
