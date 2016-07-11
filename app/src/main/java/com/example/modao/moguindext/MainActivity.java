package com.example.modao.moguindext;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.modao.moguindext.adapter.mUserInfoRecycleAdapter;
import com.example.modao.moguindext.wedgit.DividerItemDecoration;
import com.example.modao.moguindext.wedgit.MySwipeRefreshLayout;
import com.github.johnpersano.supertoasts.SuperToast;
import com.github.johnpersano.supertoasts.util.Style;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerview;
    RecyclerView.LayoutManager mLayoutManager;
    String[] s = new String[]{"dwda", "dwhnudh", "dwhnudh",
            "dwhnudh", "dwhnudh", "dwhnudh", "dwhnudh", "dwhnudh", "dwhnudh"};
    public mUserInfoRecycleAdapter madapter;
MySwipeRefreshLayout swipeRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerview = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerview.setLayoutManager(mLayoutManager);
        mRecyclerview.setHasFixedSize(true);
        madapter = new mUserInfoRecycleAdapter(s);
        mRecyclerview.setAdapter(madapter);
        mRecyclerview.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        swipeRefreshLayout = (MySwipeRefreshLayout) findViewById(R.id.index_swiprefreshlayout);
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light,
                android.R.color.holo_green_light);

        swipeRefreshLayout.setOnRefreshListener(new MySwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (MainActivity.this!= null) {
                            SuperToast.create(MainActivity.this, "加载完成", SuperToast.Duration.MEDIUM,
                                    Style.getStyle(Style.BLUE, SuperToast.Animations.FLYIN)).show();
                            swipeRefreshLayout.setRefreshing(false);
                        }


                    }
                }, 5000);


            }
        });
        swipeRefreshLayout.setBottomColor(android.R.color.holo_blue_light,
                android.R.color.holo_red_light, android.R.color.holo_orange_light, android.R.color.holo_green_light);
        swipeRefreshLayout.setOnLoadListener(new MySwipeRefreshLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (MainActivity.this != null) {
                            SuperToast.create(MainActivity.this, "加载完成", SuperToast.Duration.MEDIUM,
                                    Style.getStyle(Style.BLUE, SuperToast.Animations.FLYIN)).show();
                            swipeRefreshLayout.setLoading(false);

                        }
                    }
                }, 5000);

            }
        });
    }
}
