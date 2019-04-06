package com.sky.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SkyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private ObjectMapper om = new ObjectMapper();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        Map<String,Object> param = new HashMap<>();
        param.put("success",true);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().write(om.writeValueAsString(param));
    }
}
