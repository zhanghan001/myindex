package com.example.modao.moguindext.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.modao.moguindext.MainActivity;
import com.example.modao.moguindext.R;
import com.example.modao.moguindext.Utils.MoguUtils;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;


import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by jamase on 2016-04-09.
 */
public class twitRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public String[] str;
    public ArrayList contentID = new ArrayList<>();
    List<RelativeLayout> rela_list = null;
    public View mView;
    PopupWindow mWindow;
    public Context context;

    public ViewPager mmViewpager;

    public twitRecycleAdapter(Context context, String[] datas) {
        str = datas;
        this.context = context;
        initPopWindow();
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
        public ViewPager mViewPager;
        public View mPopView;
        RelativeLayout mReal;
        LinearLayout mItemParentLinearLayout;
        ImageView img1;
        int bitmapHeight1 = 0;
        int bitmapHeight2 = 0;

        public MyViewHolder1(View itemView) {
            super(itemView);
            mView = itemView;
            view = itemView;

            mItemParentLinearLayout = (LinearLayout) mView.findViewById(R.id.item_parent_linearlayout);
            mItemParentLinearLayout.setBackgroundResource(R.drawable.item_radius_background);
            mItemParentLinearLayout.getLayoutParams();
            text = (TextView) itemView.findViewById(R.id.username_text);
            mPopView = itemView.findViewById(R.id.popwinbut);
            mReal = (RelativeLayout) mView.findViewById(R.id.item_top_rel);
            text_title = (TextView) itemView.findViewById(R.id.user_time_text);
            mViewPager = (ViewPager) itemView.findViewById(R.id.item_viewpager);
            rela_list = new ArrayList<>();
            RelativeLayout rel1 = new RelativeLayout(itemView.getContext());
            RelativeLayout rel2 = new RelativeLayout(itemView.getContext());
            RelativeLayout rel3 = new RelativeLayout(itemView.getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.WRAP_CONTENT);
            img1 = new ImageView(itemView.getContext());
            ImageView img2 = new ImageView(itemView.getContext());
            ImageView img3 = new ImageView(itemView.getContext());
            img1.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img2.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img3.setScaleType(ImageView.ScaleType.CENTER_CROP);
            img1.setLayoutParams(layoutParams);
            img2.setLayoutParams(layoutParams);
            img3.setLayoutParams(layoutParams);
            img1.setBackgroundResource(R.drawable.avator);
            img2.setBackgroundResource(R.drawable.viewpager);
            img3.setBackgroundResource(R.drawable.avator);
            Bitmap bitmap1 = BitmapFactory.decodeResource(mView.getContext().getResources(), R.drawable.avator);
            Bitmap bitmap2 = BitmapFactory.decodeResource(mView.getContext().getResources(), R.drawable.avator);
            bitmapHeight1 = bitmap1.getHeight();
            bitmapHeight2 = bitmap2.getHeight();
            rel1.addView(img1);
            rel2.addView(img2);
            rel3.addView(img3);
            CircleImageView point = new CircleImageView(itemView.getContext());
            point.setBorderWidth(MoguUtils.DipToPixels(itemView.getContext(), 1));
            point.setBorderColor(Color.WHITE);
            point.setImageResource(R.drawable.amq);
            int marginlaft = MoguUtils.DipToPixels(itemView.getContext(), 230);
            int margintop = MoguUtils.DipToPixels(itemView.getContext(), 230);
            RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(MoguUtils.DipToPixels(itemView.getContext(), 11)
                    , MoguUtils.DipToPixels(itemView.getContext(), 11));
//            p.width =;
//            p.height = 30;
            p.leftMargin = marginlaft;
            p.topMargin = margintop;
            point.setLayoutParams(p);
            rela_list.add(rel1);
            rel1.addView(point);
            rela_list.add(rel2);
            rela_list.add(rel3);
            itemViewpagerAdapter adapter = new itemViewpagerAdapter(rela_list);
            mViewPager.setAdapter(adapter);
            mViewPager.setPageTransformer(false, new CusPageTransformer());

//            text.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    text.setTextColor(v.getResources().getColor(R.color.colorAccent));
//                }
//            });
            mPopView.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                // 在底部显示
                                                mWindow.showAtLocation(((MainActivity) context).findViewById(R.id.index_scrollview),
                                                        Gravity.BOTTOM, 0, 0);
                                                WindowManager.LayoutParams params = ((MainActivity) context).getWindow().getAttributes();
                                                params.alpha = 0.7f;
                                                ((MainActivity) context).getWindow().setAttributes(params);

                                            }


                                        }
            );

        }

        public class CusPageTransformer implements ViewPager.PageTransformer {

            @Override
            public void transformPage(View page, float position) {
//            page.setAlpha((float) (1 - position));
//                page.setScaleY(1 + Math.abs(position));
                LinearLayout.LayoutParams ls = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, bitmapHeight1);

                if (position >= 0 && position < 2) {
                    switch (mViewPager.getCurrentItem()) {
                        case 2:

                        case 0:
                            ls.height = (int) ((Math.abs(position)) * bitmapHeight2);
                            break;
                        case 1:
                            ls.height = (int) ((Math.abs(position)) * bitmapHeight1);
                            break;


                    }

                    mViewPager.setLayoutParams(ls);
                    Log.e("---------------position", position + "");
//            page.setLayoutParams(layoutParams);
                }
            }
        }

    }


    public void initPopWindow() {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View mPopView = inflater.inflate(R.layout.pop_window, null);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()
        mWindow = new PopupWindow(mPopView,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        mWindow.setFocusable(true);

// 这里检验popWindow里的button是否可以点击
        Button first = (Button) mPopView.findViewById(R.id.first);
        Button cancle = (Button) mPopView.findViewById(R.id.second);
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mWindow.dismiss();
            }
        });
        first.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SuperToast.create(context, "取消关注", SuperToast.Duration.MEDIUM,
                        Style.getStyle(Style.RED, SuperToast.Animations.FLYIN)).show();
                mWindow.dismiss();
            }
        });
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        mWindow.setBackgroundDrawable(dw);
        // 设置popWindow的显示和消失动画
        mWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        //popWindow消失监听方法
        mWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {

            @Override
            public void onDismiss() {
                mWindow.dismiss();
                WindowManager.LayoutParams params = ((MainActivity) context).getWindow().getAttributes();
                params.alpha = 1f;
                ((MainActivity) context).getWindow().setAttributes(params);
                System.out.println("popWindow消失");
            }
        });
    }


}
