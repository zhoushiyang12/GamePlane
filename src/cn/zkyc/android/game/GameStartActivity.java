package cn.zkyc.android.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class GameStartActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
			requestWindowFeature(Window.FEATURE_NO_TITLE);
			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
		// Ĭ���Ǽ���XML�����ļ�����ʾ��Ҳ��XML�ļ��е���ͼ���
			setContentView(R.layout.main);

		// ������Ҫ��ʾ�Զ����View,ֻ��Ҫ��XML�ļ������Զ����View����Ϳ����ˣ����£�
		// GameView gameView = new GameView(this);
		// setContentView(gameView);
		// ȫ����ʾ����

		// ��ʾ�Զ������ϷView
		// mAnimView = new AnimView(this, display.getWidth(),
		// display.getHeight());
		// setContentView(mAnimView);

		Button button = (Button) findViewById(R.id.button1);
		/* ����button���¼���Ϣ */
		button.setOnClickListener(new Button.OnClickListener() {
			// String name;
			public void onClick(View v) {
				/* �½�һ��Intent���� */
				Intent intent = new Intent();
				/* ָ��intentҪ�������� */
				intent.setClass(GameStartActivity.this, start.class);
				/* ����һ���µ�Activity */
				startActivity(intent);
				/* �رյ�ǰ��Activity */
				GameStartActivity.this.finish();
			}
		});

	}
}