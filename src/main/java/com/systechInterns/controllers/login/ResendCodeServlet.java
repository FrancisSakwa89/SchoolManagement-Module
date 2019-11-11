package com.systechInterns.controllers.login;

import com.systechInterns.Beans.CodeBeanI;
import com.systechInterns.library.EmailFormat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "resend", urlPatterns = "/resend")
public class ResendCodeServlet extends HttpServlet {
    @EJB
    CodeBeanI codeBeanI;

    @EJB
    EmailFormat emailFormat;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String code = String.valueOf(codeBeanI.sendCode(req));

            String email = (String) req.getAttribute("email");
            System.out.println(email);

            String subject = "Your User Code";
            String content = "Hi, here is your user code kindly use it to login "+" "+ code;
            try {
                emailFormat.sendEmail(subject,content,email);
                System.out.println("error,..");

            }catch (Exception e){
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error..");
        }
        resp.sendRedirect("code");
    }
}
