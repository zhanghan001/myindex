package com.example.modao.moguindext.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.MailTo;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.modao.moguindext.R;
import com.example.modao.moguindext.wedgit.DividerItemDecoration;


import java.util.ArrayList;
import java.util.List;


/**
 * Created by jamase on 2016-04-09.
 */
public class twitRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public String[] str;
    public ArrayList contentID = new ArrayList<>();
    List<RelativeLayout> rela_list = null;

    public twitRecycleAdapter(String[] datas) {
        str = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_active_item, parent, false);
        RecyclerView.ViewHolder hoder = new MyViewHolder1(v);
        return hoder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final MyViewHolder1 mholder = (MyViewHolder1) holder;
    }

    @Override
    public int getItemCount() {
        return str.length;
    }

    public class MyViewHolder1 extends RecyclerView.ViewHolder {
        public TextView text;
        public TextView text_title;
        public View view;
        public ViewPager viewPager;

        public MyViewHolder1(View itemView) {
            super(itemView);
            view = itemView;
            text = (TextView) itemView.findViewById(R.id.username_text);
            text_title = (TextView) itemView.findViewById(R.id.user_time_text);
            viewPager = (ViewPager) itemView.findViewById(R.id.item_viewpager);
            rela_list = new ArrayList<>();
            RelativeLayout rel1 = new RelativeLayout(itemView.getContext());
            RelativeLayout rel2 = new RelativeLayout(itemView.getContext());
            RelativeLayout rel3 = new RelativeLayout(itemView.getContext());
            ImageView img1 = new ImageView(itemView.getContext());
            ImageView img2 = new ImageView(itemView.getContext());
            ImageView img3 = new ImageView(itemView.getContext());
            img1.setBackgroundResource(R.drawable.avator);
            img2.setBackgroundResource(R.drawable.avator);
            img3.setBackgroundResource(R.drawable.avator);
            rel1.addView(img1);
            rel2.addView(img2);
            rel3.addView(img3);
            ImageView point = new ImageView(itemView.getContext());
            point.setImageResource(R.drawable.avz);
            int marginlaft = DipToPixels(itemView.getContext(), 230);
            int margintop = DipToPixels(itemView.getContext(), 230);
            RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(40, 40);
//            p.width =;
//            p.height = 30;
            p.leftMargin = marginlaft;
            p.topMargin =margintop;
            point.setLayoutParams(p);
            rela_list.add(rel1);
            rel1.addView(point);
            rela_list.add(rel2);
            rela_list.add(rel3);
            itemViewpagerAdapter adapter = new itemViewpagerAdapter(rela_list);
            viewPager.setAdapter(adapter);
//            text.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    text.setTextColor(v.getResources().getColor(R.color.colorAccent));
//                }
//            });
        }
    }

    public int DipToPixels(Context context, int dip) {
        final float SCALE = context.getResources().getDisplayMetrics().density;
        float valueDips = dip;
        int valuePixels = (int) (valueDips * SCALE + 0.5f);
        return valuePixels;
    }

}
