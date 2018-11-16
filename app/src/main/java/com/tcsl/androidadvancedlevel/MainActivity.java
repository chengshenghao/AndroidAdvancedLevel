package com.tcsl.androidadvancedlevel;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.tcsl.androidadvancedlevel.TouchEvent.MyTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((MyTextView) findViewById(R.id.my_textview)).setOnClickListener(this);
        ((MyTextView) findViewById(R.id.my_textview)).setOnTouchListener(this);
        //第四章 support annotation使用
        test(null);//分析代码以后会找到这行错误的代码
    }

    private void test(@NonNull String str) {
        Log.i(TAG, "test: " + str);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "dispatchTouchEvent: ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "dispatchTouchEvent: ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "dispatchTouchEvent: ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                Log.i(TAG, "dispatchTouchEvent: ACTION_CANCEL");
                break;
            default:
                break;
        }
        return super.dispatchTouchEvent(event);//方法返回true，当前界面消费时间，返回super.dispatchTouchEvent(event)表示继续分发改时间
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Log.i(TAG, "onTouchEvent:ACTION_DOWN ");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.i(TAG, "onTouchEvent:ACTION_MOVE ");
                break;
            case MotionEvent.ACTION_UP:
                Log.i(TAG, "onTouchEvent:ACTION_UP ");
                break;
            default:
                break;

        }
        return super.onTouchEvent(event);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.my_textview:
                Log.i(TAG, "onClick: my_textview ");
                break;
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        return false;
    }
}
