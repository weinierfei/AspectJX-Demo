/*
 * ActivityAspect      2016-03-04
 * Copyright (c) 2016 hujiang Co.Ltd. All right reserved(http://www.hujiang.com).
 * 
 */

package com.hujiang.library.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//import com.hujiang.common.util.ToastUtils;
//import com.hujiang.framework.app.RunTimeManager;

//import com.hujiang.common.util.ToastUtils;
//import com.hujiang.framework.app.RunTimeManager;

/**
 * activity aspect
 *
 * @author simon
 * @version 1.0.0
 * @since 2016-03-04
 */
@Aspect
public class ActivityAspect {

//    @Pointcut("execution(* android.app.Activity.onCreate(..))")
//    public void onCreateCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onResume())")
//    public void onResumeCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onPause(..))")
//    public void onPauseCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onStart(..))")
//    public void onStartCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onStop(..))")
//    public void onStopCutPoint() {
//
//    }
//
//    @Pointcut("execution(* android.app.Activity.onDestroy(..))")
//    public void onDestroyCutPoint() {
//
//    }


    @After("execution(* android.app.Activity.on**(..))")
    public void onResumeMethod(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @Before("call(* com.hujiang.library.demo.AOPActivity.setList())")
    public void println(JoinPoint joinPoint){
        Log.i("helloAOP", "aspect:::我自己的不+printlnBe" + joinPoint.getSignature());
    }
    @After("call(* com.hujiang.library.demo.AOPActivity.setList())")
    public void printlnAf(JoinPoint joinPoint){
        Log.i("helloAOP", "aspect:::我自己的不+printlnAf" + joinPoint.getSignature());
    }

//    @Around("call(* com.hujiang.library.demo.AOPActivity.setList())")
//    public void printlnAR(JoinPoint joinPoint) throws Throwable {
//        Log.i("helloAOP", "aspect:::+printlnAR" + joinPoint.getSignature());
//    }


    ///////////
    @After("execution(* com.hujiang.library.demo.Greeter.**())")
    public void greeterAdvice(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* android.support.v4.app.Fragment.on**(..))")
    public void fragmentMethod(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("call(* com.hujiang.library.demo.AspectJavaDemo.work())")
    public void aspectJavaDemoAdvice(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* com.nostra13.universalimageloader.core.ImageLoader.displayImage(..))")
    public void aspectImageLoader(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
    }

    @After("execution(* com.hujiang.library.demo.NormalClass.**(..))")
    public void aspectNormalClass(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
        Log.i("helloAOP", "aspect:::" + joinPoint.getSourceLocation());
        Log.i("helloAOP", "aspect:::" + joinPoint.getTarget());
    }

    //public Pointcut testAll() : call(public*  *.println(..)) && !within(TestAspect) ;



    @Pointcut("execution(* com.hujiang.library.demo.AOPActivity.onCreate(..)) ||"
            +"execution(* com.hujiang.library.demo.AOPActivity.onStart(..))")
    public void logForActivity(){};


    @Before("logForActivity()")
    public void log(JoinPoint joinPoint){
        //对于使用Annotation的AspectJ而言，JoinPoint就不能直接在代码里得到多了，而需要通过
        //参数传递进来。
        Log.e("helloAOP", "测试"+joinPoint.toShortString());
    }


    @After("call(* com.hujiang.library.demo.AOPActivity.getDatas(..))")
    public void aspectgetDatas(JoinPoint joinPoint) throws Throwable {
        Log.i("helloAOP", "aspect:::" + joinPoint.getSignature());
        Log.i("helloAOP", "this===" + joinPoint.getThis().getClass().getName());
        Log.i("helloAOP", "方法名==" + joinPoint.getSignature().getName());
        final Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Log.i("helloAOP", "参数===" + args[i].toString());
        }
    }
}