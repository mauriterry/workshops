package co.d1egoprog.android.accelerometer;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import co.d1egoprog.android.accelerometer.listener.AccelerometerEventListener;

public class InitialActivity extends Activity {
	
	private SensorManager senSensorManager;
	private Sensor senAccelerometer;
	private AccelerometerEventListener accelerometerEventListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		setContentView(R.layout.initial);
		
		accelerometerEventListener = new AccelerometerEventListener(this);
		senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	    senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	    senSensorManager.registerListener(accelerometerEventListener, senAccelerometer , SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	protected void onPause() {
	    super.onPause();
	    senSensorManager.unregisterListener(accelerometerEventListener);
	}
	
	protected void onResume() {
	    super.onResume();
	    senSensorManager.registerListener(accelerometerEventListener, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
	}
}
