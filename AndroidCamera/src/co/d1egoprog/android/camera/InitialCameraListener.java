package co.d1egoprog.android.camera;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class InitialCameraListener implements OnClickListener{
	
	private InitialActivity activity;

	public InitialCameraListener(InitialActivity activity) {
		this.activity = activity;
	}
	
	@Override
	public void onClick(View v) {
		Intent intent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		activity.startActivityForResult(intent, 0);
	}

}
