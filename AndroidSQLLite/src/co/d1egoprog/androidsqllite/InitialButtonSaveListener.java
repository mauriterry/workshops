package co.d1egoprog.androidsqllite;

import android.view.View;
import android.view.View.OnClickListener;

public class InitialButtonSaveListener implements OnClickListener {
	
	private InitialActivity activity;

	public InitialButtonSaveListener(InitialActivity activity) {
		this.activity = activity;
	}

	@Override
	public void onClick(View v) {
		Integer id = Integer.parseInt(activity.getCedula().getText().toString());
		String name = activity.getNombre().getText().toString();
		
		activity.getsQLiteIntermediate().insertDataPeople(id, name);
	}

}
