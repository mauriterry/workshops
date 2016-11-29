package co.d1egoprog.jee.jpa.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "O" )
public class Libro extends Obra{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String editorial;
	private int nPaginas;

	public Libro(){
		super();
		this.editorial = "";
		this.nPaginas = 0;
	}
	
	public Libro(String titulo, Artista autor, int anoEdicion, String editorial, int nPaginas){
		super(titulo, autor, anoEdicion);
		this.editorial = editorial;
		this.nPaginas = nPaginas;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("Editoral: ").append(this.editorial).append("\n");
		sb.append("Numero de Paginas: ").append(this.nPaginas).append("\n");
		return sb.toString();
	}
	
	public void setEditorial(String editorial){
		this.editorial = editorial;
	}
	
	public void setNPaginas(int nPaginas){
		this.nPaginas = nPaginas;
	}
	
	public String getEditorial(){
		return this.editorial;
	}
	
	public int getNPaginas(){
		return this.nPaginas;
	}


}