package com.articleapp.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter", urlPatterns = "/user/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession httpSession =httpServletRequest.getSession();

        if (httpSession != null) {
            String name = (String) httpSession.getAttribute("name");
            String username = (String) httpSession.getAttribute("username");
            if (name != null && username != null) {
                chain.doFilter(request,response);
            }else {
                httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
            }
        }else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
        }

    }
}
