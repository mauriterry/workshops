package co.d1egoprog.jee.jpa.entity;

import java.util.*;

public class Pelicula extends Obra{

private String productora;
private List<Artista> interpretes;

	public Pelicula(){
		super();
		this.productora="";
		this.interpretes= new ArrayList<Artista>();
	}

	public Pelicula(String titulo, Artista autor, int anoEdicion, String productora, List<Artista> interpretes){
		super(titulo,autor,anoEdicion);
		this.productora=productora;
		this.interpretes=interpretes;
	}
		
	public String getProductora(){
			return productora;
	}
		
	public void setProductora(String productora){
		this.productora=productora;
	}
		
	public List<Artista> getInterpretes(){
		return interpretes;
	} 
		
	public void setInterpretes(List<Artista> interpretes){
		this.interpretes=interpretes;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("Productora: ").append(this.productora).append("\n");
		int i=1;
		for(Artista artista:this.interpretes){
			sb.append("Artista No: ").append(i).append(": ")
			.append(artista.getNombre()).append("\n");
			i++;
		}
		return sb.toString();
	}
	
}