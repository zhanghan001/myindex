package com.example.modao.moguindext.Utils.ImageLoader;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by modao on 16/7/20.
 */
public class ImageLoader {
    private LruCache<String, Bitmap> mMemoryCache;
    private DiskLruCache mDiskLruCcache;
    private Context mContext;

    private ImageLoader(Context context) {
        mContext = context.getApplicationContext();
        int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        int cacheSize = maxMemory / 8;

    }
}
