package com.weiran.token.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weiran.token.enums.ResponseEnum;
import com.weiran.token.response.ResultVO;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.www.NonceExpiredException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义用户登录失败
 */
public class HttpStatusLoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {
        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding("UTF-8");
        // 防request.getRemoteHost止乱码
        response.setContentType("application/json;charset=UTF-8");
        ResultVO httpResultVO = ResultVO.fail(ResponseEnum.USER_NOT_FOUND);
        if (exception instanceof BadCredentialsException) {
            httpResultVO = ResultVO.fail(ResponseEnum.USER_PASSWORD_VALID);
        } else if (exception instanceof NonceExpiredException) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpResultVO = ResultVO.fail(ResponseEnum.UNAUTHORIZED);
        } else if (exception instanceof InsufficientAuthenticationException) {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpResultVO = ResultVO.fail(ResponseEnum.UNAUTHORIZED);
        }else if (exception instanceof DisabledException) {
            httpResultVO = ResultVO.fail(ResponseEnum.USER_IS_BAN_FOUND);
        }

        response.getWriter().write(new ObjectMapper().writeValueAsString(httpResultVO));
    }
}
