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
		/* 监听button的事件信息 */
		button.setOnClickListener(new Button.OnClickListener() {
			// String name;

						public void onClick(View v) {
							/* 新建一个Intent对象 */
							Intent intent = new Intent();
							/* 指定intent要启动的类 */
							intent.setClass(zhizuoren.this, start.class);
							/* 启动一个新的Activity */
							startActivity(intent);
							/* 关闭当前的Activity */
							zhizuoren.this.finish();
						}
					});
		

	}

}
