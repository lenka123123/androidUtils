package com.example.administrator.myme;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;

import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

public class Myapp extends Application {

    public static NotificationManager notificationManager;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.cancelAll();

    }
}
