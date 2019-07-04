package edu.bjtu.xxq.log;

import edu.bjtu.xxq.model.SysLog;
import edu.bjtu.xxq.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Aspect
@Component
public class LogAspect {
    private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);
    @Autowired
    private SysLogService sysLogService;

    private SysLog sysLog = new SysLog();

    @Pointcut("execution(public * edu.bjtu.xxq.controller..*.*(..))")
    public void controllerLog() {
    }

    /*
    获得请求的东西
     */
    @Before("controllerLog()")
    public void logBeforeController(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        LOG.info("URL : " + request.getRequestURI().toString());
        LOG.info("HTTP_METHOD : " + request.getMethod());
        LOG.info("IP : " + request.getRemoteAddr());
        LOG.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        LOG.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." +
                joinPoint.getSignature().getName());
        sysLog.setIp(request.getRemoteAddr());
        sysLog.setHTTPMethod(request.getMethod());
        sysLog.setUrl(request.getRequestURI().toString());
    }

    @AfterReturning(returning = "ret", pointcut = "controllerLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        LOG.info("RESPONSE : " + ret);
        sysLog.setResult(ret.toString());
        sysLogService.saveLog(sysLog);
    }
}