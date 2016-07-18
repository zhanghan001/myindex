package com.example.modao.moguindext.wedgit;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.widget.Scroller;

/**
 * Created by modao on 16/7/18.
 */
public class mogujieCoordinateLayout extends CoordinatorLayout {
    /**
     * 用于完成滚动操作的实例
     */
    private Scroller mScroller;

    /**
     * 判定为拖动的最小移动像素数
     */
    private int mTouchSlop;

    /**
     * 手机按下时的屏幕坐标
     */
    private float mXDown;

    /**
     * 手机当时所处的屏幕坐标
     */
    private float mXMove;

    /**
     * 上次触发ACTION_MOVE事件时的屏幕坐标
     */
    private float mXLastMove;

    /**
     * 界面可滚动的左边界
     */
    private int leftBorder;

    /**
     * 界面可滚动的右边界
     */
    private int rightBorder;

    public mogujieCoordinateLayout(Context context) {

        super(context);
        mScroller = new Scroller(context);
    }

    public mogujieCoordinateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mScroller = new Scroller(context);
    }

    public mogujieCoordinateLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        int dey = dy-scY;
//        mScroller.startScroll(mScroller.getFinalX(), mScroller.getFinalY(), dx, dy, 1000);
        mScroller.startScroll(0, scY, 0, dey, 300);

        invalidate();
        //使用scrollTo一步到位
        //scrollTo(curScreen * MultiScreenActivity.screenWidth, 0);
    }
}
