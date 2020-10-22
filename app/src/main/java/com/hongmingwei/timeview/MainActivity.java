package com.hongmingwei.timeview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hongmingwei.timeview.ui.CustomDatePicker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by hongmingwei on 2016/6/5 18:55
 */
public class MainActivity extends Activity implements View.OnClickListener {

    private RelativeLayout selectDate, selectTime;
    private TextView currentDate, currentTime;
    private CustomDatePicker customDatePicker1, customDatePicker2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectDate = (RelativeLayout) findViewById(R.id.selectDate);
        selectDate.setOnClickListener(this);
        currentDate = (TextView) findViewById(R.id.currentDate);

//        selectTime = (RelativeLayout) findViewById(R.id.selectTime);
//        selectTime.setOnClickListener(this);
//        currentTime = (TextView) findViewById(R.id.currentTime);

        initDatePicker();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.selectDate:
                // 日期格式为yyyy-MM-dd
                customDatePicker1.show(currentDate.getText().toString());
                break;
//            case R.id.selectTime:
//                customDatePicker2.show(currentTime.getText().toString());
//                break;
        }
    }

    private void initDatePicker() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.CHINA);
        String now = sdf.format(new Date());
        currentDate.setText(now.split(" ")[0]);
//        currentTime.setText(now);

        customDatePicker1 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
            @Override
            public void handle(String time) { // 回调接口，获得选中的时间
                currentDate.setText(time.split(" ")[0]);
            }
        }, "1970-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
        customDatePicker1.showSpecificTime(false); // 不显示时和分
        customDatePicker1.setIsLoop(false); // 不允许循环滚动

//        customDatePicker2 = new CustomDatePicker(this, new CustomDatePicker.ResultHandler() {
//            @Override
//            public void handle(String time) { // 回调接口，获得选中的时间
//                currentTime.setText(time);
//            }
//        }, "1970-01-01 00:00", "2030-01-01 00:00"); // 初始化日期格式请用：yyyy-MM-dd HH:mm，否则不能正常运行
//        customDatePicker2.showSpecificTime(true); // 显示时和分
//        customDatePicker2.setIsLoop(true); // 允许循环滚动
    }
}
