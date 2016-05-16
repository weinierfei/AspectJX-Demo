package com.hujiang.library.aspect;

import android.util.Log;
import android.widget.AdapterView;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

/**
 * Description:
 * User: guoyongping
 * Date: 2016-05-16
 */
@Aspect
public class MyTest {
    @After("execution(void *.onItemClick(..))")
    public void getonItemClick(JoinPoint joinPoint){
        Log.i("helloAOP", "类名===" + joinPoint.getTarget().getClass().getName());
        Log.i("helloAOP", "类名===" + joinPoint.getKind());
        Log.i("helloAOP", "参数数量===" + joinPoint.getArgs().length);
        int pos = (int)joinPoint.getArgs()[2];
        Log.i("helloAOP", "参数数量===" + ((AdapterView)(joinPoint.getArgs()[0])).getItemAtPosition(pos));

        for (Object  o: joinPoint.getArgs()) {
            Log.i("helloAOP", "参数===" + o.toString());
        }
        Log.i("helloAOP", "类名===" + joinPoint.getStaticPart().toString());
        Log.i("helloAOP", "类名===" + joinPoint.getKind());
    }
}
