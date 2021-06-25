package cn.zkyc.android.game;

import android.app.Activity;
import android.os.Bundle;

import android.view.Window;
import android.view.WindowManager;

public class start extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);

		// »ñÈ¡ÆÁÄ»¿í¸ß
		// Display display = getWindowManager().getDefaultDisplay();

		Sfview sf = new Sfview(this, null);
		sf = (Sfview) findViewById(R.id.sfview1);
		// sf.displays(100,300);
		setContentView(R.layout.start);

	}

}
