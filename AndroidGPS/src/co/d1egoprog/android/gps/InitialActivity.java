package co.d1egoprog.android.gps;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import co.d1egoprog.android.gps.listener.InitialCheckClickListener;
import co.d1egoprog.android.gps.listener.InitialLocationListener;

public class InitialActivity extends Activity {

	private TextView latitude;
	private TextView longitude;
	private CheckBox fineAcc;
	private Button choose;
	private TextView provText;
	private LocationManager locationManager;
	private String provider;
	private InitialLocationListener listener;
	private Criteria criteria;
	private boolean isGPSEnabled = false;
    private boolean isNetworkEnabled = false;
    
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 5; // 5 metros
    private static final long MIN_TIME_BW_UPDATES = 1000 * 1; // 1 segundo

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.initial);

		latitude = (TextView) findViewById(R.id.lat);
		longitude = (TextView) findViewById(R.id.lon);
		provText = (TextView) findViewById(R.id.prov);
		fineAcc = (CheckBox) findViewById(R.id.fineAccuracy);
		choose = (Button) findViewById(R.id.chooseRadio);
		
		/*isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
		isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		if (!isGPSEnabled && !isNetworkEnabled) {
			AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
			alertDialog.setTitle("Configuracion GPS");
			alertDialog.setMessage("Debe habilitar el GPS, desea ir al menu de configuracion?");
			alertDialog.setPositiveButton("Configuracion", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int which) {
					Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
					startActivity(intent);
				}
			});
			alertDialog.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					dialog.cancel();
				}
			});
			alertDialog.show();
			
		}*/

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_COARSE);

		choose.setOnClickListener(new InitialCheckClickListener(this));
		criteria.setCostAllowed(false);
		provider = locationManager.getBestProvider(criteria, false);

		Location location = locationManager.getLastKnownLocation(provider);

		listener = new InitialLocationListener(this);

		
		if (location != null) {
			listener.onLocationChanged(location);
		} else {
			Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
			startActivity(intent);
		}
		locationManager.requestLocationUpdates(provider, MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, listener);
		//locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, listener);
		//locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,MIN_TIME_BW_UPDATES,MIN_DISTANCE_CHANGE_FOR_UPDATES, listener);
		
	}

	/**
	 * @return the latitude
	 */
	public TextView getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(TextView latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public TextView getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(TextView longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the fineAcc
	 */
	public CheckBox getFineAcc() {
		return fineAcc;
	}

	/**
	 * @param fineAcc
	 *            the fineAcc to set
	 */
	public void setFineAcc(CheckBox fineAcc) {
		this.fineAcc = fineAcc;
	}

	/**
	 * @return the choose
	 */
	public Button getChoose() {
		return choose;
	}

	/**
	 * @param choose
	 *            the choose to set
	 */
	public void setChoose(Button choose) {
		this.choose = choose;
	}

	/**
	 * @return the provText
	 */
	public TextView getProvText() {
		return provText;
	}

	/**
	 * @param provText
	 *            the provText to set
	 */
	public void setProvText(TextView provText) {
		this.provText = provText;
	}

	/**
	 * @return the locationManager
	 */
	public LocationManager getLocationManager() {
		return locationManager;
	}

	/**
	 * @param locationManager
	 *            the locationManager to set
	 */
	public void setLocationManager(LocationManager locationManager) {
		this.locationManager = locationManager;
	}

	/**
	 * @return the provider
	 */
	public String getProvider() {
		return provider;
	}

	/**
	 * @param provider
	 *            the provider to set
	 */
	public void setProvider(String provider) {
		this.provider = provider;
	}

	/**
	 * @return the criteria
	 */
	public Criteria getCriteria() {
		return criteria;
	}

	/**
	 * @param criteria
	 *            the criteria to set
	 */
	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	/**
	 * @return the listener
	 */
	public InitialLocationListener getListener() {
		return listener;
	}

	/**
	 * @param listener the listener to set
	 */
	public void setListener(InitialLocationListener listener) {
		this.listener = listener;
	}
}
