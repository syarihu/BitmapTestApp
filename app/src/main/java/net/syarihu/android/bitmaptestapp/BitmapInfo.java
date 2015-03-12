package net.syarihu.android.bitmaptestapp;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by syarihu on 15/03/12.
 */
public class BitmapInfo {
    Bitmap mBitmap;
    Point mPoint;
    boolean mVisiblity;

    public Bitmap getBitmap() {
        return mBitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        mBitmap = bitmap;
    }

    public Point getPoint() {
        return mPoint;
    }

    public void setPoint(Point point) {
        mPoint = point;
    }

    public boolean isVisiblity() {
        return mVisiblity;
    }

    public void setVisiblity(boolean visiblity) {
        mVisiblity = visiblity;
    }
}
