package com.example.modao.moguindext;

import android.os.Handler;
import android.os.Message;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.modao.moguindext.adapter.mUserInfoRecycleAdapter;
import com.example.modao.moguindext.wedgit.DividerItemDecoration;
import com.example.modao.moguindext.wedgit.MySwipeRefreshLayout;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {
    RecyclerView mRecyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    String[] s = new String[]{"dwda", "dwhnudh", "dwhnudh",
            "dwhnudh", "dwhnudh", "dwhnudh", "dwhnudh", "dwhnudh", "dwhnudh"};
    public mUserInfoRecycleAdapter madapter;
    MySwipeRefreshLayout swipeRefreshLayout;
    AppBarLayout appBarLayout;
    ViewPager viewPager;
    private List<ImageView> list = new ArrayList<ImageView>();
    private List<ImageView> pointList = new ArrayList<ImageView>();
    int num = 0;
    private GuidePageAdapter adapter = null;
    private ViewGroup viewGroup = null;
    public Handler myHandler = null;
    private  Timer timer=null;









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initdata();

    }


    private void initview() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerview.requestDisallowInterceptTouchEvent(false);
        appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setHasFixedSize(true);
        madapter = new mUserInfoRecycleAdapter(s);
        mRecyclerview.setAdapter(madapter);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_MOVE:
//                        swipeRefreshLayout.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:
//                        swipeRefreshLayout.setEnabled(true);
                        break;
                }
                return false;
            }
        });


        viewGroup = (LinearLayout)
                findViewById(R.id.description_layout);

//        swipeRefreshLayout = (MySwipeRefreshLayout) findViewById(R.id.index_swiprefreshlayout);
//        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
//                android.R.color.holo_red_light, android.R.color.holo_orange_light,
//                android.R.color.holo_green_light);

//        swipeRefreshLayout.setOnRefreshListener(new MySwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (MainActivity.this!= null) {
//                            SuperToast.create(MainActivity.this, "加载完成", SuperToast.Duration.MEDIUM,
//                                    Style.getStyle(Style.BLUE, SuperToast.Animations.FLYIN)).show();
//                            swipeRefreshLayout.setRefreshing(false);
//                        }
//
//
//                    }
//                }, 5000);
//
//
//            }
//        });
//        swipeRefreshLayout.setBottomColor(android.R.color.holo_blue_light,
//                android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
//        swipeRefreshLayout.setOnLoadListener(new MySwipeRefreshLayout.OnLoadListener() {
//            @Override
//            public void onLoad() {
//                new Handler().postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        if (MainActivity.this != null) {
//                            SuperToast.create(MainActivity.this, "加载完成", SuperToast.Duration.MEDIUM,
//                                    Style.getStyle(Style.BLUE, SuperToast.Animations.FLYIN)).show();
//                            swipeRefreshLayout.setLoading(false);
//
//                        }
//                    }
//                }, 5000);
//
//            }
//        });
    }

    private void initdata() {
        list.clear();
//        if (list.size() < 7) {
            ImageView imageView0 = new ImageView(MainActivity.this);
//            imageView0.setLayoutParams(fi);
            Glide.with(this).load("http://i12.tietuku.cn/b6db401cce66841e.jpg").centerCrop().into(imageView0);
            ImageView imageView1 = new ImageView(this);
            Glide.with(MainActivity.this).load("http://i12.tietuku.cn/74d28c89f2857852.jpg").centerCrop().
                    into(imageView1);

            ImageView imageView2 = new ImageView(this);
            Glide.with(MainActivity.this).load("http://i12.tietuku.cn/029168290e434623.jpg").centerCrop().
                    into(imageView2);

            ImageView imageView3 = new ImageView(this);
            Glide.with(MainActivity.this).load("http://i12.tietuku.cn/0ceed8e2f8f0c87a.jpg").
                    centerCrop().into(imageView3);
            ImageView imageView4 = new ImageView(this);
            Glide.with(MainActivity.this).load("http://i12.tietuku.cn/0ceed8e2f8f0c87a.jpg").
                    centerCrop().into(imageView4);
            ImageView imageView5 = new ImageView(this);
            Glide.with(MainActivity.this).load("http://i12.tietuku.cn/0ceed8e2f8f0c87a.jpg").
                    centerCrop().into(imageView5);
            ImageView imageView6 = new ImageView(this);
            Glide.with(MainActivity.this).load("http://i12.tietuku.cn/0ceed8e2f8f0c87a.jpg").
                    centerCrop().into(imageView6);


            list.add(imageView0);
            list.add(imageView1);
            list.add(imageView2);
            list.add(imageView3);
            list.add(imageView4);
            list.add(imageView5);
            list.add(imageView6);
//        }
        viewPager.setOnPageChangeListener(MainActivity.this);
        adapter = new GuidePageAdapter();
        viewPager.setAdapter(adapter);
        pointList.clear();

        for (int i = 0; i < list.size(); i++) {
            LinearLayout.LayoutParams margin = new LinearLayout.LayoutParams(
                    21,
                    21);
            DisplayMetrics dm = getResources().getDisplayMetrics();

//            int width = dm.widthPixels;
//            margin.setMargins((width / 2) - list.size() * 50 / 2 + 50 * i - 40,
//                    10, 20, 10);

            margin.setMargins(2,
                    10, 10, 10);

            ImageView yuanimgview = new ImageView(MainActivity.this);
            // ����ÿ��СԲ��Ŀ��
            yuanimgview.setLayoutParams(margin);

            // yuanimageViews = new ImageView[list.size()];

            pointList.add(yuanimgview);
            if (i == 0) {
                // Ĭ��ѡ�е�һ��ͼƬ
                pointList.get(i).setBackgroundResource(R.drawable.abu);
            } else {
                // ����ͼƬ������δѡ��״̬
                pointList.get(i).setBackgroundResource(R.drawable.point);
                pointList.get(i).setAlpha(1F);
            }

            viewGroup.addView(pointList.get(i), margin);

        }
        if (myHandler == null) {
            myHandler = new Handler() {

                public void handleMessage(Message msg) {
                    if (viewPager != null) {

                        if (num == 6) {
                            viewPager.setCurrentItem(num);
                            num = 0;
                        } else {

                            viewPager.setCurrentItem(num);
                            num++;
                        }

                    }

                }

                ;

            };
        }
        mytask task = new mytask();
        if (timer == null) {
            timer = new Timer();
            timer.schedule(task, 0, 2000);
        }

    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int arg0) {
        // TODO Auto-generated method stub
if(list!=null){
    num = arg0;
    for (int i = 0; i < list.size(); i++) {

        pointList.get(i).setBackgroundResource(R.drawable.abu);
        pointList.get(i).setAlpha(1F);

        if (arg0 % list.size() != i) {
            pointList.get(i).setBackgroundResource(R.drawable.point);
            pointList.get(i).setAlpha(1F);
        }
    }
}


        // // yuanimgview.setBackgroundResource(R.drawable.yuan_white);
        // yuanlist.get(3).setBackgroundResource(R.drawable.yuan);
        // yuanlist.get(3).setAlpha(1);
        // // this.();

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
    class mytask extends TimerTask {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            if (myHandler != null) {
                myHandler.sendEmptyMessageDelayed(0, 2000);
            }

        }

    }

    class GuidePageAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            // TODO Auto-generated method stub
            viewPager.removeView(arg0);
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            // TODO Auto-generated method stub
            // ((ViewPager) arg0).addView(list.get(arg1));
            // return list.get(arg1);
            arg1 %= list.size();
            if (arg1 < 0) {
                arg1 = list.size() + arg1;
            }
            ImageView view = list.get(arg1);

            ViewParent vp = view.getParent();
            if (vp != null) {
                ViewGroup parent = (ViewGroup) vp;
                parent.removeView(view);
            }

            viewPager.addView(view);
            // add listeners here if necessary
            return view;
        }

    }

    @Override
    protected void onDestroy() {
        list.clear();
//        rects = null;
        list = null;
        pointList.clear();
        pointList = null;
        timer.cancel();
        super.onDestroy();
    }
}
