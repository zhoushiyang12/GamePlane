package cn.zkyc.android.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public class Sfview extends SurfaceView implements Callback, Runnable {

	private SurfaceHolder surfaceHolder;
	private Random rand = new Random();
	private int x = 400, y = 400;
	private int w = 600, h = 1000;
	private int dX = 0;
	private int dY = 0;
	private int score = 0;
	private int die = 0;
	private int duringLunch = 0;
	private int duringLunch_f = 0;
	private boolean running = true;

	Matrix m = new Matrix();
	int width;
	int height;
	Bitmap bitmap;

	// Canvas mcanvas;
	// Canvas canvas ;
	Paint paint = new Paint();
	List<Integer> listx = new ArrayList<Integer>();
	List<Integer> listy = new ArrayList<Integer>();
	List<Integer> listfx = new ArrayList<Integer>();
	List<Integer> listfy = new ArrayList<Integer>();
	Bitmap heroBitmap = BitmapFactory.decodeResource(getResources(),
			R.drawable.hero1);
	Bitmap background = BitmapFactory.decodeResource(getResources(),
			R.drawable.background);

	public Sfview(Context context, AttributeSet attrs) {
		super(context, attrs);
		surfaceHolder = this.getHolder(); // 获取SurfaceHolder对象
		surfaceHolder.addCallback(this); // 添加回调
	}

	public void explsion() {

	}

	public void displays(int x, int y) {
		w = x;
		h = y;
	}

	public void pengzhuang(Bitmap b) {
		int zx, zy, fx, fy;

		for (int i = (listx.size() - 1); i >= 0; i--) {
			zx = listx.get(i).intValue();
			zy = listy.get(i).intValue();
			for (int j = (listfx.size() - 1); j >= 0; j--) {
				fx = listfx.get(j).intValue();
				fy = listfy.get(j).intValue();
				if ((zx > fx && zx < (fx + b.getWidth())
						&& zy > fy + b.getHeight() / 3 && zy < fy + 2
						* b.getHeight() / 3)
						|| (zx > fx + 3 * b.getWidth() / 8 && zx < fx + 5
								* b.getWidth() / 8)
						&& zy > fy
						&& zy < fy + 2 * b.getHeight() / 3) {
					explsion();
					listfx.remove(j);
					listfy.remove(j);
					listx.remove(i);
					listy.remove(i);
					score++;
					break;

				}

			}
		}
	}

	public void herodie(Bitmap b) {
		int fx, fy;
		int fxy, fyy;
		int fxq, fyq;

		for (int j = (listfx.size() - 1); j >= 0; j--) {
			fx = listfx.get(j).intValue();
			fyy = fy = listfy.get(j).intValue() + b.getHeight() / 4;
			fxy = fx + b.getWidth();
			fxq = fx + b.getWidth() / 2;
			fyq = fy + 3 * b.getHeight() / 5;
			if ((fx > x - heroBitmap.getWidth() / 4
					&& fx < x + heroBitmap.getWidth() / 4
					&& fy > y - heroBitmap.getHeight() / 4 && fy < y
					+ heroBitmap.getHeight() / 2)
					|| (fx > x - heroBitmap.getWidth() / 2
							&& fx < x + heroBitmap.getWidth() / 2
							&& fy > y + heroBitmap.getHeight() / 4 && fy < y
							+ 3 * heroBitmap.getHeight() / 4)) {
				explsion();
				listfx.remove(j);
				listfy.remove(j);
				running = false;
				die++;
				break;

			}
			if ((fxy > x - heroBitmap.getWidth() / 4
					&& fxy < x + heroBitmap.getWidth() / 4
					&& fyy > y - heroBitmap.getHeight() / 4 && fyy < y
					+ heroBitmap.getHeight() / 2)
					|| (fxy > x - heroBitmap.getWidth() / 2
							&& fxy < x + heroBitmap.getWidth() / 2
							&& fyy > y + heroBitmap.getHeight() / 4 && fyy < y
							+ 3 * heroBitmap.getHeight() / 4)) {
				explsion();
				listfx.remove(j);
				listfy.remove(j);
				running = false;
				die++;
				break;

			}
			if ((fxq > x - heroBitmap.getWidth() / 4
					&& fxq < x + heroBitmap.getWidth() / 4
					&& fyq > y - heroBitmap.getHeight() / 4 && fyq < y
					+ heroBitmap.getHeight() / 2)
					|| (fxq > x - heroBitmap.getWidth() / 2
							&& fxq < x + heroBitmap.getWidth() / 2
							&& fyq > y + heroBitmap.getHeight() / 4 && fyq < y
							+ 3 * heroBitmap.getHeight() / 4)) {
				explsion();
				listfx.remove(j);
				listfy.remove(j);
				running = false;
				die++;
				break;

			}
		}

	}

	@Override
	public void run() {
		BitmapDrawable drawable = (BitmapDrawable) getResources().getDrawable(
				R.drawable.hero1);
		bitmap = drawable.getBitmap();
		width = bitmap.getWidth();
		height = bitmap.getHeight();

		m.setScale(200 / width, 200 / height);
		m.setRotate(180);

		Bitmap dispBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, m,
				false);
		dispBitmap = Bitmap.createScaledBitmap(dispBitmap, width / 2,
				height / 2, false);

		background = Bitmap.createScaledBitmap(background, w, h, false);

		while (true) {
			while (running) {

				// y+=30;
				int zx = x, zy = y - heroBitmap.getHeight() / 4;
				if (duringLunch == 0) {
					listx.add(new Integer(zx));
					listy.add(new Integer(zy));
					duringLunch = 10;
				}
				if (duringLunch_f == 0) {
					dX = rand.nextInt(this.getWidth()) - dispBitmap.getWidth()
							/ 2;
					dY = 0;

					listfx.add(new Integer(dX));
					listfy.add(new Integer(dY));
					duringLunch_f = rand.nextInt(10) + 5;
				}
				Canvas mcanvas = surfaceHolder.lockCanvas(); // 锁住Canvas
				mcanvas.drawBitmap(background, 0, 0, null);
				for (int i = (listx.size() - 1); i >= 0; i--) {
					zx = listx.get(i).intValue();
					zy = listy.get(i).intValue();
					if (zy <= 10) {
						listx.remove(i);
						listy.remove(i);
					} else {
						zy = zy - 15;
						listy.set(i, new Integer(zy));
						paint.setColor(Color.BLUE);
						paint.setStrokeWidth(5);
						paint.setAntiAlias(true);
						mcanvas.drawLine(zx, zy, zx, zy + 15, paint);
						mcanvas.drawLine(zx, zy, zx, zy + 15, paint);
					}

				}
				for (int i = (listfx.size() - 1); i >= 0; i--) {
					dX = listfx.get(i).intValue();
					dY = listfy.get(i).intValue();
					if (dY >= this.getHeight()) {
						listfx.remove(i);
						listfy.remove(i);
					} else {
						dY = dY + 8;
						listfy.set(i, new Integer(dY));
						mcanvas.drawBitmap(dispBitmap, dX, dY, null);
					}

				}
				mcanvas.drawBitmap(heroBitmap, x - heroBitmap.getWidth() / 2, y
						- heroBitmap.getHeight() / 4, null);
				paint.setTextSize(20);
				paint.setColor(Color.BLACK);
				mcanvas.drawText("您击毁了: " + score + "架敌机！", 10, 20, paint);
				mcanvas.drawText("您被击毁了: " + die + "次！", 10, 50, paint);
				surfaceHolder.unlockCanvasAndPost(mcanvas); // 解锁Canvas，更新
				duringLunch--;
				duringLunch_f--;
				pengzhuang(dispBitmap);
				herodie(dispBitmap);
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public boolean onTouchEvent(MotionEvent event) {
		// if (event.getAction() == MotionEvent.ACTION_DOWN) {
		x = (int) event.getX();
		y = (int) event.getY();
		// Thread.currentThread().resume();
		running = true;
		// }

		return true;

	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int arg1, int arg2,
			int arg3) {

	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		new Thread(this).start();

	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {

	}

}
