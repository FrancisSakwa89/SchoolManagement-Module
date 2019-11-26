package com.systechInterns.library;

import com.systechInterns.Beans.LoginBeanI;

import java.io.IOException;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Stateless
@Local
public class EmailFormat {
    private String host;
    private String port;
    private String email;
    private String name;
    private String pass;

    private void init() {

        host = ("smtp.gmail.com");
        port = ("587");
        email = ("bursting.reports@gmail.com");
        name = ("bursting.reports@gmail.com");
        pass = ("Bursting123");
    }

//    private String host;
//    private String port;
//    private String user;
//    private String pass;
//    private String email;
//
//    public void init() {
//        // reads SMTP server setting from web.xml file
//        ServletContext context=getServletContext();          ;
//        host = context.getInitParameter("host");
//        port = context.getInitParameter("port");
//        user = context.getInitParameter("user");
//        pass = context.getInitParameter("pass");
//    }


    @EJB
    LoginBeanI loginBeanI;

    public void sendEmail(String subject, String content, String recipient) {
        if (recipient != null) {

            try {
                init();
                EmailUtility.sendEmail(host, port, email, pass, content,
                        recipient, subject, "sakwafrancis89@gmail.com");
            } catch (Exception ex) {
                ex.printStackTrace();
            }

        }else {
            System.out.println("user not found");
        }
    }


}
