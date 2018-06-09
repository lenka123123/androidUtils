package com.example.administrator.myme.nested;

import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.administrator.myme.R;

import java.util.function.ToDoubleBiFunction;

/**
 * 创建日期：2018/6/5 on 20:51
 * 描述:
 * 作者:yuxd Administrator
 */
public class NestedMainActivity extends AppCompatActivity {

    private int houre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nested_activity);
        shuuu();
    }

    public void shuuu() {
        new TimePickerDialog(this, AlertDialog.THEME_HOLO_LIGHT, new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                houre = hourOfDay;
                Toast.makeText(NestedMainActivity.this, hourOfDay + "==" + minute, Toast.LENGTH_LONG).show();
            }
        }, 0, 0, true).show();
    }
}
