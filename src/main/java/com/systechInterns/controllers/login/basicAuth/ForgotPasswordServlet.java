package com.systechInterns.controllers.login.basicAuth;

import com.sun.mail.util.MailSSLSocketFactory;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.EmailFormat;
import com.systechInterns.library.EmailUtility;
import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "resetPassword", urlPatterns = "/resetPassword")
public class ForgotPasswordServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;

    @EJB
    EmailFormat emailFormat;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String recipient = req.getParameter("email");
        String subject = "Your Password has been reset";
        UserLogin userLogin = loginBeanI.resetPass(recipient);

        if (recipient != null && userLogin != null){
            String newPassword = userLogin.getPassword();
            String username = userLogin.getUserName();
            String content = "Hi "+ username + "\n " + " these are your details: "+ "\nUsername: " + username + " and "+ "\nPassword: "+ newPassword;
            content += "\nNote: use it for logging in, "
                    + "or change your password after logging in.";

            String message = "";

            try {
                emailFormat.sendEmail(subject,content,recipient);
                message = "Your password has been reset. Please check your e-mail.";
            } catch (Exception ex) {
                ex.printStackTrace();
                message = "There was an error: " + ex.getMessage();
            } finally {
                req.setAttribute("message", message);
                req.getRequestDispatcher("/views/userLogin/message.jsp").forward(req, resp);
            }
        }
        else {
            resp.sendRedirect("login");
        }

        }




    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/views/userLogin/login.jsp").forward(req, resp);
    }
}
