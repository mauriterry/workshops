import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hilo extends Thread{
	
	private int id;
	private long matriz[][];
	private List<long[][]> lista;
	
	public Hilo(int id) {
		this.id = id;
		Random rn = new Random();
		lista = new ArrayList<long[][]>();
		System.out.println("Iniciando la Matriz");
		matriz = new long[1920][1080];
		for(int i=0;i<1920;i++){
			for(int j=0;j<1080;j++){
				matriz[i][j]=rn.nextLong();
			}
		}
	}
	
	public void run(){
		System.out.println("Hilo "+id + " Activado!");
		try{
			for(;;){
				long copia[][];
				copia = matriz;
				lista.add(copia);
			}
		}catch(Exception e){
			System.out.println("Hilo "+id + " Fallo en Algo");
		}
		System.out.println("Hilo "+id + " Finalizado!");
	}
}
