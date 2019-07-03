package com.bjtuxxq.demo.log;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(test.Log)")
    public void loPointCut(){

    }
}
