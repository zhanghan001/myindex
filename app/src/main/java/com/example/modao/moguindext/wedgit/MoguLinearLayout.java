package com.example.modao.moguindext.wedgit;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.Scroller;

/**
 * Created by modao on 16/7/18.
 */
public class MoguLinearLayout extends LinearLayout {
    private Scroller mScroller;

    public MoguLinearLayout(Context context) {
        super(context);
        mScroller = new Scroller(context);

    }

    public MoguLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);

    }

    public MoguLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mScroller = new Scroller(context);

    }

    public MoguLinearLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        mScroller = new Scroller(context);

    }

    @Override
    public void computeScroll() {
        // 第三步，重写computeScroll()方法，并在其内部完成平滑滚动的逻辑
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            invalidate();
        }
    }

    public void smoothscrollby(int dx, int dy) {
        int scY = getScrollY();
        int dey = dy - scY;
//        mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(), dx, dy, 1000);
        mScroller.startScroll(0, scY, 0, dey, 300);

        invalidate();
        //使用scrollTo一步到位
        //scrollTo(curScreen * MultiScreenActivity.screenWidth, 0);
    }
}
