package com.example.modao.moguindext.Utils.ImageLoader;

/**
 * Created by modao on 16/7/21.
 */
public class MoguResponse<T> {
    public interface Listener<T> {
        public void onSuccess(String json);

        public void onFail();
    }
}
