package edu.bjtu.xxq.log;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.RequestLog;
import edu.bjtu.xxq.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Base64;
import java.util.Enumeration;

@Aspect
@Component
public class LoggerAspect {

    private final Logger logger = LoggerFactory.getLogger(LoggerAspect.class);

    @Autowired
    private LoggerService loggerService;

    @Pointcut("execution(public * edu.bjtu.xxq.controller..*.*(..))")
    public void requestLogger() {
    }

    @Before("requestLogger()")
    public void logRequest(JoinPoint joinPoint) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) return;
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        RequestLog log = getRequestLog(request);
        logger.info("request:" + new Gson().toJson(log));
    }

//    @AfterReturning(returning = "ret", pointcut = "requestLogger()")
//    public void doAfterReturning(Object ret) throws Throwable {
//    }

    private RequestLog getRequestLog(HttpServletRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return new RequestLog()
                .setDate(now.toLocalDate().toString())
                .setTime(now.toLocalTime().toString())
                .setIp(request.getRemoteAddr())
                .setUri(getFullUri(request))
                ;
    }

    private static String getFullUri(HttpServletRequest request) {
        String uri = request.getRequestURI();
        StringBuilder builder = new StringBuilder();
        Enumeration<String> params = request.getParameterNames();
        while (params.hasMoreElements()) {
            String next = params.nextElement();
            String[] x = request.getParameterValues(next);
            System.out.println(Arrays.toString(x));
            builder.append('&').append(next).append('=').append(request.getParameter(next));
        }
        if (StringUtils.hasLength(builder))
            builder.setCharAt(0, '?');
        try {
            System.out.println(request.getQueryString());
            System.out.println(builder);
            System.out.println(URLEncoder.encode(builder.toString(), "UTF-8"));
            return uri + URLEncoder.encode(builder.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }

    private static final Base64.Encoder encoder = Base64.getEncoder();

    private static String getHeader(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String next = headerNames.nextElement();
            builder.append(next).append(':').append(request.getHeader(next)).append('\n');
        }
        return encoder.encodeToString(builder.toString().getBytes());
    }

//    private static String getBody(HttpServletRequest request){
//        return request.
//    }
}