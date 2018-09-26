package com.nayak.movievideo.application.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by nayak on 26/09/2018.
 */
public class SignInFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        request.setAttribute("userId", request.getParameter("userId"));
        request.setAttribute("failed", true);
        request.getRequestDispatcher("/user/sign-in").forward(request, response);
    }
}
