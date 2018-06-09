package com.example.administrator.myme;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.WindowManager;

import com.example.administrator.myme.permission.MPermissionsActivity;

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class MainActivity extends MPermissionsActivity {

    private ViewPager viewpager;
    private VerticalTabLayout tablayout;

    private MyPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAdapter = new MyPagerAdapter(getSupportFragmentManager());
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        tablayout = (VerticalTabLayout) findViewById(R.id.vertical_tab);
        viewpager.setAdapter(mAdapter);
        tablayout.setupWithViewPager(viewpager);
      //  onClick3();
    }

    public void onClick3() {
        requestPermission(new String[]{Manifest.permission.CAMERA}, 0x0001);
    }

    /**
     * 权限成功回调函数
     * @param requestCode
     */

    @Override
    public void permissionSuccess(int requestCode) {
        super.permissionSuccess(requestCode);
        switch (requestCode) {
            case 0x0001:
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:13468857714"));
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                MainActivity.this.startActivity(intent);
                break;
        }
    }
}