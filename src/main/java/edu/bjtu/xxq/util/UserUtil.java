package edu.bjtu.xxq.util;

import com.google.gson.Gson;
import edu.bjtu.xxq.model.User;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtil {

    public static Integer getUserId() {
        Object token = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        System.out.println(new Gson().toJson(token));
        if (!token.equals("anonymousUser"))
            return Integer.valueOf(((User) token).getId());
        return null;
    }
}
