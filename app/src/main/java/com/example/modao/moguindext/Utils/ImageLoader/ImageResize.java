package com.example.modao.moguindext.Utils.ImageLoader;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileDescriptor;


/**
 * Created by modao on 16/7/20.
 */
public class ImageResize {
    public ImageResize() {
    }

    public Bitmap decodeSampledBitmapFromResoure(Resources res, int resid, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resid, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resid, options);
    }

    public Bitmap decodeSampledBitmapFromResoure(FileDescriptor fd, int resid, int reqWidth, int reqHeight) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fd, null, options);
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fd, null, options);
    }

    private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        if (reqWidth == 0 || reqHeight == 0) {
            return 1;
        }
        final int height = options.outHeight;
        final int width = options.outWidth;
        int InSampleSize = 1;
        if (height > reqHeight || width > reqWidth) {
            final int halfHeihgt = height / 2;
            final int halfWidth = width / 2;
            while ((halfHeihgt / InSampleSize) >= reqHeight && (halfWidth / InSampleSize) >= reqWidth) {
                InSampleSize *= 2;
            }
        }
        return InSampleSize;
    }
}
