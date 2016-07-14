package com.example.modao.moguindext.wedgit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
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
        mBitmap = getRoundBitmap();
        mBitmap=Bitmap.createBitmap(mBitmap)
        float r;
//        super.onDraw(canvas);
        if (mBitmap.getWidth() > mBitmap.getHeight()) {
            r = mBitmap.getHeight();
        } else {
            r = mBitmap.getWidth();
        }
//        RectF rect = new RectF(0, 0, r, r);
        canvas.drawCircle(10,10,50,mPaint);

    }

    public Bitmap getRoundBitmap() {
        mBitmap = ((BitmapDrawable) getDrawable()).getBitmap();
        return mBitmap;
    }

}
