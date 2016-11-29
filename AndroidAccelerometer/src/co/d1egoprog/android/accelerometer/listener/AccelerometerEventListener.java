package co.d1egoprog.android.accelerometer.listener;

import java.text.DecimalFormat;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.TextView;
import android.widget.Toast;
import co.d1egoprog.android.accelerometer.InitialActivity;
import co.d1egoprog.android.accelerometer.R;

public class AccelerometerEventListener implements SensorEventListener {

	private InitialActivity activity;
	private TextView ejeX;
	private TextView ejeY;
	private TextView ejeZ;

	private float mAccel;
	private float mAccelCurrent;
	private float mAccelLast;

	public AccelerometerEventListener(InitialActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		Sensor mySensor = event.sensor;

		float x = 0;
		float y = 0;
		float z = 0;

		if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
			x = event.values[0];
			y = event.values[1];
			z = event.values[2];
		}

		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		
		ejeX = (TextView) activity.findViewById(R.id.textView5);
		ejeX.setText(df.format(x));

		ejeY = (TextView) activity.findViewById(R.id.textView6);
		ejeY.setText(df.format(y));

		ejeZ = (TextView) activity.findViewById(R.id.textView7);
		ejeZ.setText(df.format(z));

		mAccelCurrent = (float) Math.sqrt((double) (x * x + y * y + z * z));
		float delta = mAccelCurrent - mAccelLast;
		mAccel = mAccel * 0.9f + delta;
		
		if (mAccel > 12) {
		    Toast toast = Toast.makeText(activity, "Agitandose", Toast.LENGTH_LONG);
		    toast.show();
		}

	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {

	}

}
