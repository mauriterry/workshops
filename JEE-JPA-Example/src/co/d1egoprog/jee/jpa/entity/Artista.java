package co.d1egoprog.jee.jpa.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Artista implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	
	private int anoNacimiento;

	public Artista(){
		this.nombre = "";
		this.anoNacimiento=0;
	}
	
	public Artista(String nombre, int anoNacimiento){ // constructor
		this.nombre = nombre;
		this.anoNacimiento=anoNacimiento;
	}

	public String getNombre(){
		return nombre;
	}

	public int getAnoNacimiento(){
		return anoNacimiento;
	}

	public void setNombre (String nombre){
		this.nombre=nombre;
	}

	public void setAnoNacimiento (int anoNacimiento){
		this.anoNacimiento = anoNacimiento;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

}