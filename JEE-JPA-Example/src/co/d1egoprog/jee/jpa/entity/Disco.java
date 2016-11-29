package co.d1egoprog.jee.jpa.entity;

public class Disco extends Obra{
	private String discografia;
	private int nCanciones;
	
	public Disco(String titulo,Artista autor, int anoEdicion,String discografia, int nCanciones){
		super(titulo,autor,anoEdicion);
		this.discografia = discografia;
		this.nCanciones = nCanciones;
	}
	public Disco(){
		super();
		this.discografia = "";
		this.nCanciones = 0;
	}
	
	public String getDiscografia(){
		return discografia;
	}	
	public void setDiscografia(String discografia){
		this.discografia = discografia;
	}
	public int getNCanciones(){
		return nCanciones;
	}
	public void setNCanciones(int nCanciones){
		this.nCanciones=nCanciones;
	}
		
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append(super.toString());
		sb.append("Disco grafia: ").append(this.discografia).append("\n");
		sb.append("Numero de canciones: ").append(this.nCanciones).append("\n");
		return sb.toString();
	}
}