package edu.bjtu.xxq.controller;

import com.google.gson.Gson;
import edu.bjtu.xxq.util.LoggerUtil;
import edu.bjtu.xxq.model.RequestLog;
import edu.bjtu.xxq.model.User;
import edu.bjtu.xxq.service.LoggerService;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
    private final Gson gson = new Gson();

    @Autowired
    private LoggerService loggerService;

    @Pointcut("execution(public * edu.bjtu.xxq.controller.BookController.*(..))")
    public void bookQueryPoint() {
    }

    @Before("bookQueryPoint()")
    public void bookQueryLogger() {
        RequestLog log = getRequestLog();
        logger.info(gson.toJson(log));
        loggerService.saveLog(log);
    }

    @Pointcut("execution(public * edu.bjtu.xxq.controller.CartController.*(..))")
    public void cartPoint() {
    }

    @AfterReturning(returning = "r", pointcut = "cartPoint()")
    public void cartLogger(Object r) {
        RequestLog log = getRequestLog();
        if (r.equals(Boolean.TRUE))
            logger.info(gson.toJson(log));
        loggerService.saveLog(log);
    }

    @Pointcut("execution(public * edu.bjtu.xxq.controller.OrderController.*(..))")
    public void orderPoint() {
    }

    @AfterReturning(returning = "r", pointcut = "orderPoint()")
    public void orderLogger(Object r) {
        RequestLog log = getRequestLog();
        if (r.equals(Boolean.TRUE))
            logger.info(gson.toJson(log));
        loggerService.saveLog(log);
    }

    private RequestLog getRequestLog() {
        ServletRequestAttributes requestAttributes
                = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) return null;
        Object token = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        HttpServletRequest request = requestAttributes.getRequest();
        RequestLog log = LoggerUtil.getRequestLog(request);
        String userId = null;
        if (!token.equals("anonymousUser"))
            userId = ((User) token).getId();
        log.setUserId(userId);
        logger.info("request:" + new Gson().toJson(log));
        return log;
    }
}