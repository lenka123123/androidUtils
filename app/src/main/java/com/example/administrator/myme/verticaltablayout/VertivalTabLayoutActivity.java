package com.example.administrator.myme.verticaltablayout;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.TabItem;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;

import com.example.administrator.myme.R;
import com.example.administrator.myme.verticaltablayout.childfragment.ChildFragment;
import com.example.administrator.myme.verticaltablayout.childfragment.CommonFragment;

import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.TabAdapter;
import q.rorbin.verticaltablayout.widget.TabView;

import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建日期：2018/6/9 on 17:23
 * 描述:
 * 作者:yuxd Administrator
 */
public class VertivalTabLayoutActivity extends FragmentAddAndRemove {

    private VerticalTabLayout verticalTabLayout;
    private FrameLayout frameLayout;
    private Context mContext;
    private String[] title;
    private List fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_vertical_tablayout);
        verticalTabLayout = findViewById(R.id.verticaltablayout);
        frameLayout = findViewById(R.id.framelayout);

        initData();
        initView();
    }

    private void initData() {
        title = new String[]{"邀约", "详情"};
        fragmentList = new ArrayList();
        fragmentList.add(0, new ChildFragment());
        fragmentList.add(0, new CommonFragment());
    }

    private void initView() {
        verticalTabLayout.setTabAdapter(new TabAdapter() {


            @Override
            public int getCount() {
                return title.length;
            }

            @Override
            public TabView.TabBadge getBadge(int position) {
                return null;
            }

            @Override
            public TabView.TabIcon getIcon(int position) {
                return null;
            }

            @Override
            public TabView.TabTitle getTitle(int position) {
                return new TabView.TabTitle.Builder()
                        .setContent(title[position])
                        .setTextColor(ContextCompat.getColor(mContext, R.color.ccc), ContextCompat.getColor(mContext, R.color.colorPrimaryDark))
                        .build();
            }

            @Override
            public int getBackground(int position) {
                return R.drawable.selector_tab_bg_color;
            }
        });

        verticalTabLayout.addOnTabSelectedListener(new VerticalTabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabView tab, int position) {

            }

            @Override
            public void onTabReselected(TabView tab, int position) {

            }
        });


    }



}
