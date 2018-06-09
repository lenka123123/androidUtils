package com.example.administrator.myme.timeselector;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.bigkoo.pickerview.OptionsPickerView;
import com.bigkoo.pickerview.TimePickerView;
import com.example.administrator.myme.R;
import com.example.administrator.myme.common.util.ToastUtil;
import com.example.administrator.myme.timeselector.item.ChangeDatePopwindow;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 创建日期：2018/6/7 on 13:23
 * 描述:
 * 仿iOS需要包 ：  'com.contrarywind:Android-PickerView:3.2.4'
 * 作者:yuxd Administrator
 */
public class TimeSelectorActivity extends AppCompatActivity implements View.OnClickListener {

    private static final List<String> options1Items = new ArrayList<>();
    private Context context;

    private Calendar calender;
    private Calendar calender2;
    private String dateStr, mouth1, day1;
    public LinearLayout linearlayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.time_selector_activity);
        linearlayout = findViewById(R.id.linearlayout);
        context = this;
        //日历
        calender = Calendar.getInstance();
        calender2 = Calendar.getInstance();


        findViewById(R.id.time_button1).setOnClickListener(this);
        findViewById(R.id.time_button2).setOnClickListener(this);
        findViewById(R.id.time_button3).setOnClickListener(this);
        findViewById(R.id.time_button4).setOnClickListener(this);
        findViewById(R.id.time_button5).setOnClickListener(this);
        findViewById(R.id.time_button6).setOnClickListener(this);
        findViewById(R.id.time_button7).setOnClickListener(this);
        findViewById(R.id.time_button8).setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        options1Items.clear();
        options1Items.add("德玛西亚大保健");
        options1Items.add("德玛西亚小提莫");
        options1Items.add("德玛西亚亚索");
        options1Items.add("德玛西亚皇子");
        options1Items.add("德玛西亚盖伦");
        options1Items.add("德玛西亚寒冰");
        options1Items.add("德玛西亚光辉女郎");
        options1Items.add("德玛西亚石头人");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.time_button1:
                button1();
                break;
            case R.id.time_button2:
                button2();
                break;
            case R.id.time_button3:
                button3();
                break;
            case R.id.time_button4:
                button4();
                break;
            case R.id.time_button5:
                button5();
                break;
            case R.id.time_button6:
                button6();
                break;
            case R.id.time_button7:
                button7();
                break;
            case R.id.time_button8:
                button8();
                break;

        }
    }


    public void button1() {
        DatePickerDialog dialog = new
                DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int
                    dayOfMonth) {
                if (monthOfYear <= 9) {
                    mouth1 = "0" + (monthOfYear + 1);
                } else {
                    mouth1 = String.valueOf(monthOfYear + 1);
                }
                if (dayOfMonth <= 9) {
                    day1 = "0" + dayOfMonth;
                } else {
                    day1 = String.valueOf(dayOfMonth);
                }
                dateStr = String.valueOf(year) + "-" + mouth1 + "-" + day1;
                ToastUtil.show(dateStr);
            }
        }, calender.get(Calendar.YEAR), calender.get(Calendar.MONTH),
                calender.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    public void button2() {
        TimePickerDialog dialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                ToastUtil.show(String.valueOf(hourOfDay + ":" + minute));

            }
        }, calender2.get(Calendar.HOUR), calender2.get(Calendar.MINUTE), false);
        dialog.show();
    }

    public void button3() {
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date2, View v) {//选中事件回调
                String time = getTime(date2);
                ToastUtil.show(time);
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentSize(20)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }


    public void button4() {
        OptionsPickerView pvOptions = new OptionsPickerView.Builder(context, new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String s = options1Items.get(options1);
                ToastUtil.show(s);
            }
        })
//                        .setSubmitText("确定")//确定按钮文字
//                        .setCancelText("取消")//取消按钮文字
//                        .setTitleText("城市选择")//标题
                .setSubCalSize(20)//确定和取消文字大小
//                        .setTitleSize(20)//标题文字大小
                .setTitleColor(Color.RED)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF333333)//标题背景颜色 Night mode
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


    public void button5() {
        final String[] str = new String[10];
        ChangeDatePopwindow mChangeBirthDialog = new ChangeDatePopwindow(context);
        // mChangeBirthDialog.setDate("2017", "6", "20");
        mChangeBirthDialog.showAtLocation(linearlayout, Gravity.BOTTOM, 0, 0);
        mChangeBirthDialog.setBirthdayListener(new ChangeDatePopwindow.OnBirthListener() {

            @Override
            public void onClick(String year, String month, String day) {
                ToastUtil.show(year + "-" + month + "-" + day);
            }
        });
    }

    public void button6() {
        final String[] str = new String[10];
        final ChangeDatePopwindow2 mChangeBirthDialog = new ChangeDatePopwindow2(context);
        mChangeBirthDialog.setDate("2017", "6", "20");
        mChangeBirthDialog.showAtLocation(linearlayout, Gravity.BOTTOM, 0, 0);
        mChangeBirthDialog.setBirthdayListener(new ChangeDatePopwindow2.OnBirthListener() {
            @Override
            public void onClick(String year, String month, String day) {
                ToastUtil.show(year + "-" + month + "-" + day);
            }
        });
    }

    public void button7() {
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date2, View v) {//选中事件回调
                String time = getTime(date2);
                ToastUtil.show(time);
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH_DAY)//默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentSize(20)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
//                        .setLabel("年","月","日","时","分","秒")
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .isDialog(true)//是否显示为对话框样式  位置居中
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    public void button8() {
        TimePickerView pvTime = new TimePickerView.Builder(context, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date2, View v) {//选中事件回调
                String time = getTime(date2);
                ToastUtil.show(time);
            }
        })
                .setType(TimePickerView.Type.YEAR_MONTH)//默认全部显示
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确定")//确认按钮文字
                .setContentSize(20)//滚轮文字大小
                .setTitleSize(20)//标题文字大小
//                        .setTitleText("请选择时间")//标题文字
                .setOutSideCancelable(true)//点击屏幕，点在控件外部范围时，是否取消显示
                .isCyclic(true)//是否循环滚动
                .setTextColorCenter(Color.BLACK)//设置选中项的颜色
                .setTitleColor(Color.BLACK)//标题文字颜色
                .setSubmitColor(Color.BLUE)//确定按钮文字颜色
                .setCancelColor(Color.BLUE)//取消按钮文字颜色
//                        .setTitleBgColor(0xFF666666)//标题背景颜色 Night mode
//                        .setBgColor(0xFF333333)//滚轮背景颜色 Night mode
//                        .setRange(calendar.get(Calendar.YEAR) - 20, calendar.get(Calendar.YEAR) + 20)//默认是1900-2100年
//                        .setDate(selectedDate)// 如果不设置的话，默认是系统时间*/
//                        .setRangDate(startDate,endDate)//起始终止年月日设定
                     .setLabel("年","月","日","时","分","秒")
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
//                        .isDialog(true)//是否显示为对话框样式
                .build();
        pvTime.setDate(Calendar.getInstance());//注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
        pvTime.show();
    }

    public String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return format.format(date);
    }
}
