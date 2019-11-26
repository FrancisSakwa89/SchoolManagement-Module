package com.systechInterns.controllers.login.basicAuth;

import com.systechInterns.Beans.CodeBeanI;
import com.systechInterns.library.EmailFormat;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
            HttpSession session = req.getSession();
            String mail = String.valueOf(session.getAttribute("email"));
            String userId = String.valueOf(session.getAttribute("userId"));
//            String email = (String) req.getAttribute("email");

            String subject = "Your User Code";
            req.setAttribute("userId", userId);
            System.out.println(mail +" "+ userId);
            String code = String.valueOf(codeBeanI.sendCode(req));
            String content = "Hi, here is your user code kindly use it to login "+" "+ code;


            try {
                emailFormat.sendEmail(subject,content,mail);

            }catch (Exception e){
                System.out.println("error,..");
                e.printStackTrace();
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Error..");
        }
        resp.sendRedirect("code");
    }
}
