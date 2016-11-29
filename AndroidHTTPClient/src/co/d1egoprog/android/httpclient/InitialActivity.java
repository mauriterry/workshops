package co.d1egoprog.android.httpclient;

import java.util.Random;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import co.d1egoprog.android.httpclient.listeners.InitialButtonListener;

public class InitialActivity extends Activity {

	private EditText editText;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);

		Random rn = new Random();
		int answer = rn.nextInt(100) + 1;

		setEditText((EditText) this.findViewById(R.id.editText1));
		getEditText().setText(answer + ";diego;rincon;" + answer + ";a@a.com");

		setButton((Button) this.findViewById(R.id.button1));
		getButton().setOnClickListener(new InitialButtonListener());
	}

	/**
	 * @return the editText
	 */
	public EditText getEditText() {
		return editText;
	}

	/**
	 * @param editText
	 *            the editText to set
	 */
	public void setEditText(EditText editText) {
		this.editText = editText;
	}

	/**
	 * @return the button
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * @param button
	 *            the button to set
	 */
	public void setButton(Button button) {
		this.button = button;
	}
}
