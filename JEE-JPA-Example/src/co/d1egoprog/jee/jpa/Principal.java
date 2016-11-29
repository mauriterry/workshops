package co.d1egoprog.jee.jpa;

import java.util.ArrayList;
import java.util.List;

import co.d1egoprog.jee.jpa.entity.Artista;
import co.d1egoprog.jee.jpa.entity.Disco;
import co.d1egoprog.jee.jpa.entity.Libro;
import co.d1egoprog.jee.jpa.entity.Obra;
import co.d1egoprog.jee.jpa.entity.Pelicula;

public class Principal {

	public static void main(String args[]) throws Exception{
		Obra o1 = new Obra("Dvina Comedia", new Artista("Dante", 1900), 2000);
		Obra o2 = new Obra("Dvina Comedia", new Artista("Otro Dante", 1900), 2000);
		/*
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.println ("Digite los datos de su Obra Nueva");
		System.out.println ("Nombre de Obra, Nombre Artista, Nacimiento, Fecha Edicion");
		String nuevaObra = br.readLine();
		String datos[] = nuevaObra.split(",");
		Obra o3 = new Libro(datos[0], new Artista(datos[1], Integer.parseInt(datos[2])), Integer.parseInt(datos[3]));*/		
		Obra o3 = new Libro("Cien", new Artista("Gabruiel",1800),1990, "la mia", 2);

		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);
		
		Obra o4 = new Disco("Los tigres del Norte", new Artista("Pedro",1900), 2000, "Mialbum",  5);
		System.out.println(o4);
		
		
		List<Artista> artistas = new ArrayList<Artista>();
		artistas.add(new Artista("Pedro Perez",1900));
		artistas.add(new Artista("Pedro Schawneger",1800));
		artistas.add(new Artista("Pedro Ramirez",5900));
		artistas.add(new Artista("Pedro Algo",1300));
		artistas.add(new Artista("Pedro Coso",1300));
		
		o4 = new Pelicula("Mi Pelicula", new Artista("DIrector",1900), 2012, "La de las Peliculas", artistas);
		System.out.println(o4);
		
		
	}
	
	public static void imprimeTipo(Obra obra){
		if (obra instanceof Pelicula){
			System.out.println("---- Datos del Pelicula ----\n");
		}else if (obra instanceof Disco){
			System.out.println("---- Datos del Disco ----\n");
		}else if (obra instanceof Libro){
			System.out.println("---- Datos del Libro ----\n");
		}else if (obra instanceof Obra){
			System.out.println("---- Datos del Obra ----\n");
		}
		System.out.println(obra);
	}

}