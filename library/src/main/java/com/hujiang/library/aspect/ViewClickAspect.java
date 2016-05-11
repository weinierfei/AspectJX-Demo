/*
 * ViewClickAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.hujiang.library.aspect;

import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * class description here
 *
 * @author simon
 * @version 1.0.0
 * @since 2016-03-04
 */

@Aspect
public class ViewClickAspect {

    private static final String TAG = "ViewClickAspect";

    @After("execution(* android.app.Activity.dispatchTouchEvent(..))")
    public void dispatchTouchEventMethod(JoinPoint joinPoint) throws Throwable {
        Log.i(TAG, "触摸事件==" + joinPoint.getSignature() + "       getThis==" + joinPoint.getThis());
    }


    @After("execution(* android.view.View.OnClickListener.onClick(..))")
    public void ononClickMethod(JoinPoint joinPoint) throws Throwable {
        Log.i(TAG, "点击事件==" + joinPoint.getSignature());
    }


    @Pointcut("execution(* android.view.View.OnClickListener.onClick(..))")
    public void onClickEntryPoint() {
    }

    @Before("onClickEntryPoint()")
    public void onClickBefore(JoinPoint joinPoint) {
        Log.i(TAG, "点击按钮前==> Clicked on : " + ((Button) joinPoint.getArgs()[0]).getText());
    }

    //@Around("onClickEntryPoint()")
    public void onClickAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e(TAG, "替换点击事件方法 ==> Clicked on : " + ((Button) joinPoint.getArgs()[0]).getText());

        joinPoint.proceed();
    }

    @After("onClickEntryPoint()")
    public void onClickAfter(JoinPoint joinPoint) {
//        Log.i(TAG, "点击按钮后 ==> Clicked on : " + ((Button) joinPoint.getArgs()[0]).getText());
        Log.i(TAG, "点击按钮后 ==> Clicked on : " + joinPoint.getArgs().length);
        Log.i(TAG, "点击按钮后 ==> Clicked on : " + joinPoint.getArgs()[0].getClass().getName());

        Object object = joinPoint.getArgs()[0];
        if (object instanceof Button) {
            String btnText = ((Button) object).getText().toString();
            int btnId = ((Button) object).getId();
            Log.i(TAG, "Button.text= " + btnText + "      Button.id==" + btnId);
        } else if (object instanceof ImageView) {
            int btnId = ((ImageView) object).getId();
            Log.i(TAG, "ImageView.id==" + btnId);
        }

    }

    @AfterReturning(pointcut = "onClickEntryPoint()")
    public void onClickAfterReturning() {
        Log.i(TAG, "点击执行完以后在执行我 ==>");
    }

}