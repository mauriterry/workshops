package co.d1egoprog.androidsqllite;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class InitialActivity extends Activity {
	
	private EditText nombre;
	private EditText cedula;
	private Button guardar;
	
	private SQLiteIntermediate sQLiteIntermediate;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);
		
		sQLiteIntermediate = new SQLiteIntermediate(this);
		
		setNombre((EditText)this.findViewById(R.id.editText1));
		setCedula((EditText)this.findViewById(R.id.editText2));
		setGuardar((Button)this.findViewById(R.id.button1));
		getGuardar().setOnClickListener(new InitialButtonSaveListener(this));
	}


	/**
	 * @return the nombre
	 */
	public EditText getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(EditText nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the cedula
	 */
	public EditText getCedula() {
		return cedula;
	}


	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(EditText cedula) {
		this.cedula = cedula;
	}


	/**
	 * @return the guardar
	 */
	public Button getGuardar() {
		return guardar;
	}


	/**
	 * @param guardar the guardar to set
	 */
	public void setGuardar(Button guardar) {
		this.guardar = guardar;
	}


	/**
	 * @return the sQLiteIntermediate
	 */
	public SQLiteIntermediate getsQLiteIntermediate() {
		return sQLiteIntermediate;
	}


	/**
	 * @param sQLiteIntermediate the sQLiteIntermediate to set
	 */
	public void setsQLiteIntermediate(SQLiteIntermediate sQLiteIntermediate) {
		this.sQLiteIntermediate = sQLiteIntermediate;
	}
}
