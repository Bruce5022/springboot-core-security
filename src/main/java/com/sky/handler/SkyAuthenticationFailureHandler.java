package com.sky.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SkyAuthenticationFailureHandler implements AuthenticationFailureHandler {
    private ObjectMapper om = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String,Object> param = new HashMap<>();
        param.put("success",false);
        param.put("msg",exception.getMessage());
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(om.writeValueAsString(param));
    }
}
