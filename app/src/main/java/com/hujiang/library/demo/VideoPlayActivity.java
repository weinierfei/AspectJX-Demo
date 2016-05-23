package com.hujiang.library.demo;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/5/20 15:07
 */

public class VideoPlayActivity extends Activity {
    private static final String TAG = "VideoPlayActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aop_activity_layout);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        Log.i(TAG,"屏幕转换++"+newConfig.toString());

    }
}
