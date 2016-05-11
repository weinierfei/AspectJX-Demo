package com.hujiang.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
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

    @Pointcut("execution(* android.widget.AdapterView.OnItemClickListener.onItemClick(..))")
    public void onItemClickPoint() {
    }

    @After("onItemClickPoint()")
    public void afteronItemClick(ProceedingJoinPoint joinPoint) {

    }

}
