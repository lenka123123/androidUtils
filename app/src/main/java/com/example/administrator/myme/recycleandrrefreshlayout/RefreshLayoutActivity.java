package com.example.administrator.myme.recycleandrrefreshlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.administrator.myme.R;
import com.example.administrator.myme.verticaltablayout.FragmentAddAndRemove;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;

/**
 * 创建日期：2018/6/8 on 17:57
 * 描述:
 * 作者:yuxd Administrator
 */
public class RefreshLayoutActivity extends AppCompatActivity {
    private RefreshLayout refreshLayout;
    private ListView listview;
    private ArrayList list;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.refreshlayout);
        refreshLayout = (RefreshLayout) findViewById(R.id.refreshLayout);
        listview = findViewById(R.id.listview);
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000, false);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                list.clear();
                for (int i = 0; i < 50; i++) {
                    list.add("111" + i);
                }
                adapter.notifyDataSetChanged();
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
        //构造数据源
        list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add("数据源" + i);
        }
        //为适配器添加数据源
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, list);
//为listView的容器添加适配器
        listview.setAdapter(adapter);
    }
}
