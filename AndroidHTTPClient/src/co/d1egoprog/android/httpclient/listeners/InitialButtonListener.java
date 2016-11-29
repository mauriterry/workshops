package co.d1egoprog.android.httpclient.listeners;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import co.d1egoprog.android.httpclient.R;
import co.d1egoprog.android.util.Utilities;

public class InitialButtonListener implements OnClickListener, Runnable {

	private EditText editText;
	private String confirmation = "";
	private ProgressDialog pd;
	public static final String WEB = "http://www.itpp.co/ucc/agregar.php";

	public InitialButtonListener() {
	}

	@Override
	public void onClick(View v) {
		editText = (EditText) v.getRootView().findViewById(R.id.editText1);
		
		Thread thread = new Thread(this);
		thread.start();
		pd = ProgressDialog.show(v.getContext(), "Conectando", "Guardando los datos ", true, false);
		
		if (confirmation.equals("true")){
			Utilities.messageBox(v.getContext(), "Datos Guardados Exitosamente");
		}else{
			Utilities.messageBox(v.getContext(), "Error: " + confirmation);
		}
		
	}

	@Override
	public void run() {
		confirmation=getServerData(WEB);
		handler.sendEmptyMessage(0);
	}
	

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			pd.dismiss();
		}
	};
	
	
    private String getServerData(String returnString) {
        
        InputStream is = null;
        
        String result = "";
         //the year data to send
         ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
         
     	String datos[] = editText.getText().toString().split(";");
         
         nameValuePairs.add(new BasicNameValuePair("cedula",datos[0]));
         nameValuePairs.add(new BasicNameValuePair("nombre",datos[1]));
         nameValuePairs.add(new BasicNameValuePair("apellido",datos[2]));
         nameValuePairs.add(new BasicNameValuePair("telefono",datos[3]));
         nameValuePairs.add(new BasicNameValuePair("correo",datos[4]));
         
         //http post
         try{
                 HttpClient httpclient = new DefaultHttpClient();
                 HttpPost httppost = new HttpPost(WEB);
                 httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
                 HttpResponse response = httpclient.execute(httppost);
                 HttpEntity entity = response.getEntity();
                 is = entity.getContent();

         }catch(Exception e){
                 return "Conexion con " + WEB;
         }

         try{
                 BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
                 StringBuilder sb = new StringBuilder();
                 String line = null;
                 while ((line = reader.readLine()) != null) {
                         sb.append(line + "\n");
                 }
                 is.close();
                 result=sb.toString();
         }catch(Exception e){
         	return "Convirtiendo Resultado ";
         }

         return result;
     }   

}
