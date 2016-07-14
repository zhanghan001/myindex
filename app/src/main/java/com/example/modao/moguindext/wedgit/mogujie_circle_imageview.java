package com.example.modao.moguindext.wedgit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.modao.moguindext.R;

/**
 * Created by modao on 16/7/14.
 */
public class Mogujie_circle_imageview extends ImageView {
    public int mMogujie_circle_range = 0;
    public Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    public Bitmap mBitmap = null;

    public Mogujie_circle_imageview(Context context) {
        super(context);
        init();
    }

    public Mogujie_circle_imageview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Mogujie_circle_imageview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.Mogujie_circle_imageview);
        mMogujie_circle_range = a.getDimensionPixelOffset(R.styleable.Mogujie_circle_imageview_Mogujie_circle_range, 50);
        a.recycle();
        init();
    }

    private void init() {
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        Rect rect = new Rect(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        Rect rect2 = new Rect(0, 0, getWidth(), getHeight());
        mPaint.reset();

        canvas.drawBitmap(getRoundBitmap(mBitmap), rect, rect2, mPaint);

    }

    public Bitmap getRoundBitmap(Bitmap bitmap) {
        float r;
//        final  BitmapFactory.Options options =new BitmapFactory.Options();
//        options.inJustDecodeBounds=true;
//        BitmapFactory.decodeResource()
        Bitmap output = Bitmap.createBitmap(getWidth(),
                getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Matrix matrix = new Matrix();
        matrix.postScale(((float) getWidth())/ bitmap.getWidth(),((float) getWidth())/bitmap.getWidth()); //长和宽放大缩小的比例
        Bitmap resizeBmp = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);

        final Rect rect = new Rect(0, 0, getWidth(), getHeight());
        if (bitmap.getWidth() > bitmap.getHeight()) {
            r =getHeight();
        } else {
            r = getWidth();
        }
        canvas.drawCircle(r / 2, r / 2, r / 2, mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        canvas.drawBitmap(resizeBmp,rect,rect,mPaint);
        return output;
    }
    // TODO  use bitmap factory to scale bitmap
//    public int calculateInSampleSize(BitmapFactory.Options op, int reqWidth,
//                                     int reqheight) {
//        int originalWidth = op.outWidth;
//        int originalHeight = op.outHeight;
//        int inSampleSize = 1;
//        if (originalWidth > reqWidth || originalHeight > reqheight) {
//            int halfWidth = originalWidth / 2;
//            int halfHeight = originalHeight / 2;
//            while ((halfWidth / inSampleSize > reqWidth)
//                    &&(halfHeight / inSampleSize > reqheight)) {
//                inSampleSize *= 2;
//
//            }
//        }
//        return inSampleSize;
//    }
}
