package com.example.modao.moguindext.Utils;

import android.content.Context;

/**
 * Created by modao on 16/7/19.
 */
public class MoguDip2px {
    public static int DipToPixels(Context context, int dip) {
        final float SCALE = context.getResources().getDisplayMetrics().density;
        float valueDips = dip;
        int valuePixels = (int) (valueDips * SCALE + 0.5f);
        return valuePixels;
    }

}
