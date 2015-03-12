package net.syarihu.android.bitmaptestapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by syarihu on 15/03/10.
 */
public class MyCustomView extends View {
    private static final int BITMAP_COUNT = 5;
    Paint mPaint;
    ArrayList<BitmapInfo> mBitmaps;

    public MyCustomView(Context context) {
        super(context);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    /**
     * 初期化処理
     */
    private void init() {
        mPaint = new Paint();
        mBitmaps = new ArrayList<BitmapInfo>();
        // 描画するBitmapを取得
        Bitmap sourceBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        Matrix matrix = new Matrix();
        // 画像の拡大率をセット
        matrix.postScale(1.5f, 1.5f);
        for (int i = 0; i < BITMAP_COUNT; i++) {
            BitmapInfo info = new BitmapInfo();
            info.setBitmap(Bitmap.createBitmap(sourceBitmap, 0, 0, sourceBitmap.getWidth(), sourceBitmap.getHeight(), matrix, true));
            info.setPoint(new Point(i * 150, 20));
            info.setVisiblity(true);
            mBitmaps.add(info);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (BitmapInfo info : mBitmaps) {
            if (info.isVisiblity()) {
                canvas.drawBitmap(info.getBitmap(), info.getPoint().x, info.getPoint().y, mPaint);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 描画フラグがtrueなら
        for (BitmapInfo info : mBitmaps) {
            if (info.isVisiblity()) {
                // タッチされた時
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    // タッチされたX座標がBitmapのx座標より上で、BitmapのX座標＋Bitmapの横幅よりも小さく、
                    // タッチされたY座標がBitmapのY座標より上で、BitmapのY座標＋Bitmapの縦幅よりも小さかったら
                    if ((event.getX() > info.getPoint().x && event.getX() < info.getPoint().x + info.getBitmap().getWidth())
                            && (event.getY() > info.getPoint().y && event.getY() < info.getPoint().y + info.getBitmap().getHeight())) {
                        // TODO Bitmapがタッチされた時のイベントをここに書く
                        Log.v("test", "touch!!");
                        info.setVisiblity(false);
                        // 再描画
                        invalidate();
                    }
                }
            }
        }

        return super.onTouchEvent(event);
    }
}
