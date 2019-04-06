package com.sky.filter;

import com.sky.exception.ImageCodeException;
import com.sky.handler.SkyAuthenticationFailureHandler;
import org.springframework.security.core.AuthenticationException;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ImageCodeAuthenticationFilter extends OncePerRequestFilter {

    private SkyAuthenticationFailureHandler failureHandler;

    public void setFailureHandler(SkyAuthenticationFailureHandler failureHandler) {
        this.failureHandler = failureHandler;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/userlogin")) {
            try {
                // 校验验证码

                // 获取用户输入的验证码
                String imageCode = request.getParameter("imageCode");
                if (StringUtils.isEmpty(imageCode)) {
                    throw new ImageCodeException("验证码必须输入");
                }

                //获取系统生成的验证码
                String code = (String) request.getSession().getAttribute("key");
                if (!code.trim().equalsIgnoreCase(imageCode)) {
                    throw new ImageCodeException("验证码不一致");
                }
            } catch (AuthenticationException e) {
                // 交给自定义错误handler来处理
                failureHandler.onAuthenticationFailure(request, response, e);
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
