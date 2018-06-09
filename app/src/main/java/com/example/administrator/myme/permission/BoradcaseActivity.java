package com.example.administrator.myme.permission;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.administrator.myme.R;

/**
 * 创建日期：2018/6/8 on 15:48
 * 描述:
 * 作者:yuxd Administrator
 */
public class BoradcaseActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.aaaaaa).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoradcaseActivity.this,BradcaseRecyle.class);

//intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);//前台广播（默认是后台广播）
                sendBroadcast(intent);
            }
        });

    }
}
