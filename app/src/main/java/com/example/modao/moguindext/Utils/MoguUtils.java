package com.example.modao.moguindext.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * Created by modao on 16/7/19.
 */
public class MoguUtils {
    public static int DipToPixels(Context context, int dip) {
        final float SCALE = context.getResources().getDisplayMetrics().density;
        float valueDips = dip;
        int valuePixels = (int) (valueDips * SCALE + 0.5f);
        return valuePixels;
    }

    public static Bitmap scaleBitmap(Bitmap bitmap, float widthScale, float heightScale) {
        Matrix matrix = new Matrix();
        matrix.postScale(widthScale, heightScale); //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        return resizeBmp;
    }


}
