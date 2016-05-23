package com.hujiang.library.aspect;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Description:屏幕旋转监听(重力感应)
 *
 * @author: guoyongping
 * @date: 2016/5/20 15:41
 */
@Aspect
public class ScreenChangedAspect {

    private static final String TAG = "ScreenChangedAspect";

    @After("execution(void * .onConfigurationChanged(..))")
    public void onScreenChanged(JoinPoint joinPoint) {
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
