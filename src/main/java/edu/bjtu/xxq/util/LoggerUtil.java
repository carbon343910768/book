package edu.bjtu.xxq.util;

import edu.bjtu.xxq.model.RequestLog;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Enumeration;

public class LoggerUtil {

    public static RequestLog getRequestLog(HttpServletRequest request) {
        LocalDateTime now = LocalDateTime.now();
        return new RequestLog()
                .setDate(now.toLocalDate().toString())
                .setTime(now.toLocalTime().toString())
                .setIp(request.getRemoteAddr())
                .setUri(getFullUri(request))
                .setHeader(getHeader(request))
                ;
    }

    private static String getFullUri(HttpServletRequest request) {
        String uri = request.getRequestURI();
        StringBuilder builder = new StringBuilder();
        try {
            request.setCharacterEncoding("UTF-8");
            Enumeration<String> params = request.getParameterNames();
            while (params.hasMoreElements()) {
                String key = params.nextElement();
                for (String value : request.getParameterValues(key)) {
                    builder.append('&').append(URLEncoder.encode(key, "UTF-8"))
                            .append('=').append(URLEncoder.encode(value, "UTF-8"));
                }
            }
        } catch (UnsupportedEncodingException e) {
            return null;
        }
        if (StringUtils.hasLength(builder))
            builder.setCharAt(0, '?');
        builder.insert(0, uri);
        return builder.toString();
    }

    private static final Base64.Encoder encoder = Base64.getEncoder();

    private static String getHeader(HttpServletRequest request) {
        StringBuilder builder = new StringBuilder();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            Enumeration<String> headers = request.getHeaders(key);
            while (headers.hasMoreElements()) {
                builder.append(key).append(':')
                        .append(headers.nextElement()).append('\n');
            }
        }
        return encoder.encodeToString(builder.toString().getBytes());
    }

//    private static String getBody(HttpServletRequest request){
//        return request.
//    }
}
