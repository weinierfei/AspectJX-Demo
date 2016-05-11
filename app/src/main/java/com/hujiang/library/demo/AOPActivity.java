/*
 * AOPActivity      2016-03-28
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */
package com.hujiang.library.demo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * class description here
 *
 * @author simon
 * @version 1.0.0
 * @since 2016-03-28
 */
public class AOPActivity extends Activity {

    private static final String TAG = "AOPActivity";

    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.aop_activity_layout);
        mButton = (Button) findViewById(R.id.btn_test1);
        ImageView imageView = (ImageView) findViewById(R.id.img_t);
        ImageLoader.getInstance().displayImage("http://cichang.hujiang.com/images/friendquan_share.png", imageView);


        getDatas(1, "ceshi", "123");

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "mButton被点击了");
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "图片被点击了");
            }
        });
    }


    private void getDatas(int i, String ceshi, String s) {
        Log.i(TAG, "getdatas");
    }

    @Override
    protected void onResume() {
        super.onResume();

        new AspectJavaDemo().work();
    }


//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//
//        return super.dispatchTouchEvent(ev);
//    }
}