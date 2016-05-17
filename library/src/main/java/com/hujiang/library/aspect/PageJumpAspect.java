package com.hujiang.library.aspect;

import android.content.Intent;
import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/5/17 11:55
 */
@Aspect
public class PageJumpAspect {

    private static final String TAG = "PageJumpAspect";

    @After("call(void * .startActivity(..))")
    public void startJump(JoinPoint joinPoint){
        Log.i(TAG, "方法所在类名(全路径)===" + joinPoint.getTarget().getClass().getName());
        Log.i(TAG, "资源相关.类名===" + joinPoint.getSourceLocation().getFileName());
        Log.i(TAG, "资源相关.代码所在行数===" + joinPoint.getSourceLocation().getLine());
        Log.i(TAG, "连接点类型===" + joinPoint.getKind());
        int length = joinPoint.getArgs().length;
        Log.i(TAG, "参数数量===" + length);
        for (int i = 0; i < length; i++) {
            Log.i(TAG, "参数" + i + "==" + joinPoint.getArgs()[i].toString());
        }

        Intent intent = (Intent)joinPoint.getArgs()[0];
        Log.i(TAG, "获取页面跳转时的参数===" + intent.getExtras().toString());




//        //获取所点击的列表的位置
//        int pos = (int) joinPoint.getArgs()[2];
//        Log.i(TAG, "当前点击的item上的数据===" + ((AdapterView) (joinPoint.getArgs()[0])).getItemAtPosition(pos));
    }

    @After("call(void * .onPageSelected(..))")
    public void onPageSelected(JoinPoint joinPoint){
        Log.i(TAG, "方法所在类名(全路径)===" + joinPoint.getTarget().getClass().getName());
        Log.i(TAG, "资源相关.类名===" + joinPoint.getSourceLocation().getFileName());
        Log.i(TAG, "资源相关.代码所在行数===" + joinPoint.getSourceLocation().getLine());
        Log.i(TAG, "连接点类型===" + joinPoint.getKind());
        int length = joinPoint.getArgs().length;
        Log.i(TAG, "参数数量===" + length);
        for (int i = 0; i < length; i++) {
            Log.i(TAG, "参数" + i + "==" + joinPoint.getArgs()[i].toString());
        }
    }
}
