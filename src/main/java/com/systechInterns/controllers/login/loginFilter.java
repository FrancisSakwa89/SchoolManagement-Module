package com.systechInterns.controllers.login;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(urlPatterns = "/filter")
public class loginFilter implements Filter {
    private static int count = 0;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("UserType");
        String userType = (String) session.getAttribute("userId");

        PrintWriter out=resp.getWriter();
        filterChain.doFilter(req,resp);

        out.print("<br/>Total visitors "+(++count));
        System.out.println("Total number of visitors"+" "+ (count) +" " + username+ " "+ userType);


    }

    @Override
    public void destroy() {

    }
}
