package com.systechInterns.controllers.login;

import com.systechInterns.library.UserLogin;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class AuthFilter implements Filter {
    public AuthFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        UserLogin login = new UserLogin();
        boolean isLoggedIn = false;
        // Check if the user is accessing login page
        if (req.getRequestURI().equals(
                req.getContextPath() + "/pages/login.jsp")) {
            if (isLoggedIn) {
                // Redirect to landing or home page
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect(req.getContextPath()
                        + "/pages/home.jsp");
            } else {
                // Otherwise, nothing to do if he has not logged in
                // pass the request along the filter chain
                chain.doFilter(request, response);
            }
        } else {
            // For all other pages,
            if (isLoggedIn) {
                // Nothing to do
                chain.doFilter(request, response);
            } else {
                // Redirect to login page if he has not logged in
                HttpServletResponse res = (HttpServletResponse) response;
                res.sendRedirect("/views/userLogin/login.jsp");
            }
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {

    }
}