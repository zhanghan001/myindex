package com.example.modao.moguindext.Utils;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.modao.moguindext.MainActivity;
import com.example.modao.moguindext.R;
import com.example.modao.moguindext.wedgit.MogujieLinearLayout;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

/**
 * Created by modao on 16/7/18.
 */
public class MoguRefreshPage {
    int dy;
    MotionEvent ev;
    Context context;
    static boolean isRefreshing = false;
    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT
            , ViewGroup.LayoutParams.MATCH_PARENT);

    public MoguRefreshPage(Context context) {

        this.context = context;
    }

    public boolean Refresh(int dY) {
        if (dY > 165) {
            ((MogujieLinearLayout) ((MainActivity) context).findViewById(R.id.linearlayout_parent))
                    .smoothscrollby(0, -200);
            isRefreshing = true;
            final Rotate3dAnimation animation = new Rotate3dAnimation(0, 3000, 30, 30, 0, true);
            animation.setDuration(10000);
            animation.setInterpolator(new DecelerateInterpolator());
            ((MainActivity) context).findViewById(R.id.reresh_process).startAnimation(animation);

//            layoutParams.setMargins(0, MoguDip2px.DipToPixels(context, 18), 0, 0);//4个参数按顺序分别是左上右下
//            ((MainActivity) context).findViewById(R.id.linearlayout_parent).setLayoutParams(layoutParams);
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    if (context != null) {
                        animation.cancel();

//                        layoutParams.setMargins(0, -MoguDip2px.DipToPixels(context, 32), 0, 0);//4个参数按顺序分别是左上右下
                        ((MogujieLinearLayout) ((MainActivity) context).findViewById(R.id.linearlayout_parent))
                                .smoothscrollby(0, 0);
//                        ((MainActivity) context).findViewById(R.id.linearlayout_parent).setLayoutParams(layoutParams);
                        SuperToast.create(context, "加载完成", SuperToast.Duration.MEDIUM,
                                Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
                    }
                    isRefreshing = false;

                }

            }, 4000);

        } else {
            ((MogujieLinearLayout) ((MainActivity) context).findViewById(R.id.linearlayout_parent))
                    .smoothscrollby(0, 0);
        }
        return false;
    }

    public boolean isRefreshing() {
        return isRefreshing;
    }
}
