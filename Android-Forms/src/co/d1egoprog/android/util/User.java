package co.d1egoprog.android.util;

/**
 * Clase que contiene informacion de un Ususario
 * 
 * @author Diego Alberto Rincon
 * @email diegoprog@hotmail.com
 * 22/06/2011
 */
public class User {
	
	/**
	 * Nombre de Usuario
	 */
	private String username;
	
	/**
	 * Password del Usuario
	 */
	private String password;
	
	/**
	 * Rol del Usuario
	 */
	private String role;

	/**
	 * 
	 */
	public User(String username, String password, String role) {
		this.username = username;
		this.password = password;
		this.role = role;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

}
