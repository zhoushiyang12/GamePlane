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
		// 默认是加载XML配置文件，显示的也是XML文件中的视图组件
			setContentView(R.layout.main);

		// 我们需要显示自定义的View,只需要将XML文件换成自定义的View对象就可以了，如下：
		// GameView gameView = new GameView(this);
		// setContentView(gameView);
		// 全屏显示窗口

		// 显示自定义的游戏View
		// mAnimView = new AnimView(this, display.getWidth(),
		// display.getHeight());
		// setContentView(mAnimView);

		Button button = (Button) findViewById(R.id.button1);
		/* 监听button的事件信息 */
		button.setOnClickListener(new Button.OnClickListener() {
			// String name;
			public void onClick(View v) {
				/* 新建一个Intent对象 */
				Intent intent = new Intent();
				/* 指定intent要启动的类 */
				intent.setClass(GameStartActivity.this, start.class);
				/* 启动一个新的Activity */
				startActivity(intent);
				/* 关闭当前的Activity */
				GameStartActivity.this.finish();
			}
		});

	}
}