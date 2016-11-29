import java.util.ArrayList;
import java.util.List;

public class Principal {
	
	private List<Hilo> hilos;
		
	public Principal(int cantidad) {
		hilos = new ArrayList<Hilo>();
		for (int i=0;i<cantidad;i++){
			Hilo hilo = new Hilo(i);
			hilo.start();
			hilos.add(hilo);
		}
	}
	
	public static void main(String[] args) {
		new Principal(8);
	}

}
