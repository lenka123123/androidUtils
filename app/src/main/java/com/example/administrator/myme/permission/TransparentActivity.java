package com.example.administrator.myme.permission;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.TimeUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.administrator.myme.R;

/**
 * 创建日期：2018/6/8 on 15:57
 * 描述:
 * 作者:yuxd Administrator
 */
public class TransparentActivity extends MPermissionsActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window=getWindow();
        WindowManager.LayoutParams wl = window.getAttributes();
        wl.flags= WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON;
        wl.alpha=0.0f;//这句就是设置窗口里控件的透明度的．０.０全透明．１.０不透明．
        window.setAttributes(wl);

        showNoProject();
    }


    public void showNoProject() {


        AlertDialog.Builder builder = new AlertDialog.Builder(TransparentActivity.this);
        builder.setMessage("当前账号在其他设备登录，请重新登录！");

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {


            }
        });
        builder.setCancelable(false);
        AlertDialog dialog = builder.create();
        //   dialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        dialog.show();
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(TransparentActivity.this.getResources().getColor(R.color.colorAccent));
        dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(TransparentActivity.this.getResources().getColor(R.color.colorPrimaryDark));



    }
}
