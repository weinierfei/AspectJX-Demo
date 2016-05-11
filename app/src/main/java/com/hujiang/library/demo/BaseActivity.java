package com.hujiang.library.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/5/11 10:43
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    /****************************************************************/

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    public boolean isInView(View view, MotionEvent event) {
        int clickX = (int) event.getRawX();
        int clickY = (int) event.getRawY();
        //如下的view表示Activity中的子View或者控件
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int x = location[0];
        int y = location[1];
        int width = view.getWidth();
        int height = view.getHeight();
        if (clickX < x || clickX > (x + width) ||
                clickY < y || clickY > (y + height)) {
            return true;  //这个条件成立，则判断这个view被点击了
        }
        return false;
    }


    /**
     * 递归遍历Activity（就是Context）中的所有View，找出被点击的View
     *
     * @param view
     * @param event
     * @return
     */
    private View searchClickView(View view, MotionEvent event) {
        View clickView = null;
        if (isInView(view, event) && view.getVisibility() == View.VISIBLE) {  //这里一定要判断View是可见的
            if (view instanceof ViewGroup) {    //遇到一些Layout之类的ViewGroup，继续遍历它下面的子View
                ViewGroup group = (ViewGroup) view;
                for (int i = group.getChildCount() - 1; i >= 0; i--) {
                    View chilView = group.getChildAt(i);
                    clickView = searchClickView(chilView, event);
                    if (clickView != null) {
                        return clickView;
                    }
                }
            }

            clickView = view;
        }
        return clickView;
    }
}
