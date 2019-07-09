package edu.bjtu.xxq.handler;

import edu.bjtu.xxq.model.ResponseCode;
import edu.bjtu.xxq.model.ResponseJson;
import com.google.gson.Gson;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginHandler
        implements AuthenticationSuccessHandler, AuthenticationFailureHandler {

    private Gson gson = new Gson();
    private String success = gson.toJson(new ResponseJson(ResponseCode.LOGIN_SUCCESS));
    private String fail = gson.toJson(new ResponseJson(ResponseCode.LOGIN_FAIL));
    private String contentType = "application/json;charset=UTF-8";

    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request,
            HttpServletResponse response,
            Authentication authentication
    ) throws IOException, ServletException {
        response.setContentType(contentType);
        response.getWriter().write(success);
    }

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException, ServletException {
        response.setContentType(contentType);
        response.getWriter().write(fail);
    }
}

