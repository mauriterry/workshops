package cliente;

public class ClienteRMI {

	public static void main(String[] args) {
		try {
			InterfazRemota mir = (InterfazRemota) java.rmi.Naming.lookup("//" + args[0] + ":" + args[1] + "/PruebaRMI");
			for (int i = 1; i <= mir.miMetodo2(); i++)
				mir.miMetodo1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
