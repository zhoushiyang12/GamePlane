package cn.zkyc.android.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class zhizuoren extends Activity{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		
		setContentView(R.layout.zhizuoren);
		
		Button button = (Button) findViewById(R.id.imageButton1);
		/* ����button���¼���Ϣ */
		button.setOnClickListener(new Button.OnClickListener() {
			// String name;

						public void onClick(View v) {
							/* �½�һ��Intent���� */
							Intent intent = new Intent();
							/* ָ��intentҪ�������� */
							intent.setClass(zhizuoren.this, start.class);
							/* ����һ���µ�Activity */
							startActivity(intent);
							/* �رյ�ǰ��Activity */
							zhizuoren.this.finish();
						}
					});
		

	}

}
