package com.example.administrator.myme.common.util;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.StringRes;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myme.R;


/**
 * author:conanaiflj
 * date:2018/5/25 0025
 * description:
 */
public class ToastUtil {
    private static Toast toast;

    private static void makeText(Context context, String content, int duration) {
        if (toast != null) {
            toast.cancel();
        }
        View toastLayout = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.toast_layout, null);
        TextView textView = (TextView) toastLayout.findViewById(R.id.toast_text);
        textView.setText(content);
        toast = new Toast(context);
        toast.setView(toastLayout);
        toast.setDuration(duration);
        toast.setGravity(Gravity.CENTER, 0, DevicesUtils.getScreenHeights(context) / 3);
        toast.show();
    }

    private static void makeText(Context context, @StringRes int id, int duration) {
        makeText(context, context.getResources().getString(id), duration);
    }


    public static void show(@StringRes int id) {
        makeText(CommonUtils.getContext(), id, Toast.LENGTH_LONG);
    }

    public static void showLong(@StringRes int id) {
        makeText(CommonUtils.getContext(), id, Toast.LENGTH_LONG);
    }

    public static void showShort(@StringRes int id) {
        makeText(CommonUtils.getContext(), id, Toast.LENGTH_SHORT);
    }

    public static void show(String content) {
        makeText(CommonUtils.getContext(), content, Toast.LENGTH_LONG);
    }

    public static void showLong(String content) {
        makeText(CommonUtils.getContext(), content, Toast.LENGTH_LONG);
    }

    public static void showShort(String content) {
        makeText(CommonUtils.getContext(), content, Toast.LENGTH_SHORT);
    }


}
