package servidor;

import java.rmi.RemoteException;

public class ClaseRemota implements InterfazRemota {

	public ClaseRemota() throws RemoteException {
	}

	public void miMetodo1() throws RemoteException {
		System.out.println("Estoy en miMetodo1()");
	}

	public int miMetodo2() throws RemoteException {
		return 5;
	}

	public void otroMetodo() {
	}

	public static void main(String[] args) {
		try {
			InterfazRemota mir = new ClaseRemota();
			java.rmi.Naming.rebind(
					"//" + java.net.InetAddress.getLocalHost().getHostAddress() + ":" + args[0] + "/PruebaRMI", mir);
		} catch (Exception e) {
		}
	}

}
