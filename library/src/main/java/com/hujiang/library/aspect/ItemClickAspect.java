package com.hujiang.library.aspect;

import android.util.Log;
import android.widget.AdapterView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Description:
 *
 * @author: guoyongping
 * @date: 2016/5/11 20:44
 */
@Aspect
public class ItemClickAspect {

    private static final String TAG = "ItemClickAspect";

    @Pointcut("execution(void *.onItemClick(..))")
    public void onItemClickPoint() {
    }

    @After("onItemClickPoint()")
    public void afteronItemClick(JoinPoint joinPoint) {

        Log.i(TAG, "方法所在类名(全路径)===" + joinPoint.getTarget().getClass().getName());
        Log.i(TAG, "资源相关.类名===" + joinPoint.getSourceLocation().getFileName());
        Log.i(TAG, "资源相关.代码所在行数===" + joinPoint.getSourceLocation().getLine());
        Log.i(TAG, "连接点类型===" + joinPoint.getKind());
        int length = joinPoint.getArgs().length;
        Log.i(TAG, "参数数量===" + length);
        for (int i = 0; i < length; i++) {
            Log.i(TAG, "参数" + i + "==" + joinPoint.getArgs()[i].toString());
        }

        //获取所点击的列表的位置
        int pos = (int) joinPoint.getArgs()[2];
        Log.i(TAG, "当前点击的item上的数据===" + ((AdapterView) (joinPoint.getArgs()[0])).getItemAtPosition(pos));

        Log.i(TAG, "连接点签名===" + joinPoint.getStaticPart().getSignature());
        Log.i(TAG, "连接点唯一标识===" + joinPoint.getStaticPart().getId());
        Log.i(TAG, "连接点类型===" + joinPoint.getStaticPart().getKind());
    }

}
