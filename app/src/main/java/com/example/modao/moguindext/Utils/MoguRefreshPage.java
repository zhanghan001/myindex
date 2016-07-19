package com.example.modao.moguindext.Utils;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;

import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

/**
 * Created by modao on 16/7/18.
 */
public class MoguRefreshPage {
    int dy;
    MotionEvent ev;
    Context context;

    public MoguRefreshPage(Context context, int dy) {
        this.dy = dy;
        this.context = context;
    }

    public boolean isRefresh() {
        if (dy > 1604) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (context != null) {
                        SuperToast.create(context, "加载完成", SuperToast.Duration.MEDIUM,
                                Style.getStyle(Style.BLUE, SuperToast.Animations.FLYIN)).show();
                    }

                }

            }, 5000);

        }
        return false;
    }
}
