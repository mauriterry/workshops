package co.d1egoprog.jee.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Obra implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private String titulo;
	
	@ManyToOne
	private Artista autor; 
	private int anoEdicion;

	public Obra(){
		this.titulo = "";
		this.autor = new Artista();
		this.anoEdicion=0;
	}
	
	public Obra(String titulo, Artista autor, int anoEdicion){
		this.titulo = titulo;
		this.autor = autor;
		this.anoEdicion = anoEdicion;
	}
	
	public boolean equals(Obra obra){
		if (this.titulo.equals(obra.titulo)){
			return true;
		}else{
			return false;
		}
	}

	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Nombre de la Obra: ").append(this.titulo).append("\n");
		sb.append("Autor de la Obra: ").append(this.autor.getNombre()).append("\n");;
		sb.append("Nacimiento del Autor: ").append(this.autor.getAnoNacimiento()).append("\n");;
		sb.append("Fecha de Edicion").append(this.anoEdicion).append("\n");;
		return sb.toString();
	}
	
	public String getTitulo(){
		return titulo;
	}

	public Artista getAutor(){
		return autor;
	}

	public int getAnoEdicion(){
		return anoEdicion;
	}

	public void setTitulo(String titulo){
		this.titulo=titulo;
	}

	public void setAutor (Artista autor){
		this.autor=autor;
	}

	public void setAnoEdicion (int anoEdicion){
		this.anoEdicion = anoEdicion;
	}

}