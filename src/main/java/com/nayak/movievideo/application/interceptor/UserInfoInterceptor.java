package com.nayak.movievideo.application.interceptor;

import com.nayak.movievideo.application.constant.UserConstant;
import com.nayak.movievideo.domain.user.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by nayak on 04/10/2018.
 */
public class UserInfoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals(UserConstant.UNAUTHENTICATION_USER) ?
                null : (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        super.postHandle(request, response, handler, modelAndView);
    }
}
