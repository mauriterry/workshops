package co.d1egoprog.android.gps.listener;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.Toast;
import co.d1egoprog.android.gps.InitialActivity;
import co.d1egoprog.util.Utilities;

public class InitialLocationListener implements LocationListener {

	private InitialActivity activity;

	public InitialLocationListener(InitialActivity initialActivity) {
		this.activity = initialActivity;
	}

	@Override
	public void onLocationChanged(Location location) {
		// Initialize the location fields
		activity.getLatitude().setText("Latitud: " + String.valueOf(location.getLatitude()));
		activity.getLongitude().setText("Longitud: " + String.valueOf(location.getLongitude()));
		activity.getProvText().setText(activity.getProvider() + " Proveedor Selecionado.");

		Toast.makeText(activity, "Localización Cambiada!", Toast.LENGTH_SHORT).show();
		
		if ((location.getLatitude() >= 4.6219677)&&(location.getLatitude() <= 4.622137)&& //4.622070
				(Math.abs(location.getLongitude()) >= Math.abs(-74.0747))&& (Math.abs(location.getLongitude()) <= Math.abs(-74.0752702))){ //-74.074733
			Utilities.messageBox(activity, "Llego al Sector, Felicidades!!, Tome un pantallazo y reclame su premio  Codigo: Alpha!!");
		}
		if ((location.getLatitude() >= 4.62126)&&(location.getLatitude() <= 4.62140)&& //4.62130
				(Math.abs(location.getLongitude()) >= Math.abs(-74.074))&& (Math.abs(location.getLongitude()) <= Math.abs(-74.07555))){ //-74.0749
			Utilities.messageBox(activity, "Llego al Sector, Felicidades!!, Tome un pantallazo y reclame su premio Codigo: Zulu!! ");
		}
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		Toast.makeText(activity, provider + "'s cambio su estado a " + status + "!", Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onProviderEnabled(String provider) {
		Toast.makeText(activity, "Proveedor " + provider + " habilitado!", Toast.LENGTH_SHORT).show();

	}

	@Override
	public void onProviderDisabled(String provider) {
		Toast.makeText(activity, "Proveedor " + provider + " deshabilitado!", Toast.LENGTH_SHORT).show();
	}

}
