package com.systechInterns.controllers.login.basicAuth;

import com.systechInterns.Beans.CodeBeanI;
import com.systechInterns.Beans.LoginBeanI;
import com.systechInterns.library.EmailFormat;
import com.systechInterns.library.UserLogin;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "newPass", urlPatterns = "/newPass")
public class NewPasswordServlet extends HttpServlet {
    @EJB
    LoginBeanI loginBeanI;

    @EJB
    CodeBeanI codeBeanI;
    @EJB
    EmailFormat emailFormat;


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("userId");
        String newPass = req.getParameter("newPass");
        String confirmPass = req.getParameter("pass2");
        HttpSession session = req.getSession();
        try{
            UserLogin userLogin = loginBeanI.findUser(userId);
            if (userLogin != null && newPass.equals(confirmPass)){
                session.setAttribute("password", newPass);
                codeBeanI.sendCode(req);
                req.setAttribute("userId", userId);
                String code = String.valueOf(codeBeanI.sendCode(req));
                String email = userLogin.getEmail();
                String subject = "PassCode";
                String content = "Hi, here is your new passcode kindly use it to confirm you have requested for password change "+" "+ code;
                emailFormat.sendEmail(subject,content,email);
                resp.sendRedirect("passChange");
            }
            else {
                resp.sendRedirect("newPass");
                System.out.println("pass not changed..");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/userLogin/newPass.jsp").forward(req,resp);
    }
}
