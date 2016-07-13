package com.example.modao.moguindext.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

/**
 * Created by modao on 16/7/13.
 */
public class itemViewpagerAdapter extends PagerAdapter {
    List<RelativeLayout> list;

    itemViewpagerAdapter(List<RelativeLayout> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
    @Override
    public int getItemPosition(Object object) {
        // TODO Auto-generated method stub
        return super.getItemPosition(object);
    }

    @Override
    public void destroyItem(View arg0, int arg1, Object arg2) {
        // TODO Auto-generated method stub

    }

//    @Override
//    public Object instantiateItem(View arg0, int arg1) {
//        // TODO Auto-generated method stub
//        // ((ViewPager) arg0).addView(list.get(arg1));
//        // return list.get(arg1);
//        arg1 %= list.size();
//        if (arg1 < 0) {
//            arg1 = list.size() + arg1;
//        }
//
//        return new View(get);
//    }
}
