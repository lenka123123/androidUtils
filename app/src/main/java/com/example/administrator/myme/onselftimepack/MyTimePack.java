package com.example.administrator.myme.onselftimepack;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.myme.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 创建日期：2018/6/7 on 13:23
 * 描述:
 * 作者:yuxd Administrator
 */
public class MyTimePack extends AppCompatActivity {

    private ImageView main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.aaaaaa);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ggg();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        options1Items.clear();
        options1Items.add("托儿索");
        options1Items.add("儿童劫");
        options1Items.add("小学生之手");
        options1Items.add("德玛西亚大保健");
        options1Items.add("面对疾风吧");
        options1Items.add("天王盖地虎");
        options1Items.add("我发一米五");
        options1Items.add("爆刘继芬");

    }
    private static final List<String> options1Items = new ArrayList<>();
    public void gggggg(){
        OptionsPickerView pvOptions = new  OptionsPickerView.Builder(MyTimePack.this, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3 ,View v) {
                //返回的分别是三个级别的选中位置
                String s =  options1Items.get(options1);
                Toast.makeText(MyTimePack.this,s, Toast.LENGTH_LONG).show();

            }
        })
                .setSubmitText("确定")//确定按钮文字
//                        .setCancelText("取消")//取消按钮文字
//                        .setTitleText("城市选择")//标题
                .setSubCalSize(20)//确定和取消文字大小
//                        .setTitleSize(20)//标题文字大小
                .setTitleColor(Color.RED)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
                       .setTitleBgColor(Color.RED)//标题背景颜色 Night mode
//                        .setBgColor(0xFF000000)//滚轮背景颜色 Night mode
//                        .setContentTextSize(18)//滚轮文字大小
//                        .setTextColorCenter(Color.BLUE)//设置选中项的颜色
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
//                        .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
//                        .setLinkage(false)//设置是否联动，默认true
//                        .setLabels("省", "市", "区")//设置选择的三级单位
//                        .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .setCyclic(false, false, false)//循环与否
//                        .setSelectOptions(1, 1, 1)  //设置默认选中项
//                        .setOutSideCancelable(false)//点击外部dismiss default true
//                        .isDialog(true)//是否显示为对话框样式
                .build();
        pvOptions.setPicker(options1Items);
        pvOptions.show();
    }

    public void ggg() {

        final String[] str = new String[10];
        ChangeDatePopwindow mChangeBirthDialog = new ChangeDatePopwindow(MyTimePack.this);
       //  mChangeBirthDialog.setDate("2017", "6", "20");
   //  mChangeBirthDialog.showAtLocation(main, Gravity.BOTTOM, 0, 0);

     mChangeBirthDialog.showAtLocation(this.findViewById(R.id.aaaaaa), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);


        mChangeBirthDialog.setBirthdayListener(new ChangeDatePopwindow.OnBirthListener() {

            @Override
            public void onClick(String year, String month, String day) {
                // TODO Auto-generated method stub
                Toast.makeText(MyTimePack.this, year + "-" + month + "-" + day, Toast.LENGTH_LONG).show();


            }
        });


    }


}
