package co.d1egoprog.android.gps.listener;

import android.location.Criteria;
import android.view.View;
import android.view.View.OnClickListener;
import co.d1egoprog.android.gps.InitialActivity;

public class InitialCheckClickListener implements OnClickListener {

	private InitialActivity activity;

	public InitialCheckClickListener(InitialActivity initialActivity) {
		this.activity = initialActivity;
	}

	@Override
	public void onClick(View v) {
		if (activity.getFineAcc().isChecked()) {
			activity.getCriteria().setAccuracy(Criteria.ACCURACY_FINE);
		} else {
			activity.getCriteria().setAccuracy(Criteria.ACCURACY_COARSE);
		}
	}

}
