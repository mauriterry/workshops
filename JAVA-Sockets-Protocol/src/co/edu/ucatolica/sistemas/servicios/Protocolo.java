package co.edu.ucatolica.sistemas.servicios;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Protocolo {

	final int PUERTO=5000;
	ServerSocket sc;
	Socket so;
	DataOutputStream salida;
	String mensajeRecibido;
	public Protocolo(){
		BufferedReader entrada;
		try{
			sc = new ServerSocket(PUERTO );
			so=new Socket();
			System.out.println("Esperando una conexión:");
			so = sc.accept();
			System.out.println("Un cliente se ha conectado.");
			entrada = new BufferedReader(new InputStreamReader(so.getInputStream()));
			salida = new DataOutputStream(so.getOutputStream());
			System.out.println("Confirmando conexion al cliente....");
			salida.writeUTF("Se ha conectado al Servidor XXXXX \n");
			mensajeRecibido = entrada.readLine();
			System.out.println(mensajeRecibido);
			salida.writeUTF("\n Se recibio tu mensaje cerrando conexion...");
			System.out.println("Cerrando conexión...");
			sc.close();
		}catch(Exception e ){
			System.out.println("Error: "+e.getMessage());
		}
	}
	public static void main(String[] args) {
		Protocolo protocolo = new Protocolo(); 
	}
	
}
