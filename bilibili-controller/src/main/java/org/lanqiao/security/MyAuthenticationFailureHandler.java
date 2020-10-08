package org.lanqiao.security;



import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//认证失败
@Component
public class MyAuthenticationFailureHandler implements AuthenticationFailureHandler {

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter print = response.getWriter();
        print.print("登陆失败!");
        print.flush();
        print.close();
    }

}