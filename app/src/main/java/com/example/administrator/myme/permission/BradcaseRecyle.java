package com.example.administrator.myme.permission;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * 创建日期：2018/6/8 on 15:52
 * 描述:
 * 作者:yuxd Administrator
 */
public class BradcaseRecyle extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, TransparentActivity.class);
        intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);

    }
}
