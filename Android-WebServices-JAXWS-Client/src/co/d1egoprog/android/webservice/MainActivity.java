package co.d1egoprog.android.webservice;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private static final String NAMESPACE = "http://server.webservice.d1egoprog.co/";
	private static String URL = "http://192.168.110.52:8089/WS/Calculadora?wsdl";
	private static final String METHOD_NAME = "sumar";
	private static final String SOAP_ACTION = "http://server.webservice.d1egoprog.co/sumar";
	private static String n1, n2;
	private static String res;
	private Button b;
	private TextView tv;
	private EditText et1;
	private EditText et2;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		tv = (TextView) findViewById(R.id.tv_result);
		b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				
					n1 = et1.getText().toString();
					n2 = et2.getText().toString();
					AsyncCallWS task = new AsyncCallWS();
					task.execute();
			}
		});
	}

	public void getSuma(String n1, String n2) {
		SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);
		request.addProperty("numero1", n1);
		request.addProperty("numero2", n2);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		envelope.dotNet = false;
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
		try {
			androidHttpTransport.call(SOAP_ACTION, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			res = response.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class AsyncCallWS extends AsyncTask<String, Void, Void> {
		@Override
		protected Void doInBackground(String... params) {
			getSuma(n1,n2);
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			tv.setText(res);
		}

		@Override
		protected void onPreExecute() {
			tv.setText("Calculating...");
		}

		@Override
		protected void onProgressUpdate(Void... values) {
		}

	}

}
