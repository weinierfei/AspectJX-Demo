/*
 * ViewClickAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.hujiang.library.aspect;

import android.content.Context;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
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

    //@Before("onClickEntryPoint()")
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
        Log.i(TAG, "-------------------------------------------------------");
        Log.i(TAG, "点击按钮后 ==> 目标对象      : " + joinPoint.getTarget().toString());
        Log.i(TAG, "点击按钮后 ==> AOP代理对象   : " + joinPoint.getThis().toString());
        Log.i(TAG, "-------------------------------------------------------");

        Object object = joinPoint.getArgs()[0];
        if (object instanceof Button) {
            String btnText = ((Button) object).getText().toString();
            int btnId = ((Button) object).getId();
            Log.i(TAG, "Button.text= " + btnText + "      Button.id==" + btnId);
        } else if (object instanceof ImageView) {
            ImageView imageView =(ImageView) object;
            int btnId = imageView.getId();
            String url = (String) imageView.getTag();
            Log.i(TAG, "ImageView.id==" + btnId);
            Log.i(TAG, "ImageView.url==" + url);
        }else if (object instanceof TextView) {
            TextView textView =(TextView) object;
            int btnId = textView.getId();
            String text = textView.getText().toString();
            Context context = textView.getContext();

            Log.i(TAG, "TextView.id==" + btnId);
            Log.i(TAG, "TextView.text==" + text);
            Log.i(TAG, "TextView.Context==" + context);
        }

    }

    @AfterReturning(pointcut = "onClickEntryPoint()")
    public void onClickAfterReturning() {
        Log.i(TAG, "点击执行完以后在执行我 ==>");
    }



}