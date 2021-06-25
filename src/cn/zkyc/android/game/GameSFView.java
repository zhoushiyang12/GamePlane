package cn.zkyc.android.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Toast;

public class GameSFView extends SurfaceView implements Callback, Runnable {

	private SurfaceHolder surfaceHolder;
	private Random rand = new Random();
	private int x = 0, y = 0;
	private int oldX = x;
	private int oldY = y;
	// Canvas mcanvas;
	Canvas canvas;
	Paint paint = new Paint();
	List<Integer> listx = new ArrayList<Integer>();
	List<Integer> listy = new ArrayList<Integer>();
	Bitmap heroBitmap = BitmapFactory.decodeResource(getResources(),
			R.drawable.hero1);

	public GameSFView(Context context, AttributeSet attrs) {
		super(context, attrs);
		surfaceHolder = this.getHolder(); // 获取SurfaceHolder对象
		surfaceHolder.addCallback(this); // 添加回调
	}

	@Override
	public void run() {

		while (true) {

			int zx = x, zy = y;
			listx.add(new Integer(zx));
			listy.add(new Integer(zy));
			Canvas mcanvas = surfaceHolder.lockCanvas(); // 锁住Canvas

			for (int i = 0; i < listx.size(); i++) {
				zx = listx.get(i).intValue();
				zy = listy.get(i).intValue();

				paint.setColor(Color.BLACK);
				mcanvas.drawCircle(zx, zy, 10, paint);

				zy = zy - 50;
				listy.set(i, new Integer(zy));

				// paint.setColor(Color.BLACK);
				mcanvas.drawColor(Color.BLACK);
				paint.setColor(Color.BLUE);
				mcanvas.drawCircle(zx, zy, 10, paint);

				// mcanvas.drawRect(oldX,oldY,oldX+heroBitmap.getWidth(),
				// oldY+heroBitmap.getHeight(),paint);
				mcanvas.drawBitmap(heroBitmap, x, y, paint);
				oldX = x;
				oldY = y;

			}

			surfaceHolder.unlockCanvasAndPost(mcanvas); // 解锁Canvas，更新
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/**
	 * 自定义绘制方法
	 */
	public void drawH() {

	}

	public void draw() {

	}

	public boolean onTouchEvent(MotionEvent event) {

		// 清理背景,游戏中将换成具体的背景贴图
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			/*
			 * mcanvas = surfaceHolder.lockCanvas(); // 锁住Canvas
			 * paint.setColor(Color.BLACK); mcanvas.drawColor(Color.BLACK);
			 */
			x = (int) event.getX();
			y = (int) event.getY();

			// canvas.drawBitmap(heroBitmap, x, y, paint);

			// surfaceHolder.unlockCanvasAndPost(canvas); // 解锁Canvas，更新
		}

		return true;

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2,
			int arg3) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		// Surface创建成功启动线程
		// this.setBackgroundResource(R.drawable.background);
		new Thread(this).start();

		// 加载资源图片图片

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

}
